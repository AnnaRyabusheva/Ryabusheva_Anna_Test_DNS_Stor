package ru.lanit.page.objects;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardProductPage extends BaseClassForPage {
    private static final String CHARACTERISTIC_ITEM = "//div[contains(@class, \"product-characteristics__spec\")]"
        + "/div[text()=\" %s \"]//following-sibling::div[contains(@class, \"product-characteristics__spec-value\") ]";

    public CardProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, \"product-characteristics__expand\") and text()=\"Развернуть все\"]")
    public WebElement razvernut;

    @FindBy(xpath = "//div[@class=\"product-characteristics\"]//div[contains(@class,"
        + "\"product-characteristics__spec\")]")
    public List<WebElement> description;

    public void discloseProductCharacteristics() {
        clickToButton(razvernut);
    }

    public String readProductCharacteristic(String name) {
        String itemCard = String.format(CHARACTERISTIC_ITEM, name);
        return driver.findElement(By.xpath(itemCard)).getText();
    }

    public List<String> collectParametersInTheListForChecking() {
        wait.until(ExpectedConditions.visibilityOfAllElements(description));
        return description.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    //    public Map<String,String> collectParametersInTheListForChecking1(){
    //        wait.until(ExpectedConditions.visibilityOfAllElements(description)).stream().collect(Collectors.toMap());
    //
    //    }
}
