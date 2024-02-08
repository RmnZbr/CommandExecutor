package ru.zhenabomzha.validator.validatorDto;

import ru.zhenabomzha.enums.algorithm.Algorithm;
import ru.zhenabomzha.enums.commandType.CommandType;
import ru.zhenabomzha.enums.currency.Currency;
import ru.zhenabomzha.enums.date.TargetDate;

public class RateCommandDto extends ValidatorDto {

    private final Currency currency;
    private final TargetDate targetDate;
    private final Algorithm algorithm;

    public RateCommandDto(CommandType commandType, Currency currency, TargetDate targetDate, Algorithm algorithm) {
        super(commandType);
        this.currency = currency;
        this.targetDate = targetDate;
        this.algorithm = algorithm;
    }

    @Override
    public CommandType getCommandType() {
        return super.getCommandType();
    }

    public Currency getCurrency() {
        return currency;
    }

    public TargetDate getTargetDate() {
        return targetDate;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }
}
