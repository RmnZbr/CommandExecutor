package ru.zhenabomzha.enums.date;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public enum TargetDate {

    TOMORROW(LocalDate.now().plusDays(1L)),
    WEEK(LocalDate.now().plusWeeks(1L)),
    MONTH(LocalDate.now().plusMonths(1L));

    private final LocalDate targetDate;

    TargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public static Optional<TargetDate> findTargetDateByName(String targetDate) {
        return Arrays.stream(values())
                .filter(td -> td.name().equalsIgnoreCase(targetDate))
                .findFirst();
    }

    public static Optional<TargetDate> findTargetDateByDate(LocalDate date) {
        return Arrays.stream(values())
                .filter(d -> d.getTargetDate().equals(date))
                .findFirst();
    }
}
