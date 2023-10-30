using System.Linq;

namespace DotnetStarter.Logic;

public class PasswordValidator
{
    public static ValidationResult IsValid(string password)
    {
        var numbers = password.Count(char.IsDigit);

        var validationResult = new ValidationResult();

        if (numbers <= 1)
        {
            validationResult.AddError("The password must contain at least 2 numbers");
        }

        if (password.Length < 8)
        {
            validationResult.AddError("Password must be at least 8 characters");
        }

        return validationResult;
    }
}