package class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CommonMethods;

import static org.openqa.selenium.By.xpath;

public class SoftAssertion extends CommonMethods {
//    per condition

//    login into the syntax HRMS APP
//    verify that the Welcome message is displayed
//    verify that the message is  "Welcome Admin"

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowserAndNavigate() {
        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login", "chrome");
    }

    //    post conditions
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

    @Test(groups = "regression")
    public void verifyTheWelcomeMessage() {
//        /        send username
        WebElement userName = driver.findElement(xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
//       send password
        WebElement password = driver.findElement(xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

//        click login
        WebElement loginBtn = driver.findElement(xpath("//input[@id='btnLogin']"));
        loginBtn.click();

//        get the message
        WebElement welcomeMsg = driver.findElement(By.id("welcome"));


//        verify is displayed
        boolean isDisplayed = welcomeMsg.isDisplayed();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(isDisplayed);

//        verify the message is welcome admin
        String actualWelcomeText = welcomeMsg.getText();
        String expectedWelcomeText = "Welcome Admin";
        soft.assertEquals(actualWelcomeText, expectedWelcomeText);
        //  assert all the assertions that have been made
        soft.assertAll();

    }
}