package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {

    public WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public void openPage(String url) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void waitPageisFullyLoaded(WebDriver driver) {
        wait.until((ExpectedCondition<Object>) webDriver ->
                        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement getElement(By locator) {
        waitPageisFullyLoaded(driver);
        Assert.assertFalse("Element is not found!", isElementPresent(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        waitPageisFullyLoaded(driver);
        Assert.assertFalse("Elements not found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean isElementPresent(By locator) {
        waitForElement(locator);
        return getElements(locator).isEmpty();
    }

    public void closePage() {
        driver.quit();
    }
}
