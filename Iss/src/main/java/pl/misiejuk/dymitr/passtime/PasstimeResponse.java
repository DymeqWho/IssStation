package pl.misiejuk.dymitr.passtime;

import java.util.List;

public class PasstimeResponse {
    private String message;
    private Request request;
    private List<Response> response;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "PasstimeResponse{" +
                "message='" + message + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
