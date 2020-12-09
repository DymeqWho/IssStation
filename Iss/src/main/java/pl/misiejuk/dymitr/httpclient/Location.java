package pl.misiejuk.dymitr.httpclient;


public class Location {
    private double longitude;
    private double latitude;

    public Location(){

    }

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
