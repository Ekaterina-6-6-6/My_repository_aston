import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPaymentLogos {

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        By visa = By.cssSelector(".pay__partners img[alt='Visa']");
        By masterCard = By.cssSelector(".pay__partners img[alt='MasterCard']");
        By belkart = By.cssSelector(".pay__partners img[alt='Белкарт']");

        assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(visa)
                ).isDisplayed(),
                "Логотип Visa не отображается"
        );

        assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(masterCard)
                ).isDisplayed(),
                "Логотип MasterCard не отображается"
        );

        assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(belkart)
                ).isDisplayed(),
                "Логотип Белкарт не отображается"
        );
    }
}
