package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    public WebDriver driver;
    public WebDriverWait wait;

    public WaitHelper(WebDriver rdriver) {
	driver = rdriver;
	wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	PageFactory.initElements(rdriver, this);
    }

    public void waitForElement(WebElement element, Duration timeOutInSeconds) {

	wait = new WebDriverWait(driver, timeOutInSeconds);
	wait.until(ExpectedConditions.visibilityOf(element));
    }
}
