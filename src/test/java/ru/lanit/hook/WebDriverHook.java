package ru.lanit.hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.lanit.context.TestContext;

public class WebDriverHook {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        TestContext.getInstance().addAttribute("driver", driver);
        driver.manage().window().maximize();
    }

    @AfterStep
    public void addScrinShot() {
        Allure.addAttachment("Результат шага", new ByteArrayInputStream(((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.BYTES)));
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.cleanContext();
    }
}
