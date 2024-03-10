package com.blazedemo.test;

//BlazeDemoTest.java
//This class contains the test methods for the assessment
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeDemoTest extends BaseTest {
 // Define the data provider for parameterized data
 @DataProvider(name = "cities")
 public Object[][] createCitiesData() {
     return new Object[][] {
             {"Mexico City", "London"},
             {"Paris", "Buenos Aires"},
             {"San Diego", "New York"}
     };
 }

 // Define the test method for checking the title of the home page
 @Test
 public void verifyHomePageTitle() {
     // Navigate to the home page url
     driver.get("https://blazedemo.com/index.php");    
     HomePage homePage = new HomePage(driver);   
     String title = homePage.getTitle();  
     Assert.assertEquals(title, "Welcome to the Simple Travel Agency!");
 }

 // Define the test method for checking the destination of the week link
 @Test
 public void verifyDestinationOfTheWeekLink() {
     driver.get("https://blazedemo.com/index.php");
   
     HomePage homePage = new HomePage(driver);   
     homePage.clickDestinationOfTheWeekLink();    
     driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
     String url = homePage.getCurrentUrl();
     Assert.assertTrue(url.contains("vacation"));
     driver.close();
     driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
 }

 // Defining the test method for purchasing a ticket using parameterized data
 @Test(dataProvider = "cities")
 public void purchaseTicket(String departureCity, String destinationCity) {
 
     driver.get("https://blazedemo.com/index.php");
     
     HomePage homePage = new HomePage(driver);
     
     // Select the departure city and the destination city
     homePage.selectDepartureCity(departureCity);
     homePage.selectDestinationCity(destinationCity);
     
     homePage.clickFindFlightsButton();
 
     FlightsPage flightsPage = new FlightsPage(driver);
     flightsPage.selectFlightWithLowestPrice();
     PurchasePage purchasePage = new PurchasePage(driver);
     // Get the total cost of the flight
     String totalCost = purchasePage.getTotalCost();
     Assert.assertTrue(totalCost.matches("\\$\\d+\\.\\d{2}"));
     purchasePage.clickPurchaseFlightButton();
     ConfirmationPage confirmationPage = new ConfirmationPage(driver);
     String id = confirmationPage.getId();
     // Print the id to the console or test report
     System.out.println("The id of the purchase is: " + id);
 }
}
