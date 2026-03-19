package br.unipar.framework.miniframework;

public class PiHandler implements CommandHandler {

    @Override
    public void handle(Request request, Response response) {
        response.setBody("Valor de PI = " + Math.PI);
    }
}
