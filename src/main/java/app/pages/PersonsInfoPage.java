package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pojo.PersonInformation;

import java.time.LocalDate;

import static app.PageBuilder.buildPaymentPage;
import static com.codeborne.selenide.Selenide.$;

public class PersonsInfoPage extends BasePage {

    public PersonsInfoPage(String pageUrl) {
        super(pageUrl);
    }

    private static final SelenideElement FIRST_NAME_INPUT = $(".passenger__item--first-name input");
    private static final SelenideElement LAST_NAME_INPUT = $(".passenger__item--last-name input");
    private static final SelenideElement DAY_OF_BIRTH_SELECT = $(".js-day-of-birth");
    private static final SelenideElement MONTH_OF_BIRTH_SELECT = $(".js-month-of-birth");
    private static final SelenideElement YEAR_OF_BIRTH_SELECT = $(".js-year-of-birth");
    private static final SelenideElement GENDER_SELECT = $(".js-select-gender");
    private static final SelenideElement CITIZENSHIP_SELECT = $(".js-select-citizenship");
    private static final SelenideElement PASSPORT_NUMBER_INPUT = $(".passenger__item--passport-number input");
    private static final SelenideElement DAY_PASSPORT_VALID_SELECT = $(".js-passport-day-validity");
    private static final SelenideElement MOUTH_PASSPORT_VALID_SELECT = $(".js-passport-month-validity");
    private static final SelenideElement YEAR_PASSPORT_VALID_SELECT = $(".js-passport-year-validity");
    private static final SelenideElement NEXT_BUTTON = $("#progressNextBtn");

    private static final SelenideElement COVID_MODAL_FORM = $(".covid-modal__form");
    private static final SelenideElement COVID_MODAL_AGREE_CHECKBOX = $(".covid-modal__form .checkbox__checkmark");
    private static final SelenideElement COVID_MODAL_CONTINUE_BUTTON = $(".covid-modal__form>button");


    public void fullFillPersonInfo(PersonInformation person) {
        FIRST_NAME_INPUT.setValue(person.getFirstName());
        LAST_NAME_INPUT.setValue(person.getLastName());
        fullFillDateForm(DAY_OF_BIRTH_SELECT, MONTH_OF_BIRTH_SELECT, YEAR_OF_BIRTH_SELECT, person.getBirthDay());
        GENDER_SELECT.selectOptionByValue(person.getGender().name().toLowerCase());
        CITIZENSHIP_SELECT.selectOptionContainingText(person.getCitizenship());
        PASSPORT_NUMBER_INPUT.setValue(person.getPassportNumber());
        fullFillDateForm(DAY_PASSPORT_VALID_SELECT, MOUTH_PASSPORT_VALID_SELECT, YEAR_PASSPORT_VALID_SELECT, person.getPassportExpiryDate());
    }

    public void nextButton() {
        NEXT_BUTTON.click();
    }

    public PaymentPage applyCovidModalForm() {
        COVID_MODAL_FORM.shouldBe(Condition.visible);
        COVID_MODAL_AGREE_CHECKBOX.shouldBe(Condition.visible);
        COVID_MODAL_AGREE_CHECKBOX.click();
        COVID_MODAL_CONTINUE_BUTTON.click();
        COVID_MODAL_FORM.shouldBe(Condition.hidden);
        return buildPaymentPage();
    }

    private void fullFillDateForm(SelenideElement daySelect, SelenideElement monthSelect, SelenideElement yearSelect
            , LocalDate date) {
        daySelect.selectOptionByValue(String.valueOf(date.getDayOfMonth()));
        String monthValue = date.getMonthValue() > 0 ? String.valueOf(date.getMonthValue()) : "0" + date.getMonthValue();
        monthSelect.selectOptionByValue("0" + monthValue);
        yearSelect.selectOptionByValue(String.valueOf(date.getYear()));
    }
}
