package ru.zhenabomzha.parser;

import ru.zhenabomzha.enums.commandType.CommandType;
import ru.zhenabomzha.enums.error.Error;
import ru.zhenabomzha.validator.ExitCommandValidator;
import ru.zhenabomzha.validator.RateCommandValidator;
import ru.zhenabomzha.validator.Validator;
import ru.zhenabomzha.validator.validatorDto.ValidatorDto;

import java.util.ArrayList;
import java.util.Map;

public class Parser {

    private final Map<CommandType, Validator> validatorMap;

    public Parser(Map<CommandType, Validator> validatorMap) {
        this.validatorMap = validatorMap;
        RateCommandValidator rateCommandValidator = new RateCommandValidator(new ArrayList<>());
        ExitCommandValidator exitCommandValidator = new ExitCommandValidator();
        validatorMap.put(CommandType.RATE, rateCommandValidator);
        validatorMap.put(CommandType.EXIT, exitCommandValidator);
    }

    public ValidatorDto parse(String userInput) {
        String[] splitCommand = userInput.split("\\s+");
        if (userInput.isEmpty()) {
            throw new RuntimeException("Вы не ввели ничего в консоль!");
        }
        if (userInput.charAt(0) == ' ') {
            throw new RuntimeException(Error.FIRST_SPACE_INPUT_ERROR.getError());
        }
        CommandType commandType = CommandType.getCommandByName(splitCommand[0]);
        return validatorMap.get(commandType).validate(splitCommand);
    }
}
