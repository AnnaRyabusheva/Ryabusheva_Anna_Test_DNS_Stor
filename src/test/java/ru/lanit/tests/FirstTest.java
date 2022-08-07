package ru.lanit.tests;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import ru.lanit.page.objects.BaseClassForPage;
import ru.lanit.page.objects.FirstPage;

public class FirstTest extends AbstractSeleniumBaseTest {

    @Test
    public void firstTest() throws InterruptedException {

        List<String> listOfDescription = new ArrayList<>();
        listOfDescription.add("Samsung Galaxy S22 Ultra");
        listOfDescription.add("256 ГБ");

        BaseClassForPage baseClassForPage = new BaseClassForPage(driver);
        FirstPage firstPage = new FirstPage(driver);
//        SoftAssertions softy = new SoftAssertions();
        firstPage.navigateToMobil();
//        firstPage.chooseCost();
        firstPage.chooseModelOfTelefon();
//        Thread.sleep(6000);
        firstPage.clickTo();
        firstPage.clickToListOfMemory();
//        Thread.sleep(6000);
        firstPage.scroll();           ///////scroll
//        Thread.sleep(6000);
        firstPage.clickToButtonToSearchForParam();
//        firstPage.scrollToCost();
        Thread.sleep(6000);
        firstPage.clickToButtonPrise();
        Thread.sleep(6000);
        firstPage.clickToElem();
        firstPage.clickToRazv();
        assert firstPage.descList().containsAll(listOfDescription);
//        assertThat(firstPage.descList()).containsExactlyElementsOf(listOfDescription);
//        softy.assertAll();

    }
}
