import app.pages.SkyupCovidRestrictionsPage;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;

public class CovidPopUpTest extends BaseTest {
    @Test
    public void popUpText() {
        app.skyupMainPage.open();
        Assert.assertTrue(app.skyupMainPage.isPopUpTextCorrect("ВНИМАНИЕ"));
    }

    @Test
    public void closePopUp() {
        app.skyupMainPage.open();
        app.skyupMainPage.closeAllPopUps();

        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");

        softAssert.assertEquals(2, 1);
        softAssert.assertAll();
    }

    @Test
    public void covidRestrictions() {
        app.skyupMainPage.open();
        SkyupCovidRestrictionsPage restrictionsPage = app.skyupMainPage.readCovidRestrictions();
        softAssert.assertTrue(restrictionsPage.isCovidRestrictionPageOpened());
    }
}
