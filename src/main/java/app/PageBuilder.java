package app;

import app.pages.*;

public class PageBuilder {

    public static SkyupMainPage buildSkyupMainPage() {
        return new SkyupMainPage("ru");
    }

    public static SkyupCovidRestrictionsPage buildSkyupCovidRestrictionsPage() {
        return new SkyupCovidRestrictionsPage("");
    }

    public static TicketOptionsPage buildTicketOptionsPage() {
        return new TicketOptionsPage("");
    }

    public static PersonsInfoPage buildPersonsInfoPage() {
        return new PersonsInfoPage("");
    }

    public static PaymentPage buildPaymentPage() {
        return new PaymentPage("");
    }

}
