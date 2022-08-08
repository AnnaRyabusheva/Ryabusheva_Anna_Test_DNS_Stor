package ru.lanit.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    @After
    public void tearDown() {
        driver.quit();
        TestContext.cleanContext();
    }
}
