package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest{
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expected = "Products";
        String actual = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Verify two texts: ",expected, actual);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expected = "Sauce Labs Backpack";
        String actual = driver.findElement(By.xpath("//div[@class='inventory_item_name '][text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals("Verify two texts: ",expected, actual);

        String expect = "Sauce Labs Bike Light";
        String actua = driver.findElement(By.xpath("//div[@class='inventory_item_name '][text()='Sauce Labs Bike Light']")).getText();
        Assert.assertEquals("Verify two texts: ",expect, actua);

        String expectIt = "Sauce Labs Bolt T-Shirt";
        String actually = driver.findElement(By.xpath("//div[@class='inventory_item_name '][text()='Sauce Labs Bolt T-Shirt']")).getText();
        Assert.assertEquals("Verify two texts: ",expectIt, actually);

        String expectedMessage = "Sauce Labs Fleece Jacket";
        String actualMessage = driver.findElement(By.xpath("//div[@class='inventory_item_name '][text()='Sauce Labs Fleece Jacket']")).getText();
        Assert.assertEquals("Verify two texts: ",expectedMessage, actualMessage);

        String expects = "Sauce Labs Onesie";
        String actuals = driver.findElement(By.xpath("//div[@class='inventory_item_name '][text()='Sauce Labs Onesie']")).getText();
        Assert.assertEquals("Verify two texts: ",expects, actuals);

        String expectedWord = "Test.allTheThings() T-Shirt (Red)";
        String actualWord = driver.findElement(By.xpath("//div[@class='inventory_item_name '][text()='Test.allTheThings() T-Shirt (Red)']")).getText();
        Assert.assertEquals("Verify two texts: ",expectedWord, actualWord);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
