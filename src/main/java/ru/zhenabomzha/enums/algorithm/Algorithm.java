package ru.zhenabomzha.enums.algorithm;

import java.util.Arrays;
import java.util.Optional;

public enum Algorithm {

    LINEAR("LINEAR"),
    STRAIGHT("STRAIGHT");

    private final String algorithm;

    Algorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public static Optional<Algorithm> findAlgorithmByName(String algorithm) {
        return Arrays.stream(values())
                .filter(a -> a.getAlgorithm().equalsIgnoreCase(algorithm))
                .findFirst();
    }
}
