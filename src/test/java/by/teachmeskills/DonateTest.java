package by.teachmeskills;

import by.teachmeskills.page.DonatePage;
import by.teachmeskills.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DonateTest extends BaseTest {

    @Test
    public void checkDonateTest() {
        DonatePage donatePage = new LoginPage(driver).open().donateClick();
        assertThat(donatePage.isOpened()).isTrue().as("Page Donate has not been opened");
    }

    @DataProvider
    public Object[][] amount() {
        return new Object[][]{
                {"5"},
                {"100000"},
                {"1000000"},
        };
    }

    @Test(dataProvider = "amount")
    public void amountTest(String amount) {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.open()
                .sendAmount(amount);
        assertThat(donatePage.paypalLogoDisplayed()).isTrue()
                .as("should be displayed PayPal");
    }
}
