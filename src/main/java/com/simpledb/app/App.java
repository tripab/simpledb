package com.simpledb.app;

import com.simpledb.langutils.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * SimpleDB!
 *
 * @author Abhinav Tripathi
 */
public class App {

    private static final String PROMPT_STRING = "simpledb > ";
    private static final String DOT = ".";

    private static final Set<String> VALID_CMDS = new HashSet<>(Arrays.asList(new String[]{".exit"}));

    private static final int EXIT_SUCCESS = 0;
    private static final int EXIT_FAILURE = 1;

    enum MetaCommandResult {
        META_CMD_SUCCESS, META_CMD_UNRECOGNIZED_CMD
    }

    enum PrepareResult {
        PREPARE_SUCCESS, PREPARE_CMD_UNRECOGNIZED_CMD;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputCmd = readInput(scanner);
            if (inputCmd.startsWith(DOT)) {
                if (doMetaCommand(inputCmd) == MetaCommandResult.META_CMD_UNRECOGNIZED_CMD)
                    System.out.printf("Unrecognized command: '%s'\n", inputCmd);
                continue;
            }
            Pair<Statement, PrepareResult> result = prepareStatement(inputCmd);
            if (result.getSecond() == PrepareResult.PREPARE_CMD_UNRECOGNIZED_CMD) {
                System.out.printf("Unrecognized keyword at start of '%s'\n", inputCmd);
                continue;
            }
            executeStatement(result.getFirst());
        }
    }

    private static void executeStatement(Statement statement) {
        if (statement.getType() == Statement.StatementType.STATEMENT_INSERT) {
            System.out.println("Carrying out insertion.");
        } else if (statement.getType() == Statement.StatementType.STATEMENT_SELECT) {
            System.out.println("Carrying out select statement.");
        } else {
            System.out.printf("Unrecognized statement type: '%s'\n", statement);
        }
    }

    private static MetaCommandResult doMetaCommand(String inputCmd) {
        if (VALID_CMDS.contains(inputCmd)) {
            System.exit(EXIT_SUCCESS);
        } else {
            return MetaCommandResult.META_CMD_UNRECOGNIZED_CMD;
        }

        return null;
    }

    private static Pair<Statement, PrepareResult> prepareStatement(String inputCmd) {
        Pair<Statement, PrepareResult> result;

        if (inputCmd.startsWith("insert")) {
            result = new Pair<>(new Statement(Statement.StatementType.STATEMENT_INSERT),
                    PrepareResult.PREPARE_SUCCESS);
        } else if (inputCmd.startsWith("select")) {
            result = new Pair<>(new Statement(Statement.StatementType.STATEMENT_SELECT),
                    PrepareResult.PREPARE_SUCCESS);
        } else {
            result = new Pair<>(null, PrepareResult.PREPARE_CMD_UNRECOGNIZED_CMD);
        }

        return result;
    }

    private static String readInput(Scanner scanner) {
        System.out.printf(PROMPT_STRING);

        return scanner.nextLine();
    }

}
