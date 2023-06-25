package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class HardAssertion extends CommonMethods {
//    goto HRMS
//    enter username
//    enter wrong password
//    click on login
//    verify that the error message Invalid credentials is displayed
//    also confirm that the error message is Displayed

//    i will put in pre-conditions for my test case in the Before Method


    @BeforeMethod(alwaysRun = true)
    public void OpenBrowserAndNavigate() {
        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login", "chrome");
    }

    //    post conditions
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
//        driver.quit();
    }

    //    test  case 1:
    @Test(groups = "smoke")
    public void verifyTheErrorMessage() {
//        send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
//       send password
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("abracadabra");

//        click login
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

//        get the error message
        WebElement errorMsg = driver.findElement(By.id("spanMessage"));

        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage = "Invalid credentials";

//        comparing two strings , which assertion to use
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("check that assert number 2 is running or not");
//        check if it is displayed
        boolean errorMsgIsDisplayed = errorMsg.isDisplayed();
        Assert.assertTrue(errorMsgIsDisplayed);

    }

}