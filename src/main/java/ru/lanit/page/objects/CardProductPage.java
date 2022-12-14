package ru.lanit.page.objects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CardProductPage extends BaseClassForPage {
    private static final String CHARACTERISTIC_ITEM = "//div[contains(@class, \"product-characteristics__spec\")]"
        + "/div[text()=\" %s \"]//following-sibling::div[contains(@class, \"product-characteristics__spec-value\") ]";

    public CardProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, \"product-characteristics__expand\") and text()=\"Развернуть все\"]")
    public WebElement expand;

    @FindBy(xpath = "//div[@class=\"product-characteristics\"]//div[contains(@class,"
        + "\"product-characteristics__spec\")]")
    public List<WebElement> description;

    public void discloseProductCharacteristics() {
        clickToButton(expand);
    }

    public String readProductCharacteristic(String name) {
        String itemCard = String.format(CHARACTERISTIC_ITEM, name);
        return driver.findElement(By.xpath(itemCard)).getText();
    }
}
