package com.testinium.web;

import org.junit.Test;

public class SearchPageTest extends PageTest {

  @Test
  public void search() {
    new SearchPage(driver).search("a");
  }
}