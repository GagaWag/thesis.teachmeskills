package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotePage extends BasePage {

    private static final By HOME_BUTTON = By.id("back-to-overview");
    private static final By HOME_NOTE = By.xpath("//div[@class='title ng-binding']");

    public NotePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_BUTTON));
        return driver.findElement(HOME_BUTTON).isDisplayed();
    }

    public NotePage noteClick() {
        driver.findElement(HOME_NOTE).click();
        return new NotePage(driver);
    }
}
