package ru.lanit.page.objects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PhonePage extends BaseClassForPage {
    public PhonePage(WebDriver driver) {
        super(driver);
    }

    public static final String FILTER_TYPE_LOCATOR = "//span[contains(text(), \"%s\")]";

    @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
    public WebElement searchButtonToChooseModelOfPhone;

    @FindBy(xpath = "//span[text()=\"Сначала дорогие\"]")
    public WebElement expensiveFirst;

    @FindBy(xpath = "//a/span[text()=\"Сначала недорогие\"]")
    public WebElement cheapFirst;

    @FindBy(xpath = "//div[@data-id= \"product\"]/a[contains(@class, \"ui-link\")]")
    public List<WebElement> listOfPhoneAfterSort;

    @FindBy(xpath = "//div[@class=\"products-list__content\"]")
    public WebElement productListContent;

    public void chooseModelOfPhone(String brand) {

        WebElement brandElement =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-id=\"brand\"]")));
        new Actions(driver).moveToElement(brandElement).perform();
        clickToButton(searchButtonToChooseModelOfPhone);
        wait.until(ExpectedConditions.visibilityOf(searchButtonToChooseModelOfPhone))
            .sendKeys(brand + Keys.ENTER);
    }

    public void clickToChooseModel(String chooseModel) {
        String phoneModel = String.format(FILTER_TYPE_LOCATOR, chooseModel);
        clickToButton(driver.findElement(By.xpath(phoneModel)));
    }

    public void clickToListOfMemory(String filterName, String value) {
        String memoryType = String.format(FILTER_TYPE_LOCATOR, filterName);
        clickToButton(driver.findElement(By.xpath(memoryType)));

        String capacityMemory = String.format(FILTER_TYPE_LOCATOR, value);
        clickToButton(driver.findElement(By.xpath(capacityMemory)));
    }

    public void clickToButtonToSearchForParam() {
        WebElement chooseSort = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[\"left-filters__buttons-main\"]//button[text()=\"Применить\"]")));

        new Actions(driver).moveToElement(chooseSort).perform();
        clickToButton(chooseSort);
    }

    public void clickToButtonToChangePrise() {

        WebElement headerElementToMoveUp =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"receipts__inner\"]")));
        new Actions(driver).moveToElement(headerElementToMoveUp).perform();

        clickToButton(cheapFirst);
        clickToButton(expensiveFirst);
    }

    public void clickToPhoneCardInListOfItems() {
        wait.until(ExpectedConditions.attributeToBe(productListContent, "style", ""));
        WebElement elementOfPhoneAfterSort = wait.until(ExpectedConditions.elementToBeClickable(listOfPhoneAfterSort
            .get(0)));

        clickToButton(elementOfPhoneAfterSort);
    }
}
