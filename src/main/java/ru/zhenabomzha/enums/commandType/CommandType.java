package ru.zhenabomzha.enums.commandType;

import ru.zhenabomzha.enums.error.Error;

import java.util.Arrays;

public enum CommandType {

    RATE("rate"),
    EXCHANGE("exchange"),
    EXIT("exit");

    private final String commandType;

    CommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandType() {
        return commandType;
    }

    public static CommandType getCommandByName(String commandType) {
        return Arrays.stream(values())
                .filter(ct -> ct.getCommandType().equals(commandType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(Error.COMMAND_NOT_FOUND_ERROR.getError()));
    }
}
