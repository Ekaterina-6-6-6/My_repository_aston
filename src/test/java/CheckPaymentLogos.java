import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPaymentLogos {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static final By VISA_LOGO_LOCATOR =
            By.cssSelector(".pay__partners img[alt='Visa']");

    private static final By MASTERCARD_LOGO_LOCATOR =
            By.cssSelector(".pay__partners img[alt='MasterCard']");

    private static final By BELKART_LOGO_LOCATOR =
            By.cssSelector(".pay__partners img[alt='Белкарт']");

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                VISA_LOGO_LOCATOR
                        )
                ).isDisplayed(),
                "Логотип Visa не отображается"
        );

        assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                MASTERCARD_LOGO_LOCATOR
                        )
                ).isDisplayed(),
                "Логотип MasterCard не отображается"
        );

        assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                BELKART_LOGO_LOCATOR
                        )
                ).isDisplayed(),
                "Логотип Белкарт не отображается"
        );
    }
}
