package com.company;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static double a = 0;
    private static double c = 0;

    private static void parseArgs(String[] args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Invalid arguments were passed");
        }
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-a":
                    try {
                        a = .parseFloat(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for a");
                    }
                    if (a <= 0) {
                        throw new Exception("a couldn't be less or equals to zero");
                    }
                    break;
                case "-c":
                    try {
                        a = Float.parseFloat(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for a");
                    }
                    if (a <= 0) {
                        throw new Exception("a couldn't be less or equals to zero");
                    }
                    break;
                default:
                    throw new Exception("Invalid argument passed, required float arguments: -a, -b, -c");
            }
            i++;
        }
    }

    private static boolean isArgumentsCorrect() {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        try {
            parseArgs(args);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error during parsing caused: " + e.getMessage() + ANSI_RESET);
            return;
        }
        System.out.println("Entered arguments:");
        System.out.println("A = " + a + "\nB = " + b + "\nC = " + c);

        if (!isArgumentsCorrect()) {
            System.out.println(ANSI_RED + "\nUnfortunately you had entered impossible arguments for triangle.\n" + ANSI_RESET);
            return;
        }

        p = getP();
        double square = getSquare();

        System.out.println("\nResults:\nP = " + p + "\nSquare = " + square);
    }
}
