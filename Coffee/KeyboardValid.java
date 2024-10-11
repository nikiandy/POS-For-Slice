import java.util.Scanner;

class KeyboardValid {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Error: Invalid input. Please enter a number between " + min + " and " + max);
                }
            } else {
                scanner.nextLine();
                System.out.println("Error: Invalid input. Please enter a number between " + min + " and " + max);
            }
        }
        return input;
    }

    public static double getDoubleInput(String prompt, double min, double max) {
        double input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Error: Invalid input. Please enter a number between " + min + " and " + max);
                }
            } else {
                scanner.nextLine();
                System.out.println("Error: Invalid input. Please enter a number between " + min + " and " + max);
            }
        }
        return input;
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}