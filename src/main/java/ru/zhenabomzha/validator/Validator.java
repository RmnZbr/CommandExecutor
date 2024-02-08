package ru.zhenabomzha.validator;

import ru.zhenabomzha.validator.validatorDto.ValidatorDto;

public interface Validator {
    ValidatorDto validate(String[] userCommand);
}
