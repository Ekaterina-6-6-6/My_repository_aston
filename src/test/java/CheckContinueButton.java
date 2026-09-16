import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckContinueButton {

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        By selectHeader = By.cssSelector(".pay .select__header");

        WebElement selectButton = wait.until(
                ExpectedConditions.elementToBeClickable(selectHeader)
        );

        selectButton.click();

        By connectionOption = By.xpath(
                "//div[contains(@class,'pay')]//li[contains(@class,'select__item')]" +
                        "[.//p[normalize-space()='Услуги связи']]"
        );

        WebElement connection = wait.until(
                ExpectedConditions.elementToBeClickable(connectionOption)
        );

        connection.click();

        By selectedService = By.cssSelector(".pay .select__now");

        String selectedText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(selectedService)
        ).getText().trim();

        assertEquals(
                "Услуги связи",
                selectedText,
                "Не выбран вариант 'Услуги связи'"
        );

        WebElement phone = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-phone")
                )
        );

        phone.clear();
        phone.sendKeys("297777777");

        WebElement sum = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-sum")
                )
        );

        sum.clear();
        sum.sendKeys("10");

        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("connection-email")
                )
        );

        email.clear();
        email.sendKeys("test@example.com");

        String actualPhone = phone.getAttribute("value");

        assertTrue(
                actualPhone.replaceAll("\\D", "").equals("297777777"),
                "Номер телефона введён неправильно: " + actualPhone
        );

        assertEquals(
                "10",
                sum.getAttribute("value"),
                "Сумма введена неправильно"
        );

        assertEquals(
                "test@example.com",
                email.getAttribute("value"),
                "E-mail введён неправильно"
        );

        By continueButtonLocator = By.xpath(
                "//form[@id='pay-connection']" +
                        "//button[normalize-space()='Продолжить']"
        );

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        continueButtonLocator
                )
        );

        assertTrue(
                continueButton.isEnabled(),
                "Кнопка 'Продолжить' недоступна"
        );

        continueButton.click();
    }
}
