package ru.lanit.page.objects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassForPage {
    private static final String DNS_URL = "https://www.dns-shop.ru/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseClassForPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    protected void open() {
        driver.navigate().to(DNS_URL);
    }

    public void clickToButton(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }



    //    Кейс
    //1. Открыть сайт https://www.dns-shop.ru/
    //        2. Перейти в раздел Смартфоны
    //3. Отфильтровать список смартфонов
    //* Производитель == Samsung
    //* Объемной встроенной памяти == 265 Гб
    //4. Отсортировать список смартфонов - Сначала дорогие
    //5. Выбрать первый смартфон в списке (Перейти на страницу товара)
    //6. Выполнить проверки данных в разделе Характеристики
    //* Производитель == Samsung
    //* Объем встроенной памяти == 256 Гб
    //7. Повторить пункты 1 - 6 с применением фильтров
    //* Производитель == Apple
    //* Объемной оперативной памяти == 4 Гб
}
