package by.teachmeskills.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By HOME_NOTE = By.xpath("//div[@class='title ng-binding']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_NOTE));
        return driver.findElement(HOME_NOTE).isDisplayed();
    }
}
