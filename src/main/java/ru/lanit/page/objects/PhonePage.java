package ru.lanit.page.objects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PhonePage extends BaseClassForPage {
    public PhonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
    public WebElement searchButtonToChooseModelOfPhone;

    @FindBy(xpath = "//span[text()=\"Samsung  \"]")
    public WebElement clickToChooseSamsung;

    @FindBy(xpath = "//span[text()=\"Объем встроенной памяти (ГБ)\"]")
    public WebElement listOfMemory;

    @FindBy(xpath = "//span[text()=\"256 ГБ  \"]")
    public WebElement paramOfMemory;

    @FindBy(xpath = "//div[\"left-filters__buttons-main\"]//button[text()=\"Применить\"]")
    public WebElement buttonToSearchForParam;

    @FindBy(xpath = "//div[@class=\"products-page__helpers\"]//button[\"Пройти опрос\"]")
    public WebElement buttonToOpros;
    // кнопка для спуска к нужному элементу, прогнать тест, если срабатывать без нее будет то удалить

    @FindBy(xpath = "//span[text()=\"Сначала дорогие\"]")
    public WebElement exspensiveFerst;

    @FindBy(xpath = "//a/span[text()=\"Сначала недорогие\"]")
    public WebElement deshFirst;

    @FindBy(xpath = "//div[contains(@class, \"catalog-products view-simple\")]")
    public List<WebElement> webElementList;

    public void chooseModelOfPhone() {
        //        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("window.scrollBy(0,600)");
        clickToButton(searchButtonToChooseModelOfPhone);
        wait.until(ExpectedConditions.visibilityOf(searchButtonToChooseModelOfPhone)).sendKeys("Samsung" + Keys.ENTER);
    }

    public void clickToChooseModel() {
        clickToButton(clickToChooseSamsung);
    }

    public void clickToListOfMemory() throws InterruptedException {
        Thread.sleep(6000);
        clickToButton(listOfMemory);
        clickToButton(paramOfMemory);
    }

    public void clickToButtonToSearchForParam() {
        //        wait.until(ExpectedConditions.visibilityOf(orintFold));
        //        wait.until(ExpectedConditions.visibilityOf(buttonToOpros));
        wait.until(ExpectedConditions.elementToBeClickable(buttonToSearchForParam)).click();
        //        clickToButton(buttonToSearchForParam);
    }

    public void clickToButtonToChangePrise() throws InterruptedException {
        //        wait.until(ExpectedConditions.textToBePresentInElementValue(headerSmar,"Производитель: Samsung"));
        //        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("arguments[0].scrollIntoView();",deshFirst );
        Thread.sleep(6000);
        clickToButton(deshFirst);
        clickToButton(exspensiveFerst);
    }

    public void clickToPhoneCardInListOfItems() throws InterruptedException {
        Thread.sleep(6000);
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
        list.get(0).click();

        for (WebElement webElement : list) {
            webElement.getSize().getWidth();
            if (webElement.isDisplayed()) {
                list.get(0).click();
            }
            //            list.get(0).click();
        }
    }
}
