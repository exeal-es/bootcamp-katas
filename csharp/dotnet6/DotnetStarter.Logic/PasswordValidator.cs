namespace DotnetStarter.Logic;

public class PasswordValidator
{
    public static ValidationResult IsValid(string password)
    {
        int numbers = 0;

        for (int i = 0; i < password.Length; i++)
        {
            if (char.IsDigit(password[i]))
            {
                numbers++;
            }
        }

        if (numbers <= 1) return new ValidationResult(false, "The password must contain at least 2 numbers");

        if (password.Length < 8)
            return new ValidationResult(false, "Password must be at least 8 characters");
        return new ValidationResult(true);
    }
}