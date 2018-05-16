package com.testinium.web;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

  WebDriver webDriver;

  public LoginPage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void login(String username, String password) {
    webDriver.get("https://www.hepsiburada.com/");
    webDriver.findElement(
        By.cssSelector(".insider-opt-in-notification-button.insider-opt-in-disallow-button"))
        .click();
    WebElement mainLoginButton = webDriver.findElement(By.id("myAccount"));
    mainLoginButton.click();
    Actions actions = new Actions(webDriver);
    actions.moveToElement(mainLoginButton).build().perform();
    WebElement loginElement = webDriver.findElement(By.cssSelector("#login"));
    loginElement.click();

    webDriver.findElement(By.id("email")).sendKeys(username);

    webDriver.findElement(By.id("password")).sendKeys(password);

    webDriver.findElement(By.cssSelector(".btn.full.btn-login-submit")).click();

    mainLoginButton = webDriver.findElement(By.id("myAccount"));
    actions = new Actions(webDriver);
    actions.moveToElement(mainLoginButton).build().perform();

    Assert.assertTrue(webDriver.findElement(By.cssSelector(".logout")).isDisplayed());
  }
}