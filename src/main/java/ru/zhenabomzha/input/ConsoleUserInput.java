package ru.zhenabomzha.input;

import java.util.Scanner;

public class ConsoleUserInput implements InputService {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }
}
