package by.teachmeskills;

import by.teachmeskills.page.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.teachmeskills.page.RegisterPage.ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class NegativeRegisterTest extends BaseTest {

    @DataProvider
    public Object[][] incorrectDates() {
        return new Object[][]{
                {"dfdf@gmaicom", "543211qWEr", "543211qWEr"},
                {"lll3gmslll@gmail.com", "543211qWEr", ""},
                {"lll3gmslll@gmail.com", "", "543211qWEr"},
        };
    }

    @Test(dataProvider = "incorrectDates")
    public void incorrectDates(String email, String password, String confirmPassword) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open()
                .registerAs(email, password, confirmPassword);
        assertThat(registerPage.getErrorText()).isEqualTo(ERROR_MESSAGE)
                .as("The error message should be displayed");
    }
}
