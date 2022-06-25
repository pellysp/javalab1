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
                        a = Double.parseDouble(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for a");
                    }
                    if (a <= 0) {
                        throw new Exception("a couldn't be less or equals to zero");
                    }
                    break;
                case "-c":
                    try {
                        c = Double.parseDouble(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for c");
                    }
                    if (c <= 0) {
                        throw new Exception("c couldn't be less or equals to zero");
                    }
                    if (c > 90) {
                        throw new Exception("c couldn't be bigger than 90");
                    }
                    break;
                default:
                    throw new Exception("Invalid argument passed, required float arguments: -a, -c");
            }
            i++;
        }
    }

    private static double getSquare() {
        return Math.pow(a, 2) * Math.sin(Math.toRadians(c));
    }

    public static void main(String[] args) {
        try {
            parseArgs(args);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error during parsing caused: " + e.getMessage() + ANSI_RESET);
            return;
        }
        System.out.println("Entered arguments:");
        System.out.println("A = " + a + "\nC = " + c);

        double square = getSquare();

        System.out.println("\nResults:\nSquare = " + square);
    }
}
