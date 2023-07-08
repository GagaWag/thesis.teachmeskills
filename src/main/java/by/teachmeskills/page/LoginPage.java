package by.teachmeskills.page;


import by.teachmeskills.testng.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class LoginPage extends BasePage {

    private static final By USER_NAME = By.id("login");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@class='btn btn-primary']");
    private static final By ERROR = By.xpath("//div[contains(text(),'Mandatory field')]");
    private static final By DONATE_BUTTON = By.xpath("//a[@ng-show='donationButtonVisible']");

    public static final String MANDATORY_FIELD = "Mandatory field";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME));
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public void loginAs(String userName, String password) {
        driver.findElement(USER_NAME).sendKeys(userName);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("login.url"));
        isOpened();
        waitForPageLoaded();
        return this;
    }

    public HomePage loginAsStandardUser() {
        String userName = "lll3gmslll@gmail.com";
        String password = "543211qWEr";
        loginAs(userName, password);
        return new HomePage(driver);
    }

    public DonatePage donateClick() {
        driver.findElement(DONATE_BUTTON).click();
        return new DonatePage(driver);
    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }
}
