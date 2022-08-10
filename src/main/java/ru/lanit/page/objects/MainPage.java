package ru.lanit.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseClassForPage {

    private static final String DNS_URL = "https://www.dns-shop.ru/";

    public MainPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//a[text()=\"Смартфоны и гаджеты\"]")
    public WebElement buttonSmartphone;

    public void openMainPage() {
        driver.navigate().to(DNS_URL);
    }

    public void navigateToMobil() {
        clickToButton(buttonSmartphone);
    }
}
