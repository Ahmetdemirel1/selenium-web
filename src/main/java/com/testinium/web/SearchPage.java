package com.testinium.web;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

  WebDriver driver;

  public SearchPage(WebDriver driver) {
    this.driver = driver;
  }

  public void search(String text) {

    driver.get("https://www.google.com.tr");

    WebElement searchAreaElement = driver.findElement(By.id("lst-ib"));

    searchAreaElement.sendKeys(text);

    searchAreaElement.sendKeys(Keys.ENTER);

    Assert.assertTrue(driver.getTitle().startsWith(text));

    List<WebElement> webElements =
        driver.findElements(By.cssSelector("#hdtb-msb-vis>div:nth-of-type(2)>a"));

    System.out.println("List size " + webElements.size());

    System.out.println(webElements.get(0).getText());

    Assert.assertEquals("Haberler", webElements.get(0).getText());

    System.out.println(webElements.get(0).getSize().toString());

    System.out.println(webElements.get(0).getLocation().toString());

    System.out.println(webElements.get(0).getAttribute("href"));

    System.out.println(webElements.get(0).getAttribute("class"));

    webElements.get(0).click();

    //driver.quit();
  }
}
