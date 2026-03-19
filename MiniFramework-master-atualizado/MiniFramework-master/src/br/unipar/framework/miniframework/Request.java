package br.unipar.framework.miniframework;

import java.util.List;

public class Request {

    private final String commandName;
    private final List<String> args;

    public Request(String commandName, List<String> args) {
        this.commandName = commandName;
        this.args = args;
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getArgs() {
        return args;
    }

    public static Request fromInput(String input) {
        if (input == null || input.isBlank()) {
            return new Request("", List.of());
        }

        String[] parts = input.trim().split("\\s+");
        String commandName = parts[0];
        List<String> args =
                List.of(parts).subList(1, parts.length);

        return new Request(commandName, args);
    }
}
