using System.Collections.Generic;
using System.Linq;

namespace DotnetStarter.Logic;

public sealed class ValidationResult
{
    private List<string> errors = new();

    public ValidationResult(bool isValid)
    {
    }

    public bool IsValid() => !errors.Any();

    public string Errors()
    {
        return string.Join("\n", errors);
    }

    public void AddError(string error)
    {
        this.errors.Add(error);
    }
}