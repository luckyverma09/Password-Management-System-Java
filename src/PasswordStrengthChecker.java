public class PasswordStrengthChecker {
    public void analyze(String password) {
        int score = 0;
        boolean hasUpper = false, hasLower = false,
                hasNumber = false, hasSymbol = false,
                hasRepeated = false, hasCommonPattern = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                hasUpper = true;
            if (Character.isLowerCase(c))
                hasLower = true;
            if (Character.isDigit(c))
                hasNumber = true;
            if (Constants.SYMBOLS.indexOf(c) != -1)
                hasSymbol = true;
        }

        if (hasUpper)
            score++;
        if (hasLower)
            score++;
        if (hasNumber)
            score++;
        if (hasSymbol)
            score++;

        if (password.length() >= 8)
            score++;
        if (password.length() >= 16)
            score++;

        if (hasRepeatedCharacters(password))
            hasRepeated = true;
        if (hasCommonPatterns(password))
            hasCommonPattern = true;

        if (!hasRepeated)
            score++;
        if (!hasCommonPattern)
            score++;

        printAnalysis(password, score, hasUpper, hasLower, hasNumber, hasSymbol, hasRepeated, hasCommonPattern);
    }

    private boolean hasRepeatedCharacters(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCommonPatterns(String password) {
        String[] commonPatterns = { "1234", "password", "qwerty", "abcd" };
        for (String pattern : commonPatterns) {
            if (password.toLowerCase().contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    private void printAnalysis(String password, int score, boolean... checks) {
        System.out.println("\nPassword Strength Analysis:");
        System.out.println("Length: " + password.length() + " characters");
        System.out.println("Contains Uppercase: " + checks[0]);
        System.out.println("Contains Lowercase: " + checks[1]);
        System.out.println("Contains Numbers: " + checks[2]);
        System.out.println("Contains Symbols: " + checks[3]);
        System.out.println("Contains Repeated Characters: " + checks[4]);
        System.out.println("Contains Common Patterns: " + checks[5]);

        System.out.print("\nStrength: ");
        System.out.println(switch (score) {
            case 0, 1, 2 -> "Weak";
            case 3, 4 -> "Medium";
            case 5, 6 -> "Good";
            case 7, 8 -> "Strong";
            default -> "Great!";
        });
    }
}