package ru.zhenabomzha.engine;

import ru.zhenabomzha.enums.commandType.CommandType;
import ru.zhenabomzha.enums.decisionForContinue.Decision;
import ru.zhenabomzha.enums.error.Error;
import ru.zhenabomzha.enums.message.Message;
import ru.zhenabomzha.executor.CommandExecutor;
import ru.zhenabomzha.executor.Executor;
import ru.zhenabomzha.input.ConsoleUserInput;
import ru.zhenabomzha.output.ConsoleOutputService;
import ru.zhenabomzha.parser.Parser;
import ru.zhenabomzha.validator.validatorDto.ExitCommandDto;
import ru.zhenabomzha.validator.validatorDto.ValidatorDto;

import java.util.HashMap;

public class Engine {

    public static void run() {

        ConsoleUserInput consoleUserInput = new ConsoleUserInput();
        Parser parser = new Parser(new HashMap<>());
        Executor executor = new Executor(new HashMap<>());
        ConsoleOutputService output = new ConsoleOutputService();
        ExitCommandDto exitCommandDto = new ExitCommandDto(CommandType.EXIT);

        output.print(Message.ASKING_FOR_COMMAND.getMessage());
        String userInput = consoleUserInput.getUserInput();

        try {
            ValidatorDto validateUserInput = parser.parse(userInput);
            CommandExecutor executorForCommand = executor.findExecutorForCommand(validateUserInput.getCommandType());
            executorForCommand.execute(validateUserInput);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            run();
        }

        output.print(Message.ASKING_FOR_CONTINUE_MESSAGE.getMessage());

        while (true) {
            try {
                String userDecision = consoleUserInput.getUserInput();
                if (!Decision.findDecisionByName(userDecision).isPresent()) {
                    throw new RuntimeException(Error.DECISION_ANSWER_ERROR.getError());
                } else {
                    if (Decision.findDecisionByName(userDecision).get().isDecision()) {
                        run();
                    }
                    CommandExecutor exitCommand = executor.findExecutorForCommand(CommandType.EXIT);
                    exitCommand.execute(exitCommandDto);
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());

            }
        }
    }
}
