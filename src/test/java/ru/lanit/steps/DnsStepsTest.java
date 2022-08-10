package ru.lanit.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
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

    @Description("Открыть сайт https://www.dns-shop.ru/")
    @Given("I open DNS website")
    public void openPage() {
        mainPage.openMainPage();
    }

    @Description("Перейти в раздел Смартфоны")
    @When("I choose mobil phone category")
    public void chooseCategoryItems() {

        mainPage.navigateToMobil();
        chooseCategory.navigateToMobilPhone();
    }

    @When("I filter catalog for {string} and {string} of {string} memory")
    public void filerToModeAndMemoryOfPhone(String brand, String memoryType, String capacity) {
        phonePage.chooseModelOfPhone(brand);
        phonePage.clickToChooseModel(brand);
        phonePage.clickToListOfMemory(memoryType, capacity);
        phonePage.clickToButtonToSearchForParam();
    }

    @When("I sort result of my choose to expensive first")
    public void selectSortFirstExpensive() {
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
        softy.assertAll();
    }
}
