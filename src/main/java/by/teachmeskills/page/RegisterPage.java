package by.teachmeskills.page;

import by.teachmeskills.testng.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class RegisterPage extends BasePage {

    private static final By EMAIL = By.id("registration_email");
    private static final By PASSWORD = By.id("registration_password");
    private static final By CONFIRM_PASSWORD = By.id("registration_password_confirmation");
    private static final By OK_BUTTON = By.xpath("//button[@class='btn btn-primary']");
    private static final By ERROR = By.xpath("//div[@class='alert alert-danger']");

    public static final String ERROR_MESSAGE = "Registration not successful";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        driver.get(properties.getProperty("register.url"));
        waitForPageLoaded();
        return this;
    }

    public void registerAs(String email, String password, String confirmPassword) {
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD).sendKeys(confirmPassword);
        driver.findElement(OK_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (ERROR));

    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }
}
