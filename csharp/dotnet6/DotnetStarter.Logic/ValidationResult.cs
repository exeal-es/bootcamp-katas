using System.Collections.Generic;

namespace DotnetStarter.Logic;

public sealed class ValidationResult
{
    private readonly bool isValid;
    private readonly string error;

    public ValidationResult(bool isValid)
    {
        this.isValid = isValid;
        error = null;
    }

    public ValidationResult(bool isValid, string error)
    {
        this.isValid = isValid;
        this.error = error;
    }

    public bool IsValid()
    {
        return isValid;
    }

    public List<string> Errors()
    {
        return error == null ? new List<string>() : new List<string> { error };
    }
}