package pl.misiejuk.dymitr.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.misiejuk.dymitr.passtime.PasstimeResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ISSHttpClient {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(ISSHttpClient.class);

    public ISSHttpClient() {
        this.httpClient = HttpClient.newBuilder().build();
        this.objectMapper = new ObjectMapper();
    }

    public Optional<IssCurrentLocation> getIssCurrentLocation() {
        String requestUrl = "http://api.open-notify.org/iss-now.json";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(requestUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            IssCurrentLocation asObject = objectMapper.readValue(body, IssCurrentLocation.class);

            return Optional.ofNullable(asObject);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<PasstimeResponse> getApiIssPassTimes(Location location) {
        String requestUrl = "http://api.open-notify.org/iss-pass.json?lat=" + location.getLatitude() + "&lon=" + location.getLongitude();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(requestUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            PasstimeResponse asObject = objectMapper.readValue(body, PasstimeResponse.class);

            return Optional.ofNullable(asObject);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return Optional.empty();
    }

    public double getSpeedOfIss() {
        Optional<IssCurrentLocation> firstLocation = getIssCurrentLocation();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
        Optional<IssCurrentLocation> secondLocation = getIssCurrentLocation();
        long period = secondLocation.get().getTimestamp() - firstLocation.get().getTimestamp();
        double latitudeDifference = secondLocation.get().getLocation().getLatitude() - firstLocation.get().getLocation().getLatitude();
        double longitudeDifference = secondLocation.get().getLocation().getLongitude() - firstLocation.get().getLocation().getLongitude();
        double distance = 111 * Math.sqrt(Math.pow(latitudeDifference, 2) + Math.pow(longitudeDifference, 2));
        return distance / period;
    }


}