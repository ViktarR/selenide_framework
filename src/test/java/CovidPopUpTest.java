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
    }

    @Test
    public void covidRestrictions() {
        app.skyupMainPage.open();
        SkyupCovidRestrictionsPage restrictionsPage = app.skyupMainPage.readCovidRestrictions();
        softAssert.assertTrue(restrictionsPage.isCovidRestrictionPageOpened());
    }
}
