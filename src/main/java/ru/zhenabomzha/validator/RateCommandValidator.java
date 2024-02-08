package ru.zhenabomzha.validator;

import ru.zhenabomzha.enums.algorithm.Algorithm;
import ru.zhenabomzha.enums.commandType.CommandType;
import ru.zhenabomzha.enums.currency.Currency;
import ru.zhenabomzha.enums.date.TargetDate;
import ru.zhenabomzha.enums.error.Error;
import ru.zhenabomzha.validator.validatorDto.RateCommandDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RateCommandValidator implements Validator {

    private final List<String> errorList;
    public static final String DATE_KEY = "-d";
    public static final String ALGORITHM_KEY = "-a";
    public static final int MINIMUM_ARGUMENTS_FOR_RATE_COMMAND = 4;

    public RateCommandValidator(List<String> errorList) {
        this.errorList = errorList;
    }

    @Override
    public RateCommandDto validate(String[] rateCommand) {
        if (rateCommand.length < MINIMUM_ARGUMENTS_FOR_RATE_COMMAND) {
            throw new RuntimeException(Error.MINIMUM_ARGUMENTS_ERROR.getError());
        }
        String[] arguments = new String[rateCommand.length - 1];
        System.arraycopy(rateCommand, 1, arguments, 0, arguments.length);
        Currency currency = checkCurrencyName(arguments[0]);
        checkDataKey(arguments[1]);
        TargetDate targetDate = checkTargetDate(arguments[2]);
        Algorithm algorithm = checkAlgorithm(arguments);
        if (errorList.isEmpty()) {
            return new RateCommandDto(CommandType.RATE, currency, targetDate, algorithm);
        } else {
            throw new RuntimeException(errorList.toString());
        }
    }

    private Currency checkCurrencyName(String currency) {
        if (!Currency.getCurrencyByName(currency).isPresent()) {
            errorList.add(Error.CURRENCY_NAME_ERROR.getError());
        } else {
            return Currency.getCurrencyByName(currency).get();
        }
        return null;
    }

    private void checkDataKey(String dataKey) {
        if (!dataKey.equals(DATE_KEY)) {
            errorList.add(Error.DATE_KEY_ERROR.getError());
        }
    }

    private TargetDate checkTargetDate(String targetDate) {
        if (TargetDate.findTargetDateByName(targetDate).isPresent()) {
            return TargetDate.findTargetDateByName(targetDate).get();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            try {
                LocalDate date = LocalDate.parse(targetDate, formatter);
                if (TargetDate.findTargetDateByDate(date).isPresent()) {
                    return TargetDate.findTargetDateByDate(date).get();
                }
            } catch (RuntimeException ex) {
                errorList.add(Error.TARGET_DATE_NAME_ERROR.getError());
                return null;
            }
        }
        errorList.add(Error.TARGET_DATE_NAME_ERROR.getError());
        return null;
    }

    private Algorithm checkAlgorithm(String[] arguments) {
        if (arguments.length == 3) {
            return Algorithm.LINEAR;
        }
        if (arguments.length < MINIMUM_ARGUMENTS_FOR_RATE_COMMAND + 1) {
            errorList.add(Error.MINIMUM_ARGUMENTS_FOR_ALGORITHM_ERROR.getError());
            return null;
        } else {
            checkAlgorithmKey(arguments[3]);
            return checkAlgorithmByName(arguments[4]);
        }
    }

    private void checkAlgorithmKey(String algorithmKey) {
        if (!algorithmKey.equals(ALGORITHM_KEY)) {
            errorList.add(Error.ALGORITHM_KEY_ERROR.getError());
        }
    }

    private Algorithm checkAlgorithmByName(String algorithmName) {
        if (!Algorithm.findAlgorithmByName(algorithmName).isPresent()) {
            errorList.add(Error.ALGORITHM_NAME_ERROR.getError());
        } else {
            return Algorithm.findAlgorithmByName(algorithmName).get();
        }
        return null;
    }
}
