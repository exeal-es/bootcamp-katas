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

        if (numbers <= 1)
        {
            var validationResult = new ValidationResult(false);
            validationResult.AddError("The password must contain at least 2 numbers");
            return validationResult;
        }

        if (password.Length < 8)
        {
            var validationResult = new ValidationResult(false);
            validationResult.AddError("Password must be at least 8 characters");
            return validationResult;
        }

        return new ValidationResult(true);
    }
}