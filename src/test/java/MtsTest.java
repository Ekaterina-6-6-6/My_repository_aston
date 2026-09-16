import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.MtsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("МТС — онлайн пополнение")
public class MtsTest {

    private static final String MTS_URL =
            "https://www.mts.by/";

    private static final String PAYMENT_BLOCK_TITLE =
            "ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ";

    private static final String CONNECTION_PAYMENT_TYPE =
            "Услуги связи";

    private static final String INTERNET_PAYMENT_TYPE =
            "Домашний интернет";

    private static final String INSTALMENT_PAYMENT_TYPE =
            "Рассрочка";

    private static final String ARREARS_PAYMENT_TYPE =
            "Задолженность";

    private static final String CONNECTION_PHONE =
            "297777777";

    private static final String CONNECTION_AMOUNT =
            "10";

    private static final String CONNECTION_EMAIL =
            "test@test.by";

    private static final String PAYMENT_PHONE =
            "375297777777";

    private static final String PAYMENT_AMOUNT =
            "10.00 BYN";

    private static final String SERVICE_DETAILS_URL =
            "https://www.mts.by/help/" +
                    "poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    private static final String CARD_NUMBER_LABEL =
            "Номер карты";

    private static final String EXPIRATION_DATE_LABEL =
            "Срок действия";

    private static final String CVC_LABEL =
            "CVC";

    private static final String CARD_HOLDER_LABEL =
            "Имя и фамилия на карте";

    private static final String PAYMENT_BUTTON_TEXT =
            "Оплатить 10.00 BYN";

    private WebDriver driver;
    private MtsPage mtsPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage()
                .window()
                .maximize();

        driver.get(MTS_URL);

        mtsPage = new MtsPage(driver);

        mtsPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Story("Проверка блока онлайн-пополнения")
    @Description(
            "Проверка заголовка блока " +
                    "онлайн пополнения без комиссии"
    )
    public void checkPaymentBlockTitle() {

        assertEquals(
                PAYMENT_BLOCK_TITLE,
                mtsPage.getPaymentBlockTitle().toUpperCase()
        );
    }

    @Test
    @Story("Проверка логотипов платёжных систем")
    @Description(
            "Проверка наличия логотипов " +
                    "Visa, MasterCard и Белкарт"
    )
    public void checkPaymentLogos() {

        assertTrue(
                mtsPage.isVisaLogoDisplayed()
        );

        assertTrue(
                mtsPage.isMasterCardLogoDisplayed()
        );

        assertTrue(
                mtsPage.isBelkartLogoDisplayed()
        );
    }

    @Test
    @Story("Проверка ссылки на информацию об оплате")
    @Description(
            "Проверка URL ссылки " +
                    "«Подробнее о сервисе»"
    )
    public void checkServiceDetailsLink() {

        assertEquals(
                SERVICE_DETAILS_URL,
                mtsPage.getServiceDetailsLinkUrl()
        );

        mtsPage.clickServiceDetailsLink();

        assertEquals(
                SERVICE_DETAILS_URL,
                mtsPage.getCurrentUrl()
        );
    }

    @Test
    @Story("Проверка оплаты услуг связи")
    @Description(
            "Проверка заполнения формы оплаты " +
                    "и платёжного виджета"
    )
    public void checkConnectionPayment() {

        mtsPage.selectPaymentType(
                CONNECTION_PAYMENT_TYPE
        );

        mtsPage.enterConnectionPhone(
                CONNECTION_PHONE
        );

        mtsPage.enterConnectionAmount(
                CONNECTION_AMOUNT
        );

        mtsPage.enterConnectionEmail(
                CONNECTION_EMAIL
        );

        assertEquals(
                CONNECTION_PHONE,
                mtsPage.getConnectionPhone()
        );

        assertEquals(
                CONNECTION_AMOUNT,
                mtsPage.getConnectionAmount()
        );

        assertEquals(
                CONNECTION_EMAIL,
                mtsPage.getConnectionEmail()
        );

        assertTrue(
                mtsPage.isConnectionContinueButtonEnabled()
        );

        mtsPage.clickConnectionContinueButton();

        mtsPage.switchToPaymentFrame();

        assertEquals(
                PAYMENT_AMOUNT,
                mtsPage.getPaymentAmount()
        );

        assertEquals(
                PAYMENT_PHONE,
                mtsPage.getPaymentPhone()
        );

        assertEquals(
                CARD_NUMBER_LABEL,
                mtsPage.getCardNumberLabel()
        );

        assertEquals(
                EXPIRATION_DATE_LABEL,
                mtsPage.getExpirationDateLabel()
        );

        assertEquals(
                CVC_LABEL,
                mtsPage.getCvcLabel()
        );

        assertEquals(
                CARD_HOLDER_LABEL,
                mtsPage.getCardHolderLabel()
        );

        assertEquals(
                PAYMENT_BUTTON_TEXT,
                mtsPage.getPaymentButtonText()
        );

        assertTrue(
                mtsPage.isPaymentVisaLogoDisplayed()
        );

        assertTrue(
                mtsPage.isPaymentMasterCardLogoDisplayed()
        );

        assertTrue(
                mtsPage.isPaymentBelkartLogoDisplayed()
        );
    }

    @Test
    @Story("Проверка полей форм оплаты")
    @Description(
            "Проверка placeholder полей " +
                    "для всех типов платежей"
    )
    public void checkPaymentTypeInputLabels() {

        mtsPage.selectPaymentType(
                CONNECTION_PAYMENT_TYPE
        );

        assertEquals(
                "Номер телефона",
                mtsPage.getConnectionPhonePlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getConnectionAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getConnectionEmailPlaceholder()
        );

        // Домашний интернет

        mtsPage.selectPaymentType(
                INTERNET_PAYMENT_TYPE
        );

        assertEquals(
                "Номер абонента",
                mtsPage.getInternetPhonePlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getInternetAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getInternetEmailPlaceholder()
        );

        mtsPage.selectPaymentType(
                INSTALMENT_PAYMENT_TYPE
        );

        assertEquals(
                "Номер счета на 44",
                mtsPage.getInstalmentAccountPlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getInstalmentAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getInstalmentEmailPlaceholder()
        );

        mtsPage.selectPaymentType(
                ARREARS_PAYMENT_TYPE
        );

        assertEquals(
                "Номер счета на 2073",
                mtsPage.getArrearsAccountPlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getArrearsAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getArrearsEmailPlaceholder()
        );
    }
}
