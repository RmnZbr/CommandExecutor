package ru.zhenabomzha.enums.decisionForContinue;

import java.util.Arrays;
import java.util.Optional;

public enum Decision {

    YES(true),
    Y(true),
    NO(false),
    N(false),
    EXIT(false),
    NOT(false);

    private final boolean decision;

    Decision(boolean decision) {
        this.decision = decision;
    }

    public boolean isDecision() {
        return decision;
    }

    public static Optional<Decision> findDecisionByName(String decision) {
        return Arrays.stream(values())
                .filter(d -> d.name().equalsIgnoreCase(decision))
                .findFirst();
    }
}
