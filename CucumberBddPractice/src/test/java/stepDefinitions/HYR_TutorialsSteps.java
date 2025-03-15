package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HYR_TutorialsSteps {
    WebDriver driver = new ChromeDriver();

    @Given("^I launch Chrome browser$")
    public void i_launch_Chrome_browser() throws Throwable {

	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
    }

    @When("^I open orange hrm homepage$")
    public void i_open_orange_hrm_homepage() throws Throwable {
	driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
    }

    @Then("^I verify that logo present on the home page$")
    public void i_verify_that_logo_present_on_the_home_page() throws Throwable {
	WebElement ele = driver.findElement(By.id("Header1_headerimg"));
	Assert.assertTrue(ele.isEnabled());
    }

    @And("^Close browser")
    public void close_browser() throws Throwable {
	driver.quit();
    }
}
