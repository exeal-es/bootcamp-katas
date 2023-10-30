using System.Collections.Generic;
using System.Linq;

namespace DotnetStarter.Logic;

public sealed class ValidationResult
{
    private readonly List<string> errors = new();

    public bool IsValid() => !errors.Any();

    public string Errors() => string.Join("\n", errors);

    public void AddError(string error) => errors.Add(error);
}