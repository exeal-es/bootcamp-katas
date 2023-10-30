using Xunit;

namespace DotnetStarter.Logic.Tests;

public class PasswordValidationShould
{
    [Fact]
    public void ShouldReturnTrue()
    {
        var result = PasswordValidator.IsValid("exe1alaaaaa");
        Assert.True(result.IsValid());
        Assert.Empty(result.Errors());
    }

    [Fact]
    public void ShouldReturnFalseWhenLengthIsBelow8()
    {
        var result = PasswordValidator.IsValid("exeal1");
        Assert.False(result.IsValid());
        Assert.Contains("Password must be at least 8 characters", result.Errors());
    }

    [Fact]
    public void ShouldNotContainNumbers()
    {
        var result = PasswordValidator.IsValid("notnumbersa");
        Assert.False(result.IsValid());
        Assert.Contains("The password must contain at least 2 numbers", result.Errors());
    }
}