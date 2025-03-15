package stepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sai.cucumber.BaseClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddAdminUserinHRM;
import pageObject.LoginPage;

public class OrangeHRM_Login extends BaseClass {

    @Before
    public void setUp() throws IOException {
	// Reading Properties
	FileReader reader = new FileReader(
		"D:\\Eclipse-23-24\\CucumberBddPractice\\src\\test\\resources\\config.properties");
	prop = new Properties();
	prop.load(reader);

	String dr = prop.getProperty("browser");
	if (dr.equals("chrome")) {

	    driver = new ChromeDriver();
	} else if (dr.equals("firefox")) {
	    driver = new FirefoxDriver();
	} else {
	    driver = new EdgeDriver();
	}
	driver.manage().window().maximize();

	// Logger
	logger = Logger.getLogger("CucumberBddPractice"); // Added logger
	PropertyConfigurator
		.configure("D:\\Eclipse-23-24\\CucumberBddPractice\\src\\test\\java\\pageObject\\LoginPage.java"); // Added
    }

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {

	lp = new LoginPage(driver);
	System.out.println(lp.getCurrentUrl());
	logger.info("***** Launching Browser ******");
	admin = new AddAdminUserinHRM(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
	logger.info("***** Launching URL ******");
	lp.getUrl(url);
    }

    @When("User enters UserName as {string} and Password as {string}")
    public void user_enters_user_name_as_and_password_as(String userName, String password) throws InterruptedException {
	// Thread.sleep(4000);
	logger.info("***** Entering UserName ******");
	lp.setUserName(userName);
	logger.info("***** Entering Password ******");
	lp.setPassword(password);
    }

    @When("Click on login")
    public void click_on_login() throws InterruptedException {

	lp.Submit();
	Thread.sleep(5000);
	if (driver.getPageSource().contains("Invalid credentials")) {
	    logger.info("***** You have Entered in valid credentials *********");
	} else {
	    logger.info("***** Login Successful With Valid Credentials  ********");
	}

    }

    @Then("Index page CurrentURL should be {string}")
    public void index_page_current_url_should_be(String actualURL) {
	String expectedURL = lp.getCurrentUrl();
	logger.info("***** Current URL is : " + expectedURL + " ******");
	Assert.assertEquals(expectedURL, actualURL);
    }

    @When("User Click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {
	// Thread.sleep(4000);
	lp.simpleClick();
	lp.Logout();
	logger.info("***** Logged Out Successfully  ********");
    }

    @Then("Login page CurrentURL Should be {string}")
    public void login_page_current_url_should_be(String actualURL) {
	String expectedURL = lp.getCurrentUrl();
	logger.info("***** Current URL is : " + expectedURL + " ******");
	Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("close browser")
    public void close_browser() {
	lp.quitDriver();
	logger.info("***** Driver Closed  ********");

    }

    // OrangeHRM Admin user addition !!

    @Then("User Can view DashBoard {string}")
    public void user_can_view_dash_board(String currentURL) {
	String expectedURL = admin.getCurrentURL();
	logger.info("***** Current URL is : " + expectedURL + " ******");
	Assert.assertEquals(currentURL, expectedURL);

    }

    @When("User Click on the Admin Menu")
    public void user_click_on_the_admin_menu() {

	admin.clickAdmin();
    }

    @When("Click on the Add User")
    public void click_on_the_add_user() {
	logger.info("***** Clicking on Admin Page  ********");
	admin.clickAdd();
    }

    @Then("User can view {string} Add new Admin users")
    public void user_can_view_add_new_admin_users(String actualUrl) {

	String expectedUrl = admin.getCurrentURL();
	logger.info("***** Current URL is : " + expectedUrl + " ******");
	Assert.assertEquals(actualUrl, expectedUrl);
	Assert.assertTrue(admin.employeeNameEnabled());

    }

    @When("Enter the Admin user info")
    public void enter_the_admin_user_info() throws InterruptedException {
	admin.addUsername(randomAlphanumericString(10));
	admin.userRole();
	admin.userRoleESS();
	admin.status();
	admin.statusEnabled();
	admin.employeeName("s");
	Thread.sleep(2000);
	admin.employeeNameSpan();
	admin.password("$Ss9704312287");
	admin.confirmPassword("$Ss9704312287");

	logger.info("***** Entered Admin User Details !!!!!!!!!  ********");

    }

    @When("click on save button")
    public void click_on_save_button() {
	admin.submitAdmin();
	logger.info("***** Submitted Admin User Details !!!!!!!!!  ********");
    }

    @Then("User Can view the confirmation message")
    public void user_can_view_the_confirmation_message() throws InterruptedException {
	// Thread.sleep(2000);
	Assert.assertTrue(admin.successMessage());
	logger.info("*****  Admin User Details Added Successfully!!!!!!!!!  ********");
    }

    // Search Admin User

    @When("Enter Admin user UserName")
    public void enter_admin_user_user_name() {
	admin.searchUsername("Admin");
	logger.info("***** Searching a Admin User Details !!!!!!!!!  ********");
    }

    @When("Click on the search button")
    public void click_on_the_search_button() throws InterruptedException {
	admin.searchSubmit();
	logger.info("***** Searching a Admin User Details Click !!!!!!!!!  ********");
	Thread.sleep(2000);
    }

    @Then("User Should found in the search table")
    public void user_should_found_in_the_search_table() {
	admin.validateAdminUser();
	logger.info("*****  Admin User Details Fetteched Successfully!!!!!!!!!  ********");
    }

}
