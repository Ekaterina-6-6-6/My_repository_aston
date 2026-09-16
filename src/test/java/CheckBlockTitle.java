import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBlockTitle {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static final By BLOCK_TITLE_LOCATOR =
            By.cssSelector(".pay h2");

    private static final String EXPECTED_TITLE =
            "онлайн пополнение без комиссии";

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        WebElement blockTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        BLOCK_TITLE_LOCATOR
                )
        );

        String actualTitle = blockTitle.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();

        assertEquals(
                EXPECTED_TITLE,
                actualTitle,
                "Название блока не соответствует ожидаемому"
        );
    }
}
