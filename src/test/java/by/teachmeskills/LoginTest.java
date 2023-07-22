package by.teachmeskills;

import by.teachmeskills.page.HomePage;
import by.teachmeskills.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.teachmeskills.page.LoginPage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test(groups = {"smokeTest"})
    public void checkLoginForStandardUser() {
        HomePage homePage = new LoginPage(driver).open()
                .loginAsStandardUser();
        assertThat(homePage.isOpened())
                .isTrue()
                .as("Home page should be opened after user logged in with valid credentials");
    }

    @DataProvider
    public Object[][] emptyDates() {
        return new Object[][]{
                {"lll3gmslll@gmail.com", ""},
                {"", "543211qWEr"},

        };
    }

    @Test(dataProvider = "emptyDates")
    public void incorrectDates(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .loginAs(userName, password);
        assertThat(loginPage.getErrorText()).isEqualTo(MANDATORY_FIELD)
                .as("The error \"" + MANDATORY_FIELD + "\" should be displayed if password has not been entered");

    }
}
