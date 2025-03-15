package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddAdminUserinHRM {

    public WebDriver driver;
    public WebDriverWait wait;

    public AddAdminUserinHRM(WebDriver rdriver) {
	driver = rdriver;
	wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	PageFactory.initElements(rdriver, this);
    }

    // Create Admin User

    By userName = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By submitUser = By.xpath("//button[@type='submit']");
    By clickAdmin = By.xpath("//span[text()='Admin']");
    By clickAdd = By.cssSelector("[class='oxd-icon bi-plus oxd-button-icon']");
    By addUsername = By.xpath("//label[text()='Username']/following::div[1]/input");
    By userRole = By.cssSelector(
	    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i");
    By userRoleESS = By.xpath("//span[text()='ESS']");
    By status = By.cssSelector(
	    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i");
    By statusEnabled = By.xpath("//span[text()='Enabled']");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeNameSpan = By.cssSelector(
	    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div.oxd-autocomplete-dropdown.--positon-bottom > div:nth-child(1) > span");
    By Password = By.xpath("//label[text()='Password']/following::div[1]/input");
    By confirmPassword = By.xpath("//label[text()='Confirm Password']/following::div[1]/input");
    By submitAdmin = By.xpath("//button[@type='submit']");
    By successMessage = By.xpath("//p[text()='Successfully Saved']");

    // Search Admin User
    By searchUsername = By.xpath("//label[text()='Username']/following::div[1]/input");
    By searchSubmit = By.cssSelector("button[type=\"submit\"]");
    By validateAdminUser = By.xpath("//span[contains(.,'(1) Record Found')]");
    By deleteUser = By.cssSelector("[class='oxd-icon bi-trash']");
    By confirmDeleteUser = By
	    .cssSelector("[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");

    // Action Methods
    // Create Admin User

    public void enterUserName(String userName1) {

	driver.findElement(userName).sendKeys(userName1);
    }

    public void enterPassword(String password1) {

	driver.findElement(password).sendKeys(password1);
    }

    public void submitUser() {

	driver.findElement(submitUser).click();
    }

    public String getCurrentURL() {

	return driver.getCurrentUrl();
    }

    public void clickAdmin() {

	wait.until(ExpectedConditions.elementToBeClickable(clickAdmin));
	driver.findElement(clickAdmin).click();
    }

    public void clickAdd() {
	wait.until(ExpectedConditions.elementToBeClickable(clickAdd));
	driver.findElement(clickAdd).click();
    }

    public void addUsername(String username) {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addUsername));
	driver.findElement(addUsername).sendKeys(username);
    }

    public void userRole() {
	wait.until(ExpectedConditions.elementToBeClickable(userRole));
	driver.findElement(userRole).click();
    }

    public void userRoleESS() {
	wait.until(ExpectedConditions.elementToBeClickable(userRoleESS));
	driver.findElement(userRoleESS).click();
    }

    public void status() {
	wait.until(ExpectedConditions.elementToBeClickable(status));
	driver.findElement(status).click();
    }

    public void statusEnabled() {
	wait.until(ExpectedConditions.elementToBeClickable(statusEnabled));
	driver.findElement(statusEnabled).click();
    }

    public boolean employeeNameEnabled() {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employeeName));
	return driver.findElement(employeeName).isEnabled();
    }

    public void employeeName(String employeeName1) {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employeeName));
	driver.findElement(employeeName).sendKeys(employeeName1);
    }

    public void employeeNameSpan() {
	wait.until(ExpectedConditions.elementToBeClickable(employeeNameSpan));
	driver.findElement(employeeNameSpan).click();
    }

    public void password(String Password1) {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Password));
	driver.findElement(Password).sendKeys(Password1);
    }

    public void confirmPassword(String confirmPassword1) {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmPassword));
	driver.findElement(confirmPassword).sendKeys(confirmPassword1);
    }

    public void submitAdmin() {
	wait.until(ExpectedConditions.elementToBeClickable(submitAdmin));
	driver.findElement(submitAdmin).click();
    }

    public boolean successMessage() {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMessage));
	return driver.findElement(successMessage).isDisplayed();
    }

    // Search Admin User

    public void searchUsername(String searchUsername1) {
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchUsername));
	driver.findElement(searchUsername).sendKeys(searchUsername1);
    }

    public void searchSubmit() {
	wait.until(ExpectedConditions.elementToBeClickable(searchSubmit));
	driver.findElement(searchSubmit).click();
    }

    public void validateAdminUser() {

	wait.until(ExpectedConditions.elementToBeClickable(validateAdminUser));
	driver.findElement(validateAdminUser).isDisplayed();

    }

    // Delete User

    public void deleteUser() {
	wait.until(ExpectedConditions.elementToBeClickable(deleteUser));
	driver.findElement(deleteUser).click();
    }

    public void confirmDeleteUser() {
	wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteUser));
	driver.findElement(confirmDeleteUser).click();
    }

}
