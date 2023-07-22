package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.NotePage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteTest extends BaseTest {
    @Test(groups = {"smokeTest"})
    public void openNoteTest() {
        new LoginPage(driver).open().loginAsStandardUser();
        NotePage notePage = new NotePage(driver).noteClick();
        assertThat(notePage.isOpened()).isTrue().as("Note Page has not been opened");
    }
}
