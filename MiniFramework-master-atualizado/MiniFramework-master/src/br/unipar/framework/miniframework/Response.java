package br.unipar.framework.miniframework;

public class Response {

    private final int status;
    private final String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response ok(String message) {
        return new Response(200, message);
    }

    public static Response badResquest(String message) {
        return new Response(400, message);
    }

    public static Response notFound(String message) {
        return new Response(404, message);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return status + " | " + message;
    }
}
