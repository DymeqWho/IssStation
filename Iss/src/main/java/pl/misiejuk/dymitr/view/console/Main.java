package pl.misiejuk.dymitr.view.console;

import pl.misiejuk.dymitr.httpclient.ISSHttpClient;
import pl.misiejuk.dymitr.httpclient.Location;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        ISSHttpClient issHttpClient = new ISSHttpClient();
//        System.out.println(issHttpClient.getSpeedOfIss());
        System.out.println("Current Location: ");
        Location location = issHttpClient.getIssCurrentLocation().get().getLocation();
        issHttpClient
                .getApiIssPassTimes(location)
                .stream()
                .flatMap(p -> p.getResponse().stream())
                .map(p ->
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(p.getRisetime() * 1000), TimeZone.getDefault().toZoneId())
                )
                .forEach(System.out::println);
    }
}
