package com.company;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static double a = 0;
    private static double b = 0;
    private static double c = 0;
    private static double d = 0;

    private static void parseArgs(String[] args) throws Exception {
        if (args.length != 6) {
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
                    break;
                case "-b":
                    try {
                        b = Double.parseDouble(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for b");
                    }
                    break;
                case "-c":
                    try {
                        c = Double.parseDouble(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for c");
                    }
                    break;
                default:
                    throw new Exception("Invalid argument passed, required float arguments: -a, -b, -c");
            }
            i++;
        }
    }

    private static double getD() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    private static boolean isEquationHasResult() {
        return d >= 0;
    }

    private static EquationResult<Double> resolveEquation() {
        double x1 = (-b + Math.sqrt(d))/2*a;
        double x2 = (-b - Math.sqrt(d))/2*a;

        return new EquationResult<>(x1, x2);
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

        d = getD();

        if (!isEquationHasResult()) {
            System.out.println(ANSI_RED + "\nUnfortunately equation has no results, change arguments. D = " + d + "\n" + ANSI_RESET);
            return;
        }

        EquationResult<Double> result = resolveEquation();


        System.out.println("\nResults:\nX1 = " + result.getX1() + "\nX2 = " + result.getX2());
    }

    static class EquationResult<T> {

        private T x1;

        /**
         * The x2 element of this <code>EquationResult</code>
         */
        private T x2;

        /**
         * Constructs a new <code>EquationResult</code> with the given values.
         *
         * @param x1  the x1 element
         * @param x2 the x2 element
         */
        public EquationResult(T x1, T x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        public T getX2() {
            return x2;
        }

        public T getX1() {
            return x1;
        }
    }
}
