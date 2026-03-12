package br.unipar.projeto;

import br.unipar.framework.miniframework.Dispatcher;
import br.unipar.framework.miniframework.Request;
import br.unipar.framework.miniframework.Response;
import br.unipar.frameworks.commands.HelloCommand;
import br.unipar.frameworks.commands.SomaCommand;
import br.unipar.frameworks.commands.MultiplicaCommand;
import br.unipar.frameworks.commands.SubtraiCommand;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher();

        dispatcher.register("hello", new HelloCommand());
        dispatcher.register("soma", new SomaCommand());
        dispatcher.register("multiplica", new MultiplicaCommand());
        dispatcher.register("subtrai", new SubtraiCommand());

        Scanner scanner = new Scanner(System.in);

        System.out.println("App iniciado! Digite um comando:" +
                " (Ex: 'hello', 'soma a=2 b=3', 'multiplica a=4 b=5', 'subtrai a=7 b=3') ou 'sair' para encerrar.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if ("sair".equalsIgnoreCase(input)) {
                System.out.println("Encerrando a aplicação. Até logo!");
                break;
            }
            
            Request request = Request.fromInput(input);

            Response response = dispatcher.dispatch(request);

            System.out.println(response);
        }

        scanner.close();
    }
}