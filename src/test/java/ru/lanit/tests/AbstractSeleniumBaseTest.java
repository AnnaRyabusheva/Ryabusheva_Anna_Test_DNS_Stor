package ru.lanit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractSeleniumBaseTest {
    protected static final String MAIL_URL = "https://www.dns-shop.ru//";

    protected WebDriver driver;

    protected WebDriverWait wait;

//    protected MailPageStepPatternSteps steps;

    @BeforeAll
    static void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(MAIL_URL);
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
//        steps = new MailPageStepPatternSteps(driver);

    }
//
//    @AfterEach
//    public void tearDown() {
//
//        driver.quit();
//    }
}
