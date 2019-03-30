package com.simpledb.app;

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
    private static final Set<String> VALID_CMDS = new HashSet<>(Arrays.asList(new String[]{".exit"}));
    private static final int EXIT_SUCCESS = 0;
    private static final int EXIT_FAILURE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputCmd = readInput(scanner);
            if (VALID_CMDS.contains(inputCmd)) {
                System.exit(EXIT_SUCCESS);
            } else {
                System.out.printf("Unrecognized command! %s\n", inputCmd);
            }
        }
    }

    private static String readInput(Scanner scanner) {
        System.out.printf(PROMPT_STRING);
        return scanner.nextLine();
    }

}
