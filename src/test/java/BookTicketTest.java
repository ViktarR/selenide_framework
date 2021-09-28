import app.pages.PaymentPage;
import app.pages.PersonsInfoPage;
import app.pages.TicketOptionsPage;
import helpers.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.FlightInformation;
import pojo.PersonInformation;
import pojo.TicketOption;

public class BookTicketTest extends BaseTest {
    @Test
    public void bookTicket() {
        app.skyupMainPage.open();
        Driver.maximize();
        app.skyupMainPage.closeAllPopUps()
                .addFlightInformation(new FlightInformation());
        TicketOptionsPage ticketInfoPage = app.skyupMainPage.showFlights();
        ticketInfoPage.checkDepartureTicket(TicketOption.BASIC);
        ticketInfoPage.checkReturnTicket(TicketOption.STANDARD);
        PersonsInfoPage personsInfoPage = ticketInfoPage.nextButton();
        PersonInformation personInformation = new PersonInformation();
        personInformation.setCitizenship("Беларусь");
        personsInfoPage.fullFillPersonInfo(personInformation);
        personsInfoPage.nextButton();
        PaymentPage paymentPage = personsInfoPage.applyCovidModalForm();
        Assert.assertTrue(paymentPage.getTotalPrice() > 0);
    }
}
