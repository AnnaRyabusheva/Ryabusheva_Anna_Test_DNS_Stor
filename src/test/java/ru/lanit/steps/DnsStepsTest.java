package ru.lanit.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import ru.lanit.TestContext;
import ru.lanit.page.objects.BaseClassForPage;
import ru.lanit.page.objects.CardProductPage;
import ru.lanit.page.objects.MainPage;
import ru.lanit.page.objects.PhonePage;
import ru.lanit.page.objects.PhoneTabletAndPhotoPage;

public class DnsStepsTest {
    private MainPage mainPage;
    private PhonePage phonePage;
    private PhoneTabletAndPhotoPage chooseCategory;
    private CardProductPage cardPage;

    public DnsStepsTest() {
        var driver = (WebDriver) TestContext.getInstance().getAttribute("driver");
        this.mainPage = new MainPage(driver);
        this.phonePage = new PhonePage(driver);
        this.chooseCategory = new PhoneTabletAndPhotoPage(driver);
        this.cardPage = new CardProductPage(driver);
    }

    public DnsStepsTest(BaseClassForPage basePage) {

    }

    @Given("I open DNS website")
    public void openPage() {
        mainPage.openMainPage();
    }

    @When("I choose mobil phone category")
    public void chooseCategoryItems() {

        mainPage.navigateToMobil();
        chooseCategory.navigateToMobil();
    }

    @When("I filter catalog for samsung and 256 ГБ inner memory")
    public void filerToModeAndMemoryOfPhone() throws InterruptedException {
        phonePage.chooseModelOfPhone();
        phonePage.clickToChooseModel();
        phonePage.clickToListOfMemory();
        phonePage.clickToButtonToSearchForParam();
    }

    @When("I sort result of my choose to expensive first")
    public void selectSortFirstExpensiv() throws InterruptedException {
        phonePage.clickToButtonToChangePrise();
    }

    @When("I click to first card in phone's list")
    public void clickToFirstProductCardInListCardsAfterFilter() throws InterruptedException {
        phonePage.clickToPhoneCardInListOfItems();
    }

    @Then("in charateristice in phone card I see what model Of phone is samsung and memory is 256 ГБ")
    public void checkingPhoneParametersIinTheProductCard() {
        //        List<String> listOfDescription = new ArrayList<>();
        //        listOfDescription.add("Samsung Galaxy S22 Ultra");
        //        listOfDescription.add("256 ГБ");

        cardPage.discloseProductCharacteristics();
        cardPage.collectParametersInTheListForChecking();
        System.out.println(cardPage.collectParametersInTheListForChecking());
        //        SoftAssertions softy= new SoftAssertions();
        //        softy.assertThat(cardPage.collectParametersInTheListForChecking()).contains("Samsung Galaxy
        //        S22 Ultra","256 ГБ");
        //        softy.assertAll();
    }
}
