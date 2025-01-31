# Password Generator & Strength Checker

A robust Java application that generates secure passwords and analyzes password strength based on industry standards.

## Features

### 1. Password Generation

- Customizable password criteria:
  - Uppercase letters (A-Z)
  - Lowercase letters (a-z)
  - Numbers (0-9)
  - Special characters (!@#$%^&\*()-\_=+[{]}\\|;:'\",<.>/?)
- Configurable password length (8-64 characters)
- Secure random generation using Java's SecureRandom

### 2. Password Strength Analysis

- Comprehensive strength assessment based on:
  - Character diversity
  - Password length
  - Use of mixed case letters
  - Numbers and special characters
- Detailed feedback with strength rating (Weak/Medium/Good/Great)

### 3. Security Information

- Built-in password security tips
- Best practices for password management
- Educational content about password safety

## Usage

### Generate a Password

1. Select option 1 from the main menu
2. Answer the prompts for password criteria:
   - Include uppercase letters? (Y/N)
   - Include lowercase letters? (Y/N)
   - Include numbers? (Y/N)
   - Include symbols? (Y/N)
3. Enter desired password length
4. The generated password will be displayed

### Check Password Strength

1. Select option 2 from the main menu
2. Enter the password to analyze
3. Review the detailed strength analysis

### View Security Tips

1. Select option 3 from the main menu
2. Browse through security recommendations

## Technical Details

### Security Features

- Uses `java.security.SecureRandom` for cryptographically strong random generation
- Implements industry-standard password strength metrics
- Input validation and sanitization
- Error handling for all user inputs

### Design Patterns

- Builder Pattern for password generation configuration
- Strategy Pattern for character set management
- Singleton Pattern for constants and utilities

## Requirements

- Java JDK 11 or higher
- Command-line interface
- 256MB RAM minimum
- 10MB disk space

## Best Practices

When using this password generator:

- Always use maximum possible length for passwords
- Enable all character types when possible
- Store generated passwords securely
- Never share passwords across multiple accounts
- Use in conjunction with a password manager
