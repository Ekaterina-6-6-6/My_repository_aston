import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckServiceLink {

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        By linkLocator = By.xpath(
                "//a[normalize-space()='Подробнее о сервисе']"
        );

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(linkLocator)
        );

        String href = link.getAttribute("href");

        assertFalse(
                href == null || href.isEmpty(),
                "У ссылки 'Подробнее о сервисе' отсутствует href"
        );

        String expectedUrl =
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        assertEquals(
                expectedUrl,
                href,
                "Ссылка ведёт на неправильный адрес"
        );

        String oldUrl = driver.getCurrentUrl();

        link.click();

        wait.until(
                ExpectedConditions.urlToBe(href)
        );

        assertEquals(
                href,
                driver.getCurrentUrl(),
                "Переход по ссылке не выполнен"
        );
    }
}
