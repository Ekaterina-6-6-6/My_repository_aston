import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lesson_9 {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        acceptCookies();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        By acceptButton = By.xpath(
                "//button[normalize-space()='Принять']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(acceptButton)
        ).click();
    }

    @Test
    void checkBlockTitle() {
        new CheckBlockTitle().check(driver);
    }

    @Test
    void checkPaymentLogos() {
        new CheckPaymentLogos().check(driver);
    }

    @Test
    void checkServiceLink() {
        new CheckServiceLink().check(driver);
    }

    @Test
    void checkContinueButton() {
        new CheckContinueButton().check(driver);
    }
}
