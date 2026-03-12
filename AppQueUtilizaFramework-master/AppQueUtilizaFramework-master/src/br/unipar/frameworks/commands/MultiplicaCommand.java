package br.unipar.frameworks.commands;

import br.unipar.framework.miniframework.Command;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;

public class MultiplicaCommand implements Command {

    @Override
    public Response execute(Request request) {
        try {
            int a = Integer.parseInt(request.getParam("a"));
            int b = Integer.parseInt(request.getParam("b"));
            int resultado = a * b;
            return new Response("Resultado da multiplicação: " + resultado);
        } catch (Exception e) {
            return new Response("Erro: informe dois números válidos.");
        }
    }
}