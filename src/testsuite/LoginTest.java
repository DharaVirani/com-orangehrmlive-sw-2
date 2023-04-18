package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
//  Enter “Admin” username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys("Admin");
//  Enter “admin123“ password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("admin123");
//  Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type= 'submit']"));
        loginButton.click();
//  Verify the ‘Dashboard’ text is display
       String expectedMessage =  "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Invalid Text",expectedMessage,actualMessage);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}

