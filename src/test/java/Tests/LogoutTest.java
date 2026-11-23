package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickSubmitButton();
    }

    @Test
    public void testThatUserCanLogOut(){
        profilePage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
//git status
//[6:35 PM]git init
//[6:37 PM]git add .
//[6:38 PM]git commit -m “Initial commit”
//[6:40 PM]git remote add origin {ovde ubacite link sa github projekta}
//[6:40 PM]Taj link mora da se zavrsi sa .git
//[6:41 PM]git push --set-upstream origin master