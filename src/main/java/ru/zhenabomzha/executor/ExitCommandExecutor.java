package ru.zhenabomzha.executor;

import ru.zhenabomzha.validator.validatorDto.ExitCommandDto;

public class ExitCommandExecutor implements CommandExecutor<ExitCommandDto> {

    @Override
    public void execute(ExitCommandDto validatorDto) {
        System.exit(0);
    }
}
