package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Stepdefs {

    WebDriver driver;
    @Given("^I go to \"([^\"]*)\"$")
    public void iGoTo(String arg0) throws Throwable {
        //For Windown
        //System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        //For Linux
        System.setProperty("webdriver.chrome.driver" , System.getProperty("chromedriver"));
        //Headless browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.get("https://www.youtube.com/channel/UCSMFeUcRuAqIGQu3RWOlCRg");
    }

    @Then("^I should be on \"([^\"]*)\" youtube page$")
    public void iShouldBeOnYoutubePage(String title) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.close();
    }
}
