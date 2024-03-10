package com.blazedemo.test;

//FlightsPage.java
//This class represents the flights page of the application
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsPage {
 private WebDriver driver;

 @FindBy(css = "table.table tbody tr")
 private List<WebElement> flightsTableRows;

 public FlightsPage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }

 public void selectFlightWithLowestPrice() {
     double lowestPrice = Double.MAX_VALUE;
     int lowestPriceRowIndex = -1;
     for (int i = 0; i < flightsTableRows.size(); i++) {
         WebElement priceColumn = flightsTableRows.get(i).findElement(By.xpath(".//td[6]"));
         double priceValue = Double.parseDouble(priceColumn.getText().replace("$", ""));
         if (priceValue < lowestPrice) {
             lowestPrice = priceValue;
             lowestPriceRowIndex = i;
         }
     }
     WebElement chooseFlightButton = flightsTableRows.get(lowestPriceRowIndex).findElement(By.xpath(".//td[1]/input"));
     chooseFlightButton.click();
 }
}
