import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsTest {

    private static final String BASE_URL = "https://www.mts.by/";
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, TIMEOUT);

        driver.manage().window().maximize();
        driver.get(BASE_URL);

        acceptCookies();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    private void acceptCookies() {
        By acceptButtonLocator = By.xpath(
                "//button[normalize-space()='Принять']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(acceptButtonLocator)
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
