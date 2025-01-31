import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler input = new InputHandler(scanner);
        PasswordGenerator generator = new PasswordGenerator();
        PasswordStrengthChecker checker = new PasswordStrengthChecker();

        while (true) {
            printMenu();
            int choice = input.getIntInput("Select option: ", 1, 4);

            switch (choice) {
                case 1 -> generatePassword(input, generator);
                case 2 -> checkPasswordStrength(scanner, checker);
                case 3 -> SecurityInfo.display();
                case 4 -> {
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nPassword Manager");
        System.out.println("1. Generate Password");
        System.out.println("2. Check Password Strength");
        System.out.println("3. Security Information");
        System.out.println("4. Exit");
    }

    private static void generatePassword(InputHandler input, PasswordGenerator generator) {
        System.out.println("\nPassword Character Options:");
        boolean useUpper = input.getYesNo("Include uppercase letters? (Y/N): ");
        boolean useLower = input.getYesNo("Include lowercase letters? (Y/N): ");
        boolean useNumbers = input.getYesNo("Include numbers? (Y/N): ");
        boolean useSymbols = input.getYesNo("Include symbols? (Y/N): ");

        int length = input.getIntInput("Enter password length: ",
                Constants.MIN_LENGTH, Constants.MAX_LENGTH);

        try {
            String password = generator.generatePassword(useUpper, useLower,
                    useNumbers, useSymbols, length);
            System.out.println("\nGenerated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkPasswordStrength(Scanner scanner, PasswordStrengthChecker checker) {
        System.out.print("\nEnter password to check: ");
        String password = scanner.nextLine();
        checker.analyze(password);
    }
}
