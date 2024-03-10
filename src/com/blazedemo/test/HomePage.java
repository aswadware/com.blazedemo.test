package com.blazedemo.test;

//HomePage.java
//This class represents the home page of the application
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 // Declare the WebDriver object
 private WebDriver driver;

 @FindBy(name = "fromPort")
 private WebElement departureCity;

 @FindBy(name = "toPort")
 private WebElement destinationCity;

 @FindBy(css = "input[type='submit']")
 private WebElement findFlightsButton;

 @FindBy(linkText = "destination of the week! The Beach!")
 private WebElement destinationOfTheWeekLink;

 // Define the constructor and initialize the web elements
 public HomePage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }

 // Define the methods to interact with the web elements
 public void selectDepartureCity(String city) {
     departureCity.sendKeys(city);
 }

 public void selectDestinationCity(String city) {
     destinationCity.sendKeys(city);
 }

 public void clickFindFlightsButton() {
     findFlightsButton.click();
 }

 public void clickDestinationOfTheWeekLink() {
     destinationOfTheWeekLink.click();
 }

 public String getTitle() {
     return driver.getTitle();
 }

 public String getCurrentUrl() {
     return driver.getCurrentUrl();
 }
}
