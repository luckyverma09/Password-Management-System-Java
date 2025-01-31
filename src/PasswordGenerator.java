import java.security.SecureRandom;

public class PasswordGenerator {
    private final SecureRandom random = new SecureRandom();

    public String generatePassword(boolean upper, boolean lower, boolean numbers,
            boolean symbols, int length) {
        StringBuilder charSet = new StringBuilder();
        if (upper)
            charSet.append(Constants.UPPERCASE);
        if (lower)
            charSet.append(Constants.LOWERCASE);
        if (numbers)
            charSet.append(Constants.NUMBERS);
        if (symbols)
            charSet.append(Constants.SYMBOLS);

        if (charSet.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charSet.length());
            password.append(charSet.charAt(index));
        }
        return password.toString();
    }
}
