package ru.zhenabomzha.validator.validatorDto;

import ru.zhenabomzha.enums.commandType.CommandType;

public abstract class ValidatorDto  {

    private final CommandType commandType;

    public ValidatorDto(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }
}
