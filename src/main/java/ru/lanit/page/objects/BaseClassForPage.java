package ru.lanit.page.objects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassForPage {
    private static final String DNS_URL = "https://www.dns-shop.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseClassForPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    protected void open() {
        driver.navigate().to(DNS_URL);
    }

    public void clickToButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}
