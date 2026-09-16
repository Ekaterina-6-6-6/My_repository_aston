import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBlockTitle {

    public void check(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        By titleLocator = By.cssSelector(".pay h2");

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(titleLocator)
        );

        String actualTitle = title.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim()
                .toLowerCase();

        String expectedTitle =
                "онлайн пополнение без комиссии";

        assertEquals(
                expectedTitle,
                actualTitle,
                "Название блока не соответствует ожидаемому"
        );
    }

}