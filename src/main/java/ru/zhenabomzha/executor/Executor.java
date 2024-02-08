package ru.zhenabomzha.executor;

import ru.zhenabomzha.enums.commandType.CommandType;

import java.util.Map;

public class Executor {

    private final Map<CommandType, CommandExecutor> executorHashMap;

    public Executor(Map<CommandType, CommandExecutor> executorHashMap) {
        this.executorHashMap = executorHashMap;
        RateCommandExecutor rateCommandExecutor = new RateCommandExecutor();
        executorHashMap.put(CommandType.RATE, rateCommandExecutor);
        ExitCommandExecutor exitCommandExecutor = new ExitCommandExecutor();
        executorHashMap.put(CommandType.EXIT, exitCommandExecutor);
    }

    public CommandExecutor findExecutorForCommand(CommandType commandType) {
        return executorHashMap.get(commandType);
    }
}
