package com.testinium.web;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  WebDriver webDriver;
  WebDriverWait webDriverWait;

  public LoginPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.webDriverWait = new WebDriverWait(webDriver, 30, 150);
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
    webDriverWait.until(ExpectedConditions.elementToBeClickable(loginElement)).click();

    webDriver.findElement(By.id("email")).sendKeys(username);

    webDriver.findElement(By.id("password")).sendKeys(password);

    webDriver.findElement(By.cssSelector(".btn.full.btn-login-submit")).click();

    mainLoginButton = webDriver.findElement(By.id("myAccount"));
    actions = new Actions(webDriver);
    actions.moveToElement(mainLoginButton).build().perform();

    WebElement logoutElement = webDriver.findElement(By.cssSelector(".logout"));
    webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutElement));
    System.out.println(logoutElement.getText());

    Assert.assertEquals("Çıkış Yap", logoutElement.getText());
  }
}
