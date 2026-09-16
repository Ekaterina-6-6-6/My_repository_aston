import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckContinueButton {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static final String EXPECTED_PAYMENT_SERVICE = "Услуги связи";
    private static final String TEST_PHONE_NUMBER = "297777777";
    private static final String TEST_PAYMENT_AMOUNT = "10";
    private static final String TEST_RECEIPT_EMAIL = "test@example.com";

    private static final By SERVICE_DROPDOWN_BUTTON_LOCATOR =
            By.cssSelector(".pay .select__header");

    private static final By COMMUNICATION_SERVICES_OPTION_LOCATOR =
            By.xpath(
                    "//div[contains(@class,'pay')]" +
                            "//li[contains(@class,'select__item')]" +
                            "[.//p[normalize-space()='Услуги связи']]"
            );

    private static final By SELECTED_PAYMENT_SERVICE_LOCATOR =
            By.cssSelector(".pay .select__now");

    private static final By PHONE_NUMBER_FIELD_LOCATOR =
            By.id("connection-phone");

    private static final By PAYMENT_AMOUNT_FIELD_LOCATOR =
            By.id("connection-sum");

    private static final By RECEIPT_EMAIL_FIELD_LOCATOR =
            By.id("connection-email");

    private static final By CONTINUE_PAYMENT_BUTTON_LOCATOR =
            By.xpath(
                    "//form[@id='pay-connection']" +
                            "//button[normalize-space()='Продолжить']"
            );

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement serviceDropdownButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        SERVICE_DROPDOWN_BUTTON_LOCATOR
                )
        );

        serviceDropdownButton.click();

        WebElement communicationServicesOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        COMMUNICATION_SERVICES_OPTION_LOCATOR
                )
        );

        communicationServicesOption.click();

        String selectedPaymentService = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        SELECTED_PAYMENT_SERVICE_LOCATOR
                )
        ).getText().trim();

        assertEquals(
                EXPECTED_PAYMENT_SERVICE,
                selectedPaymentService,
                "Не выбран вариант 'Услуги связи'"
        );

        WebElement phoneNumberField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        PHONE_NUMBER_FIELD_LOCATOR
                )
        );

        phoneNumberField.clear();
        phoneNumberField.sendKeys(TEST_PHONE_NUMBER);

        WebElement paymentAmountField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        PAYMENT_AMOUNT_FIELD_LOCATOR
                )
        );

        paymentAmountField.clear();
        paymentAmountField.sendKeys(TEST_PAYMENT_AMOUNT);

        WebElement receiptEmailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        RECEIPT_EMAIL_FIELD_LOCATOR
                )
        );

        receiptEmailField.clear();
        receiptEmailField.sendKeys(TEST_RECEIPT_EMAIL);

        String formattedPhoneNumber =
                phoneNumberField.getAttribute("value");

        assertEquals(
                TEST_PHONE_NUMBER,
                formattedPhoneNumber.replaceAll("\\D", ""),
                "Номер телефона введён неправильно: " + formattedPhoneNumber
        );

        assertEquals(
                TEST_PAYMENT_AMOUNT,
                paymentAmountField.getAttribute("value"),
                "Сумма введена неправильно"
        );

        assertEquals(
                TEST_RECEIPT_EMAIL,
                receiptEmailField.getAttribute("value"),
                "E-mail введён неправильно"
        );

        WebElement continuePaymentButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        CONTINUE_PAYMENT_BUTTON_LOCATOR
                )
        );

        assertTrue(
                continuePaymentButton.isEnabled(),
                "Кнопка 'Продолжить' недоступна"
        );

        continuePaymentButton.click();
    }
}
