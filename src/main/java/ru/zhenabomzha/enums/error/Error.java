package ru.zhenabomzha.enums.error;

public enum Error {

    COMMAND_NOT_FOUND_ERROR("Такой команды не предусмотрено!"),
    MINIMUM_ARGUMENTS_ERROR("Вы ввели недостаточное количество аргументов для данной команды!"),
    CURRENCY_NAME_ERROR("Такого названия валюты не предусмотрено!"),
    TARGET_DATE_NAME_ERROR("Целевая дата указана с ошибкой!"),
    DATE_KEY_ERROR("Вы ввели ключ для целевой даты с ошибкой"),
    ALGORITHM_NAME_ERROR("Алгоритма с таким названием не предусмотрено!"),
    MINIMUM_ARGUMENTS_FOR_ALGORITHM_ERROR("Вы ввели недостаточное количество аргументов для указания алгоритма!"),
    ALGORITHM_KEY_ERROR("Вы ввели ключ для алгоритма с ошибкой!"),
    DECISION_ANSWER_ERROR("Такой команды для ответа не найдено! Повторите ввод!"),
    FIRST_SPACE_INPUT_ERROR("Нельзя начинать ввод с пробела!");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
