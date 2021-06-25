package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Actions actions;

    String os = System.getProperty("os.name").toLowerCase();

    public SeleniumHelpers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.jse = (JavascriptExecutor)driver;
    }

    //----------- Navigation ------------

    /**
     * Navigate to url address
     *
     * @param url address destination
     */
    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }


    /**
     * Get Text from field
     *
     * @param e WebElement object
     * @return text from field
     */
    public String getText(WebElement e) {
        return waitTillElementIsVisible(e).getText().trim();
    }

    public String getText(By object) {
        return driver.findElement(object).getText();
    }

    /**
     * Click on Element
     *
     * @param e WebElement object
     * @throws InterruptedException
     */
    public void clickOn(WebElement e) throws InterruptedException {
        waitTillElementIsClickable(e).click();
        waitForJavascriptToLoad();
    }

    /**
     * To determine whether WebElement has given Attribute or not
     *
     * @param e             WebElement object
     * @param attributeName attribute name e.g. style
     * @return boolean
     */
    public boolean isElementAtrributePresent(WebElement e, String attributeName) {
        return e.getAttribute(attributeName) != null;
    }

    //Waits

    /**
     * To wait until element is clickable
     *
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsClickable(WebElement e) {
        WebDriverWait wait = new  WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    /**
     * o wait until element is visible
     *
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    /**
     * o wait until element is visible
     *
     * @param e                     WebElement object
     * @param waitDurationInSeconds wait duration in seconds
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e, int waitDurationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, waitDurationInSeconds);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    /**
     * Wait for specified duration and check if element is visible or not
     *
     * @param e        WebElement object
     * @param duration wait duration in seconds
     * @return WebElement if visible or null if not visible
     */
    public WebElement waitInCaseElementVisible(WebElement e, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try {
            return wait.until(ExpectedConditions.visibilityOf(e));
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Waiting before performing next action
     *
     * @param seconds provide duration e.g. 1,2 etc
     * @throws InterruptedException
     */
    public void hardWait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    /**
     * This function will wait for page to load (waiting for java script to finish loading) before moving further
     *
     * @throws InterruptedException
     * @paramWaitTime Maximum time is the time out time. if the page loading completes before timeout, code will process
     */
    public void waitForJavascriptToLoad() throws InterruptedException {
        Thread.sleep(1000);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        try {
            wait.until(expectation);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
    }


    //Navigation

    public String getURL() {
        return driver.getCurrentUrl();
    }

    //Browser's Tab handler
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(int tabNumber) {
        int i = 1;
        for (String winHandle : getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if (i == tabNumber)
                break;
            i++;
        }
    }

}

