package by.teachmeskills.page;

import by.teachmeskills.testng.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class DonatePage extends BasePage {

    private static final By EUR_BUTTON = By.xpath("//button[contains(@data-amount,  '50')]");
    private static final By AMOUNT = By.id("amount");
    private static final By PAYPAL_BUTTON = By.xpath("//div[@aria-label='PayPal' and contains (@role, 'link')]");
    private static final By PAYPAL_LOGO = By.xpath("//*[@class='paypal-checkout-close']");

    public DonatePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EUR_BUTTON));
        return driver.findElement(EUR_BUTTON).isDisplayed();
    }

    public DonatePage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("donate.url"));
        isOpened();
        waitForPageLoaded();
        return this;
    }

    public void sendAmount(String amount) {
        driver.findElement(AMOUNT).click();
        driver.findElement(AMOUNT).sendKeys(amount);
        driver.findElement(PAYPAL_BUTTON).click();
    }

    public boolean paypalLogoDisplayed() {
        return driver.findElement(PAYPAL_LOGO).isDisplayed();
    }
}
