package pl.misiejuk.dymitr.passtime;

public class Response {

    private long duration;
    private long risetime;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getRisetime() {
        return risetime;
    }

    public void setRisetime(long risetime) {
        this.risetime = risetime;
    }

    @Override
    public String toString() {
        return "Response{" +
                "duration=" + duration +
                ", risetime=" + risetime +
                '}';
    }
}
