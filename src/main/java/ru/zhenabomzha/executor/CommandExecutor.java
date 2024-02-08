package ru.zhenabomzha.executor;

import ru.zhenabomzha.validator.validatorDto.ValidatorDto;

public interface CommandExecutor <T extends ValidatorDto> {

    void execute(T validatorDto);

}
