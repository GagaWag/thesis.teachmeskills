package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DonatePage extends BasePage {

    private static final By EUR_BUTTON = By.xpath("//button[contains(@data-amount,  '50')]");

    public DonatePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EUR_BUTTON));
        return driver.findElement(EUR_BUTTON).isDisplayed();
    }
}
