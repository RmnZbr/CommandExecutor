package ru.zhenabomzha.enums.currency;

import java.util.Arrays;
import java.util.Optional;

public enum Currency {

    USD, EUR, KZT, TRY;

    public static Optional<Currency> getCurrencyByName(String currency) {
        return Arrays.stream(values())
                .filter(c -> c.name().equals(currency))
                .findFirst();
    }
}
