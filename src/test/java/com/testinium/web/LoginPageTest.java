package com.testinium.web;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginPageTest extends PageTest {

  @Test
  public void login() {
    new LoginPage(driver).login("ali.aktolun@sahabt.com", "12345a");
  }
}