package by.teachmeskills;

import by.teachmeskills.page.DonatePage;
import by.teachmeskills.page.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DonateTest extends BaseTest {

    @Test
    public void checkDonateTest() {
        DonatePage donatePage = new LoginPage(driver).open().donateClick();
        assertThat(donatePage.isOpened()).isTrue().as("Page Donate has not been opened");
    }
}
