using Xunit;

namespace DotnetStarter.Logic.Tests;

public class PasswordValidationShould
{
    [Fact]
    public void ShouldReturnTrue()
    {
        var result = PasswordValidator.IsValid("exe1a1laaaaa");

        Assert.True(result.IsValid());
        Assert.Empty(result.Errors());
    }

    [Fact]
    public void ShouldReturnFalseWhenLengthIsBelow8()
    {
        var result = PasswordValidator.IsValid("exea11");

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

    [Fact]
    public void FailForAPasswordWithOneNumber()
    {
        var result = PasswordValidator.IsValid("notnumbe1rsa");

        Assert.False(result.IsValid());
        Assert.Contains("The password must contain at least 2 numbers", result.Errors());
    }
    
    [Fact]
    public void ConcatMultipleErrorMessages()
    {
        var result = PasswordValidator.IsValid("no1");

        Assert.False(result.IsValid());
        Assert.Contains("Password must be at least 8 characters", result.Errors());
        Assert.Contains("The password must contain at least 2 numbers", result.Errors());
    }
}