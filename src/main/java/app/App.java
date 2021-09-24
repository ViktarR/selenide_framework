package app;

import app.pages.SkyupMainPage;

public class App {

    public SkyupMainPage skyupMainPage;

    public App() {
        skyupMainPage = PageBuilder.buildSkyupMainPage();
    }
}