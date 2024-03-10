package com.blazedemo.test;

//PurchasePage.java
//This class represents the purchase page of the application
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
 // Declare the WebDriver object
 private WebDriver driver;

 // Declare the web elements using @FindBy annotation
 @FindBy(id = "totalCost")
 private WebElement totalCost;

 @FindBy(css = "input[type='submit']")
 private WebElement purchaseFlightButton;

 // Define the constructor and initialize the web elements
 public PurchasePage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }

 // Define the methods to interact with the web elements
 public String getTotalCost() {
     return totalCost.getText();
 }

 public void clickPurchaseFlightButton() {
     purchaseFlightButton.click();
 }
}

