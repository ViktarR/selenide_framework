package app.pages;

import app.PageBuilder;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pojo.FlightInformation;

import static com.codeborne.selenide.Selenide.*;

public class SkyupMainPage extends BasePage {

    private static final SelenideElement COVID_RULES_POPUP = $("#covidSafetyRulesModal");
    private static final SelenideElement CLOSE_COVID_POPUP_BUTTON = $("#covidSafetyRulesModal button");
    private static final SelenideElement POPUP_TEXT = $("#covidSafetyRulesModal .modal__title");
    private static final SelenideElement POPUP_READ_BUTTON = $("#covidSafetyRulesModal .inform-modal__btn");
    private static final SelenideElement COOKIE_DIALOG = $(".cookie-modal");
    private static final SelenideElement APPLY_COOKIE_BUTTON = $(".cookie-modal button");

    private static final SelenideElement DEPARTURE_CITY = $("#deprtureCity");
    private static final SelenideElement DEPARTURE_CITY_MODAL_SEARCH = $("#cityModal .cities__search");
    private static final SelenideElement ARRIVAL_CITY = $("#arrivalCity");
    private static final SelenideElement ARRIVAL_CITY_MODAL_SEARCH = $("#cityModal .cities__search");
    private static final SelenideElement FORWARD_DATE = $("#forwardDateItem");
    private static final SelenideElement BACKWARD_DATE = $("#backwardDateItem");
    private static final SelenideElement CLOSE_CALENDAR_BUTTON = $("#datesModalContent>button");
    private static final ElementsCollection AVAILABLE_CALENDAR_DATES = $$("td>.tooltip-trigger");


    private static final String CONCRETE_CALENDAR_DATE_XPATH = "//td/div[contains(text(),'%s')]";


    public SkyupMainPage(String pageUrl) {
        super(pageUrl);
    }

    public SkyupMainPage closeAllPopUps() {
        COVID_RULES_POPUP.shouldBe(Condition.visible);
        CLOSE_COVID_POPUP_BUTTON.click();
        COVID_RULES_POPUP.should(Condition.disappear);
        APPLY_COOKIE_BUTTON.click();
        COOKIE_DIALOG.should(Condition.disappear);
        return this;
    }

    public SkyupCovidRestrictionsPage readCovidRestrictions() {
        COVID_RULES_POPUP.shouldBe(Condition.visible);
        POPUP_READ_BUTTON.click();
        return PageBuilder.buildSkyupCovidRestrictionsPage();
    }

    public boolean isPopUpTextCorrect(String text){
        COVID_RULES_POPUP.shouldBe(Condition.visible);
        System.out.println(POPUP_TEXT.getText());
        return POPUP_TEXT.getText().contains(text);
    }

    public void addFlightInformation(FlightInformation flightInfo) {
        DEPARTURE_CITY.click();
        DEPARTURE_CITY_MODAL_SEARCH.shouldBe(Condition.visible);
        DEPARTURE_CITY_MODAL_SEARCH.setValue(flightInfo.getDepartureCountry()).pressEnter();
        DEPARTURE_CITY_MODAL_SEARCH.shouldBe(Condition.hidden);
        ARRIVAL_CITY.click();
        ARRIVAL_CITY.shouldBe(Condition.visible);
        ARRIVAL_CITY_MODAL_SEARCH.setValue(flightInfo.getArrivalCountry()).pressEnter();
        FORWARD_DATE.click();
        calendarDateElement(flightInfo.getDepartureDate()).click();
        BACKWARD_DATE.click();
        calendarDateElement(flightInfo.getReturnDate()).click();

    }

    private SelenideElement calendarDateElement(String dateElement) {
        if (dateElement.contains("enabled")) {
            if (dateElement.contains("first")) {
                return AVAILABLE_CALENDAR_DATES.first();
            } else {
                return AVAILABLE_CALENDAR_DATES.get(2);
            }
        } else {
            int exactDate = Integer.parseInt(dateElement);
            System.out.println(String.format(CONCRETE_CALENDAR_DATE_XPATH, exactDate));
            return $$(String.format(CONCRETE_CALENDAR_DATE_XPATH, exactDate)).first();
        }
    }

}
