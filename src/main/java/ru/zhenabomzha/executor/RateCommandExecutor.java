package ru.zhenabomzha.executor;

import ru.zhenabomzha.validator.validatorDto.RateCommandDto;

public class RateCommandExecutor implements CommandExecutor<RateCommandDto> {

    @Override
    public void execute(RateCommandDto rateCommandDto) {
        System.out.println("Ваша валюта - " + rateCommandDto.getCurrency() + "!");
        System.out.println("Ваша целевая дата - " + rateCommandDto.getTargetDate() + "!");
        System.out.println("Ваш алгоритм - " + rateCommandDto.getAlgorithm() + "!");
    }

}
