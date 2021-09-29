package app.pages;

import app.PageBuilder;
import com.codeborne.selenide.SelenideElement;
import pojo.TicketOption;

import static com.codeborne.selenide.Selenide.$;

public class TicketOptionsPage extends BasePage {

    public TicketOptionsPage(String pageUrl) {
        super(pageUrl);
    }

    private static final String BUTTON_CLASS = ".btn-1";

    private static final SelenideElement DEPARTURE_TICKET_RADIO = $("#forwardFlight .tile__radio");
    private static final SelenideElement RETURN_TICKET_RADIO = $("#backwardFlight .tile__radio");
    private static final SelenideElement NEXT_BUTTON = $("#progressNextBtn");
    private static final SelenideElement BASIC_TICKET_OPTION_RADIO = $(".econom-modal__unit--active input[data-fare-code='basic']");
    private static final SelenideElement STANDARD_TICKET_OPTION_RADIO = $(".econom-modal__unit--active input[data-fare-code='standard']");
    private static final SelenideElement FLEX_TICKET_OPTION_RADIO = $(".econom-modal__unit--active input[data-fare-code='flex']");


    public void checkDepartureTicket(TicketOption option) {
        DEPARTURE_TICKET_RADIO.click();
        ticketOption(option).click();
    }

    public void checkReturnTicket(TicketOption option) {
        RETURN_TICKET_RADIO.click();
        ticketOption(option).click();
    }

    public PersonsInfoPage nextButton() {
        NEXT_BUTTON.click();
        return PageBuilder.buildPersonsInfoPage();
    }

    private SelenideElement ticketOption(TicketOption option) {

        switch (option) {
            case BASIC:
                return BASIC_TICKET_OPTION_RADIO.parent().$(BUTTON_CLASS);
            case STANDARD:
                return STANDARD_TICKET_OPTION_RADIO.parent().$(BUTTON_CLASS);
            case FLEX:
                return FLEX_TICKET_OPTION_RADIO.parent().$(BUTTON_CLASS);
        }
        return BASIC_TICKET_OPTION_RADIO.parent().$(BUTTON_CLASS);
    }

}
