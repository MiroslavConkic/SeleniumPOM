package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
    }

    @Test(priority=1)
    public void userCanLogIn(){
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickSubmitButton();
        Assert.assertTrue(profilePage.getLoggedInMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test(priority=2)
    public void userCannotLogInWithInvalidUsername() {
        loginPage.inputUsername(invalidCredentials);
        loginPage.inputPassword(validPassword);
        loginPage.clickSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }

    @Test(priority=3)
    public void userCannotLogInWithInvalidPassword() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidCredentials);
        loginPage.clickSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(), "Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }

}
