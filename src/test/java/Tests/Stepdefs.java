package Tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefs {

    WebDriver driver;
    @Given("^I go to \"([^\"]*)\"$")
    public void iGoTo(String arg0) throws Throwable {
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/channel/UCSMFeUcRuAqIGQu3RWOlCRg");
    }

    @Then("^I should be on \"([^\"]*)\" youtube page$")
    public void iShouldBeOnYoutubePage(String title) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.close();
    }
}
