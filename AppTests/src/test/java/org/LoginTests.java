package org;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class LoginTests extends BaseTest {


    @BeforeEach
    void setUp() {
        driver.get("file:///Users/anpilog/Desktop/Irina/Projects/App/index.html");
    }

    //
    @DisplayName("Test Elements Are Displayed")
    @Test
    void testElementsAreDisplayed() {
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
    }

    @DisplayName("Test Valid Login")
    @Test
    void validLogin() {
        driver.findElement(By.id("username")).sendKeys("john doe");
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.tagName("button")).click();

        Assert.assertEquals("Welcome to the App!", driver.findElement(By.id("message")).getText());
        Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());
    }

    @DisplayName("Test Invalid Login")
    @Test
    void invalidLogin() {
        driver.findElement(By.id("username")).sendKeys("john");
        driver.findElement(By.id("password")).sendKeys("demo");
        driver.findElement(By.tagName("button")).click();

        Assert.assertEquals("Please enter correct username and/or password!", driver.findElement(By.id("message")).getText());
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
    }


}
