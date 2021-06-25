package pages.flip;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.Collection;

public class FlipPO extends SeleniumHelpers {

    public FlipPO(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    //============================== ELEMENTS DECLARATION ===============================

    @FindBy(xpath = "(//img[@alt='logo-flip'])[2]")
    private WebElement flipLogo;

    @FindBy(css = "#section1 .area-btn-kirim-uang:first-child a")
    private WebElement helpBtn;

    @FindBy(css = ".sc-jnlKLf.gaiLJZ a .c-button")
    private WebElement careerBtn;

    @FindBy(xpath = "//button[@class='c-button sc-cvbbAY gAcrjO sc-hSdWYo eBNDIe']")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[text()='LAYANAN FLIP']")
    private WebElement productPopup;

    //================================= ACTION METHOD ===================================

    public boolean checkTitleColomn(String title) {
        String xpathLocator = "//div/button[contains(.,'" + title + "')]";
        WebElement element = driver.findElement(By.xpath(xpathLocator));
        return waitInCaseElementVisible(element, 3) != null;
    }

    public boolean checkValueDataList(String data) {
        String xpathLocator = "//a[contains(text(), '" + data + "')]";
        WebElement element = driver.findElement(By.xpath(xpathLocator));
        return waitInCaseElementVisible(element, 3) != null;
    }

    public boolean isLogoFlipPresent() {
        return waitInCaseElementVisible(flipLogo, 3) != null;
    }

    public String getHelpTextButton() {
        waitTillElementIsVisible(helpBtn, 3);
        return getText(helpBtn);
    }

    public String getTextButton(String text) {
        String xpathLocator = "//button[text()='"+ text +"']";
        WebElement element = driver.findElement(By.xpath(xpathLocator));
        return getText(element);
    }

    public boolean isCareerButtonPresent() {
        return waitInCaseElementVisible(careerBtn, 3) != null;
    }

    public boolean isLoginButtonPresent() {
        return waitInCaseElementVisible(loginBtn, 3) != null;
    }

    public void clicknavbarButton(String btn) throws InterruptedException {
        String xpathLocator = "//button[text()='"+ btn +"']";
        WebElement element = driver.findElement(By.xpath(xpathLocator));
        clickOn(element);
    }

    public boolean isPopUpProductPresent() {
        return waitTillElementIsVisible(productPopup, 3) != null;
    }

    public String getCareerURL() throws InterruptedException {
        hardWait(2);
        switchToWindow(2);
        return getURL();
    }


}
