package ru.lanit.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhoneTabletAndPhotoPage extends BaseClassForPage {

    public PhoneTabletAndPhotoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/a[contains(@class, \"popular-categories__title\") and text()=\"Смартфоны\"]")
    public WebElement buttonToSelectPhone;

    public void navigateToMobil() {
        clickToButton(buttonToSelectPhone);
    }
}
