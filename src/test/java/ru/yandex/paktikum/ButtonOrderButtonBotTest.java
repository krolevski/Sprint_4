package ru.yandex.paktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.pageObject.MainPage;
import ru.yandex.praktikum.pageObject.PersonalData;

import static org.hamcrest.CoreMatchers.containsString;

public class ButtonOrderButtonBotTest {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private String order = "Внизу";
    private String result;

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void ordersFormTestButtonBot() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(url);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonOrder(order);
        PersonalData objPersonalData = new PersonalData(driver);
        objPersonalData.waitLoadPersonalData();

        result = objPersonalData.getOrderHeaderText();

        MatcherAssert.assertThat("Не появилcя заголовок страницы", result, containsString("Для кого самокат"));
    }
}