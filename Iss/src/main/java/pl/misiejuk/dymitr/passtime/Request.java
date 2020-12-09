package pl.misiejuk.dymitr.passtime;

public class Request {

    private double altitude;
    private long datetime;
    private double latitude;
    private double longitude;
    private int passes;

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    @Override
    public String toString() {
        return "Request{" +
                "altitude=" + altitude +
                ", datetime=" + datetime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", passes=" + passes +
                '}';
    }
}
