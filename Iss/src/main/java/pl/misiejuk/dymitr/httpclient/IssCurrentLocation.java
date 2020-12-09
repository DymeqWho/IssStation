package pl.misiejuk.dymitr.httpclient;

import com.fasterxml.jackson.annotation.JsonProperty;



public class IssCurrentLocation {

    private long timestamp;
    @JsonProperty("iss_position")
    private Location location;
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}