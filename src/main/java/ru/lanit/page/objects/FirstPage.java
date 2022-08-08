package ru.lanit.page.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstPage extends BaseClassForPage {

    public FirstPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()=\"Смартфоны и гаджеты\"]")
    public WebElement buttonSmartfon;

    @FindBy(xpath = "//span[text()=\"Смартфоны и гаджеты\"]")
    public WebElement buttonToNavigateListSM;

    @FindBy(xpath = "//span[text()=\"Смартфоны\"]")
    public WebElement buttonToListSmart;

    @FindBy(xpath = "//input[@placeholder=\"Поиск\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()=\"Samsung  \"]")
    public WebElement clickToChoose;

    @FindBy(xpath = "//span[text()=\"Объем встроенной памяти (ГБ)\"]")
    public WebElement listOfMemory;

    @FindBy(xpath = "//span[text()=\"256 ГБ  \"]")
    public WebElement paramOfMemory;

    @FindBy(xpath = "//div[\"left-filters__buttons-main\"]//button[text()=\"Применить\"]")
    public WebElement buttonToSearchForParam;

    //    @FindBy(xpath = "//div[\"left-filters__buttons-main\"]//button[text()=\"Применить\"]")
    //    public WebElement orintFold;

    @FindBy(xpath = "//div[contains(@class, \"picked-filter\") and text()=\"Производитель: Samsung\"]")
    public WebElement headerSmar;

    @FindBy(xpath = "//span[text()=\"Сначала дорогие\"]")
    public WebElement ecspensivFerst;

    @FindBy(xpath = "//a/span[text()=\"Сначала недорогие\"]")
    public WebElement deshFirst;

    @FindBy(xpath = "//div[contains(@class, \"catalog-products view-simple\")]")
    public List<WebElement> webElementList;

    @FindBy(xpath = "//input[@type=\"number\"]")
    public WebElement costMin;

    @FindBy(xpath = "//div[@class=\"products-page__helpers\"]//button[\"Пройти опрос\"]")
    public WebElement buttonToOpros;

    @FindBy(xpath = "//button[contains(@class, \"product-characteristics__expand\") and text()=\"Развернуть все\"]")
    public WebElement razvernut;

    @FindBy(xpath = "//div[@class=\"product-characteristics\"]")
    public List<WebElement> description;

    public void clickToButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public void navigateToMobil() {
        clickToButton(buttonSmartfon);
        clickToButton(buttonToNavigateListSM);
        clickToButton(buttonToListSmart);
    }

    public void chooseModelOfTelefon() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("arguments[0].scrollIntoView();", wait.until(ExpectedConditions.
        //        elementToBeClickable(elemToScrollDown)));
        js.executeScript("window.scrollBy(0,600)");
        clickToButton(searchButton);
        wait.until(ExpectedConditions.visibilityOf(searchButton)).sendKeys("Samsung" + Keys.ENTER);
    }

    public void clickTo() {
        clickToButton(clickToChoose);
    }

    public void clickToListOfMemory() {
        clickToButton(listOfMemory);
        clickToButton(paramOfMemory);
    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }

    public void clickToButtonToSearchForParam() {
        //        wait.until(ExpectedConditions.visibilityOf(orintFold));
        wait.until(ExpectedConditions.visibilityOf(buttonToOpros));
        wait.until(ExpectedConditions.elementToBeClickable(buttonToSearchForParam)).click();
        //        clickToButton(buttonToSearchForParam);
    }

    //    public void scrollToCost() {
    //        Locatable hoverItem = (Locatable) wait.until(ExpectedConditions.visibilityOf(deshFirst));
    //        int y = hoverItem.getCoordinates().onPage().getY();
    //        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");
    //    }

    public void clickToButtonPrise() {
        //        wait.until(ExpectedConditions.textToBePresentInElementValue(headerSmar,"Производитель: Samsung"));
        //        JavascriptExecutor js = (JavascriptExecutor) driver;
        //        js.executeScript("arguments[0].scrollIntoView();",deshFirst );
        clickToButton(deshFirst);
        clickToButton(ecspensivFerst);
    }

    public void clickToElem() {
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

    public void clickToRazv() {
        clickToButton(razvernut);
    }

    public void chooseCost() {
        wait.until(ExpectedConditions.elementToBeClickable(costMin)).sendKeys("125 999" + Keys.TAB + "125 999");
    }

    List<String> listOfDescription = new ArrayList<>();

    public List<String> descList() {
        wait.until(ExpectedConditions.visibilityOfAllElements(description));
        return description.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    //    public void verifyList(){
    //
    //        assertThat               (firstPage.descList()).containsExactlyElementsOf(listOfDescription);
    //    }
}

//        int sizeOfList = webElementList.size();
//        for (int i=1; i<sizeOfList;i++){
//            try {
//                webElementList.get(1).click();
//            } catch (StaleElementReferenceException e){
//                System.out.println("<------------- The element reference of [object Null] -------------> ");
//            }
//            assertFilterCables();
//            clickRackFilter();
//            rackElements = getAllElementsRackFilter(CablingElements.RACK_FILTER_LIST, CablingElements.
//            RACK_FILTER_SELECTED);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0, scrollHeight)");
//        //        List<WebElement>  list=
//        //        wait.until(ExpectedConditions.numberOfElementsToBeLessThan((By) webElementList, 10));
//        //        JavascriptExecutor js = (JavascriptExecutor) driver;
//        //        js.executeScript("window.scrollBy(0,-600");
//        //        Actions action = new Actions(driver);
//        //        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(deshFirst))).click().
//        moveToElement(wait.until(ExpectedConditions.elementToBeClickable(ecspensivFerst))).click().build().perform();
//        //        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//
//        div[@class=\"catalog-products view-simple\"]")));
//        ////        wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) list,"5")).listIterator(0).
//        wait();
//        //        list.get(6).isDisplayed();
///
//
//
// /        System.out.println(list.get(0).getText());
////        for(WebElement s : list) {
////
////            System.out.println(s);
////            list.get(0);
////         }

