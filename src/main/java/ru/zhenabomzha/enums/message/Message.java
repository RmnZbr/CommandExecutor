package ru.zhenabomzha.enums.message;

public enum Message {

    ASKING_FOR_CONTINUE_MESSAGE("Желаете ввести команду заново?"),
    ASKING_FOR_COMMAND("Введите команду!");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
