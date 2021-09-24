package app;

import app.pages.SkyupCovidRestrictionsPage;
import app.pages.SkyupMainPage;

public class PageBuilder {

    public static SkyupMainPage buildSkyupMainPage() {
        return new SkyupMainPage("ru");
    }
    public static SkyupCovidRestrictionsPage buildSkyupCovidRestrictionsPage() {
        return new SkyupCovidRestrictionsPage("");
    }

}
