package com.company;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static int a = 0;

    private static void parseArgs(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Invalid arguments were passed");
        }
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a":
                    try {
                        a = Integer.parseInt(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for a");
                    }
                    if (a <= 0) {
                        throw new Exception("a couldn't be less or equals to zero");
                    }
                    if (Integer.toString(a).length() != 4) {
                        throw new Exception("You need to pass 4 digits, instead you pass " + Integer.toString(a).length());
                    }
                    break;
                default:
                    throw new Exception("Invalid argument passed, required float arguments: -a, -c");
            }
            i++;
        }
    }

    private static double process() {
        char[] aCharArray = Integer.toString(a).toCharArray();
        StringBuilder result = new StringBuilder();
        result.append(aCharArray[aCharArray.length - 1]);
        for (int i = 0; i < aCharArray.length - 1; i++) {
            result.append(aCharArray[i]);
        }

        int val = Integer.parseInt(result.toString());

        return Math.log(val);
    }

    public static void main(String[] args) {
        try {
            parseArgs(args);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error during parsing caused: " + e.getMessage() + ANSI_RESET);
            return;
        }
        System.out.println("Entered arguments:");
        System.out.println("A = " + a);

        double naturalLog = 0;

        try {
            naturalLog = process();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Something went wrong while execution: " + e.getMessage() + ANSI_RESET);
            return;
        }

        System.out.println("\nResults:\nMath.log = " + naturalLog);
    }
}
