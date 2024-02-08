package ru.zhenabomzha.validator;

import ru.zhenabomzha.enums.commandType.CommandType;
import ru.zhenabomzha.validator.validatorDto.ExitCommandDto;
import ru.zhenabomzha.validator.validatorDto.ValidatorDto;

public class ExitCommandValidator implements Validator {

    @Override
    public ValidatorDto validate(String[] userCommand) {
        return new ExitCommandDto(CommandType.EXIT);
    }
}
