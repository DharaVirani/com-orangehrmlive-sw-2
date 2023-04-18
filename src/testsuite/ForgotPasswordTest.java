package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
     openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
//  click on the ‘Forgot your password’ link
    WebElement forgotPasswordLink = driver.findElement(By.xpath("//p[text()='Forgot your password? ']"));
    forgotPasswordLink.click();
//  Verify the text ‘Reset Password’
    String expectedMessage = "Reset Password";
    WebElement actualTextElement = driver.findElement(By.xpath("//button[@type = 'submit']"));
    String actualMessage = actualTextElement.getText();
    Assert.assertEquals("Invalid Text", expectedMessage , actualMessage);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
