import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckServiceLink {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static final String EXPECTED_URL =
            "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    private static final By SERVICE_LINK_LOCATOR =
            By.xpath("//a[normalize-space()='Подробнее о сервисе']");

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement serviceLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        SERVICE_LINK_LOCATOR
                )
        );

        String serviceLinkHref = serviceLink.getAttribute("href");

        assertEquals(
                EXPECTED_URL,
                serviceLinkHref,
                "Ссылка ведёт на неправильный адрес"
        );

        serviceLink.click();

        wait.until(
                ExpectedConditions.urlToBe(EXPECTED_URL)
        );

        assertEquals(
                EXPECTED_URL,
                driver.getCurrentUrl(),
                "Переход по ссылке не выполнен"
        );
    }
}
