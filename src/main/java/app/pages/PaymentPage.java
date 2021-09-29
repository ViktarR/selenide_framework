package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentPage extends BasePage {
    public PaymentPage(String pageUrl) {
        super(pageUrl);
    }
    private static final SelenideElement TOTAL_PRICE_LABEL = $("#totalPrice");

    public int getTotalPrice(){
        TOTAL_PRICE_LABEL.shouldBe(Condition.visible);
        return Integer.parseInt(TOTAL_PRICE_LABEL.getText().replaceAll("[^0-9]",""));
    }
}