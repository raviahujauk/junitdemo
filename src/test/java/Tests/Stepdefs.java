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
        //driver = new ChromeDriver();

        //For Linux
        String chromeDriverPath = "/usr/local/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver" , chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        //Headless browser
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);

        //driver = new ChromeDriver();
        driver.get("https://www.youtube.com/channel/UCSMFeUcRuAqIGQu3RWOlCRg");
    }

    @Then("^I should be on \"([^\"]*)\" youtube page$")
    public void iShouldBeOnYoutubePage(String title) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.close();
    }
}
