package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitHelper;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public WaitHelper waitHelper;

    public LoginPage(WebDriver rdriver) {
	driver = rdriver;
	wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	PageFactory.initElements(rdriver, this);
	waitHelper = new WaitHelper(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    @CacheLookup
    WebElement Username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement Submit;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    @CacheLookup
    WebElement Logout;

    @FindBy(css = "[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    @CacheLookup
    WebElement simpleClick;

    public void setUserName(String userName) {
	wait.until(ExpectedConditions.visibilityOf(Username));
	Username.clear();
	Username.sendKeys(userName);
    }

    public void setPassword(String password) {
	wait.until(ExpectedConditions.visibilityOf(Password));
	Password.clear();
	Password.sendKeys(password);
    }

    public void Submit() {
	wait.until(ExpectedConditions.visibilityOf(Submit));
	Submit.click();
    }

    public void Logout() {
	// wait.until(ExpectedConditions.visibilityOf(Logout));
	waitHelper.waitForElement(Logout, Duration.ofMillis(5000));
	Logout.click();
    }

    public String getCurrentUrl() {

	return driver.getCurrentUrl();
    }

    public void getUrl(String url) {

	driver.get(url);
    }

    public void quitDriver() {

	driver.quit();
    }

    public void simpleClick() {
	wait.until(ExpectedConditions.visibilityOf(simpleClick));
	simpleClick.click();
    }
}
