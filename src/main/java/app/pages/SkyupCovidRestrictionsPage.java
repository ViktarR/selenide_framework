package app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SkyupCovidRestrictionsPage extends BasePage {

    private static final SelenideElement COVID_NEWS_SLIDEBAR = $(".news-single__sidebar");

    public SkyupCovidRestrictionsPage(String pageUrl) {
        super(pageUrl);
    }

    public boolean isCovidRestrictionPageOpened(){
        return COVID_NEWS_SLIDEBAR.exists();
    }
}
