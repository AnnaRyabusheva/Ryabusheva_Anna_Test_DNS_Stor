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

//    @FindBy(xpath = "//div[@data-id=\"brand\"]")
//    public WebElement brandElem;

    @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
    public WebElement searchButtonToChooseModelOfPhone;

    @FindBy(xpath = "//span[text()=\"Samsung  \"]")
    public WebElement clickToChooseSamsung;

    @FindBy(xpath = "//span[text()=\"Объем встроенной памяти (ГБ)\"]")
    public WebElement listOfMemory;

    @FindBy(xpath = "//span[text()=\"256 ГБ  \"]")
    public WebElement paramOfMemory;

//    @FindBy(xpath = "//div[\"left-filters__buttons-main\"]//button[text()=\"Применить\"]")
//    public WebElement buttonToSearchForParam;

    @FindBy(xpath = "//span[text()=\"Сначала дорогие\"]")
    public WebElement exspensiveFerst;

    @FindBy(xpath = "//a/span[text()=\"Сначала недорогие\"]")
    public WebElement deshFirst;

    @FindBy(xpath = "//div[@data-id= \"product\"]/a[contains(@class, \"ui-link\")]")
    public List<WebElement> webElementList;

    public void chooseModelOfPhone() {

        WebElement brandElement =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-id=\"brand\"]")));
        new Actions(driver).moveToElement(brandElement).perform();
        clickToButton(searchButtonToChooseModelOfPhone);
        wait.until(ExpectedConditions.visibilityOf(searchButtonToChooseModelOfPhone)).sendKeys("Samsung" + Keys.ENTER);
    }

    public void clickToChooseModel() {
        clickToButton(clickToChooseSamsung);
    }

    public void clickToListOfMemory() {

        clickToButton(listOfMemory);
        clickToButton(paramOfMemory);
    }

    public void clickToButtonToSearchForParam() {
        WebElement choose = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[\"left-filters__buttons-main\"]//button[text()=\"Применить\"]")));

        new Actions(driver).moveToElement(choose).perform();
        clickToButton(choose);
    }

    public void clickToButtonToChangePrise() {
        WebElement header =
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"receipts__inner\"]")));
        new Actions(driver).moveToElement(header).perform();

        clickToButton(deshFirst);
        clickToButton(exspensiveFerst);
    }

    public void clickToPhoneCardInListOfItems() {

        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));

        clickToButton(list.get(0));
    }
}
