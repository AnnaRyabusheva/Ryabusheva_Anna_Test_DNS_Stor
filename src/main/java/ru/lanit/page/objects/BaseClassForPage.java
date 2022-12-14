package ru.lanit.page.objects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassForPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseClassForPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void clickToButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}
