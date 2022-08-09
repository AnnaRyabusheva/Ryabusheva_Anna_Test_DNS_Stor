package ru.lanit.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import ru.lanit.context.TestContext;
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

    @Given("I open DNS website")
    public void openPage() {
        mainPage.openMainPage();
    }

    @When("I choose mobil phone category")
    public void chooseCategoryItems() {

        mainPage.navigateToMobil();
        chooseCategory.navigateToMobil();
    }

    @When("I filter catalog for {string} and {string} of {string} memory")
    public void filerToModeAndMemoryOfPhone(String brand, String capacity, String memoryType) {
        phonePage.chooseModelOfPhone();
        phonePage.clickToChooseModel(brand);
        phonePage.clickToListOfMemory(memoryType, capacity);
        phonePage.clickToButtonToSearchForParam();
    }

    @When("I sort result of my choose to expensive first")
    public void selectSortFirstExpensiv() {
        phonePage.clickToButtonToChangePrise();
    }

    @When("I click to first card in phone's list")
    public void clickToFirstProductCardInListCardsAfterFilter() {
        phonePage.clickToPhoneCardInListOfItems();
    }

    @Then("in characteristics in phone card I see what model Of phone is {string} and {string} is {string}")
    public void checkingPhoneParametersIinTheProductCard(String brand, String memoryType, String capacity) {
        SoftAssertions softy = new SoftAssertions();
        cardPage.discloseProductCharacteristics();
        String itemBrand = cardPage.readProductCharacteristic("Модель");
        String itemMemory = cardPage.readProductCharacteristic(memoryType);
        softy.assertThat(itemBrand).contains(brand);
        softy.assertThat(itemMemory).contains(capacity);
        //        cardPage.collectParametersInTheListForChecking();
        //        System.out.println(cardPage.collectParametersInTheListForChecking());

        //        softy.assertThat(cardPage.collectParametersInTheListForChecking())
        //             .contains(brand,memoryType,capacity);
        softy.assertAll();
    }
}
