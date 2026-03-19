package br.unipar.framework.miniframework;

public class SqrtHandler implements CommandHandler {

    @Override
    public void handle(Request request, Response response) {
        try {
            String valor = request.getParam("numero");
            double num = Double.parseDouble(valor);

            if (num < 0) {
                response.setBody("Erro: não existe raiz de número negativo.");
                return;
            }

            double resultado = Math.sqrt(num);
            response.setBody("Raiz quadrada de " + num + " = " + resultado);

        } catch (Exception e) {
            response.setBody("Erro ao calcular raiz quadrada.");
        }
    }
}
