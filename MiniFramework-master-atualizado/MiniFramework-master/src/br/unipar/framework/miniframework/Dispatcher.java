package br.unipar.framework.miniframework;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {

    private final Map<String, CommandHandler>
        routes = new HashMap<>();



    public void register(String commandName,
                         CommandHandler handler) {
        routes.put(commandName.toLowerCase(), handler);
    }

    public Response dispatch(Request request) {
        if (request.getCommandName() == null ||
        request.getCommandName().isBlank()) {
            return Response.badResquest("Comando vazio");
        }

        CommandHandler handler = routes.get(
                request.getCommandName().toLowerCase());

        if (handler == null) {
            return Response.notFound("Comando " +
                    request.getCommandName() +
                    " não encontrado");
        }

        return handler.handle(request);

    }



}
