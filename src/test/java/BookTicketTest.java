import org.testng.annotations.Test;
import pojo.FlightInformation;

public class BookTicketTest extends BaseTest {
    @Test
    public void bookTicket() throws InterruptedException {
        app.skyupMainPage.open();
        app.skyupMainPage.closeAllPopUps()
                .addFlightInformation(new FlightInformation());
        FlightInformation.builder().adultsCount(1).build();
Thread.sleep(500000);
    }
}
