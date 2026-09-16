package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieButton = By.xpath(
            "//button[contains(normalize-space(), 'Принять') or " +
                    "contains(normalize-space(), 'Согласен')]"
    );

    private final By paymentBlockTitle = By.cssSelector(".pay h2");

    private final By paymentTypeSelector =
            By.cssSelector(".pay .select__header");

    private final By visaLogo =
            By.cssSelector(".pay__partners img[alt='Visa']");

    private final By masterCardLogo =
            By.cssSelector(".pay__partners img[alt='MasterCard']");

    private final By belkartLogo =
            By.cssSelector(".pay__partners img[alt='Белкарт']");

    private final By serviceDetailsLink =
            By.xpath("//a[normalize-space()='Подробнее о сервисе']");

    private final By connectionPhone =
            By.id("connection-phone");

    private final By connectionAmount =
            By.id("connection-sum");

    private final By connectionEmail =
            By.id("connection-email");

    private final By connectionContinueButton =
            By.xpath(
                    "//form[@id='pay-connection']" +
                            "//button[normalize-space()='Продолжить']"
            );

    private final By internetPhone =
            By.id("internet-phone");

    private final By internetAmount =
            By.id("internet-sum");

    private final By internetEmail =
            By.id("internet-email");

    private final By instalmentAccount =
            By.id("score-instalment");

    private final By instalmentAmount =
            By.id("instalment-sum");

    private final By instalmentEmail =
            By.id("instalment-email");

    private final By arrearsAccount =
            By.id("score-arrears");

    private final By arrearsAmount =
            By.id("arrears-sum");

    private final By arrearsEmail =
            By.id("arrears-email");

    private final By paymentFrame =
            By.cssSelector(
                    "iframe[src*='checkout.bepaid.by/widget_v2']"
            );

    private final By paymentAmount =
            By.cssSelector(".pay-description__cost span");

    private final By paymentDescription =
            By.cssSelector(".pay-description__text span");

    private final By cardNumber =
            By.id("cc-number");

    private final By expirationDate =
            By.cssSelector(
                    "input[formcontrolname='expirationDate']"
            );

    private final By cvc =
            By.cssSelector(
                    "input[formcontrolname='cvc']"
            );

    private final By cardHolder =
            By.cssSelector(
                    "input[formcontrolname='holder']"
            );

    private final By paymentButton =
            By.cssSelector("button[type='submit']");

    private final By paymentVisaLogo =
            By.cssSelector(
                    ".cards-brands__container img[src*='visa-system']"
            );

    private final By paymentMasterCardLogo =
            By.cssSelector(
                    ".cards-brands__container img[src*='mastercard-system']"
            );

    private final By paymentBelkartLogo =
            By.cssSelector(
                    ".cards-brands__container img[src*='belkart-system']"
            );

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    @Step("Принять cookies")
    public void acceptCookies() {
        wait.until(
                ExpectedConditions.elementToBeClickable(cookieButton)
        ).click();
    }

    public String getPaymentBlockTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentBlockTitle
                )
        ).getText().replaceAll("\\s+", " ").trim();
    }

    @Step("Выбрать тип платежа: {paymentType}")
    public void selectPaymentType(String paymentType) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        paymentTypeSelector
                )
        ).click();

        By paymentTypeOption = By.xpath(
                "//div[contains(@class,'pay')]" +
                        "//p[contains(@class,'select__option')" +
                        " and normalize-space()='" +
                        paymentType +
                        "']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        paymentTypeOption
                )
        ).click();
    }

    public boolean isVisaLogoDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        visaLogo
                )
        ).isDisplayed();
    }

    public boolean isMasterCardLogoDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        masterCardLogo
                )
        ).isDisplayed();
    }

    public boolean isBelkartLogoDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        belkartLogo
                )
        ).isDisplayed();
    }

    public String getServiceDetailsLinkUrl() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        serviceDetailsLink
                )
        ).getAttribute("href");
    }

    @Step("Открыть ссылку «Подробнее о сервисе»")
    public void clickServiceDetailsLink() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        serviceDetailsLink
                )
        ).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Ввести номер телефона: {phone}")
    public void enterConnectionPhone(String phone) {
        enterValue(connectionPhone, phone);
    }

    @Step("Ввести сумму: {amount}")
    public void enterConnectionAmount(String amount) {
        enterValue(connectionAmount, amount);
    }

    @Step("Ввести email: {email}")
    public void enterConnectionEmail(String email) {
        enterValue(connectionEmail, email);
    }

    public String getConnectionPhone() {
        return getFieldValue(connectionPhone)
                .replaceAll("\\D", "");
    }

    public String getConnectionAmount() {
        return getFieldValue(connectionAmount);
    }

    public String getConnectionEmail() {
        return getFieldValue(connectionEmail);
    }

    public boolean isConnectionContinueButtonEnabled() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        connectionContinueButton
                )
        ).isEnabled();
    }

    @Step("Нажать кнопку «Продолжить»")
    public void clickConnectionContinueButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        connectionContinueButton
                )
        ).click();

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        paymentFrame
                )
        );
    }

    public String getConnectionPhonePlaceholder() {
        return getPlaceholder(connectionPhone);
    }

    public String getConnectionAmountPlaceholder() {
        return getPlaceholder(connectionAmount);
    }

    public String getConnectionEmailPlaceholder() {
        return getPlaceholder(connectionEmail);
    }

    public String getInternetPhonePlaceholder() {
        return getPlaceholder(internetPhone);
    }

    public String getInternetAmountPlaceholder() {
        return getPlaceholder(internetAmount);
    }

    public String getInternetEmailPlaceholder() {
        return getPlaceholder(internetEmail);
    }

    public String getInstalmentAccountPlaceholder() {
        return getPlaceholder(instalmentAccount);
    }

    public String getInstalmentAmountPlaceholder() {
        return getPlaceholder(instalmentAmount);
    }

    public String getInstalmentEmailPlaceholder() {
        return getPlaceholder(instalmentEmail);
    }

    public String getArrearsAccountPlaceholder() {
        return getPlaceholder(arrearsAccount);
    }

    public String getArrearsAmountPlaceholder() {
        return getPlaceholder(arrearsAmount);
    }

    public String getArrearsEmailPlaceholder() {
        return getPlaceholder(arrearsEmail);
    }

    @Step("Переключиться на платёжный iframe")
    public void switchToPaymentFrame() {

        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        paymentFrame
                )
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentAmount
                )
        );
    }

    public String getPaymentAmount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentAmount
                )
        ).getText().trim();
    }

    public String getPaymentPhone() {

        String description = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentDescription
                )
        ).getText();

        return description.substring(
                description.indexOf("Номер:")
                        + "Номер:".length()
        ).trim();
    }

    public String getCardNumberLabel() {
        return getFieldLabel(cardNumber);
    }

    public String getExpirationDateLabel() {
        return getFieldLabel(expirationDate);
    }

    public String getCvcLabel() {
        return getFieldLabel(cvc);
    }

    public String getCardHolderLabel() {
        return getFieldLabel(cardHolder);
    }

    public String getPaymentButtonText() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                paymentButton
                        )
                ).getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

    public boolean isPaymentVisaLogoDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentVisaLogo
                )
        ).isDisplayed();
    }

    public boolean isPaymentMasterCardLogoDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentMasterCardLogo
                )
        ).isDisplayed();
    }

    public boolean isPaymentBelkartLogoDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentBelkartLogo
                )
        ).isDisplayed();
    }

    private void enterValue(By fieldLocator, String value) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        fieldLocator
                )
        );

        field.clear();
        field.sendKeys(value);
    }

    private String getFieldValue(By fieldLocator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        fieldLocator
                )
        ).getAttribute("value");
    }

    private String getPlaceholder(By fieldLocator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        fieldLocator
                )
        ).getAttribute("placeholder");
    }

    private String getFieldLabel(By fieldLocator) {

        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        fieldLocator
                )
        );

        return field.findElement(
                By.xpath(
                        "./ancestor::*[.//label][1]//label"
                )
        ).getText().trim();
    }
}