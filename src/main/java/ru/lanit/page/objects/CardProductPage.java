package ru.lanit.page.objects;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardProductPage extends BaseClassForPage {
    public CardProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, \"product-characteristics__expand\") and text()=\"Развернуть все\"]")
    public WebElement razvernut;

    @FindBy(xpath = "//div[@class=\"product-characteristics\"]")
    public List<WebElement> description;

    public void discloseProductCharacteristics() {
        clickToButton(razvernut);
    }

    public List<String> collectParametersInTheListForChecking() {
        wait.until(ExpectedConditions.visibilityOfAllElements(description));
        return description.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}