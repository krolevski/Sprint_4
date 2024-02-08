package ru.yandex.paktikum;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.pageObject.AboutRent;
import ru.yandex.praktikum.pageObject.MainPage;
import ru.yandex.praktikum.pageObject.PersonalData;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class FormOrderTest {
    private WebDriver driver;
    private final String order;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String telephoneNumber;
    private final String date;
    private  final  int rentalPeriod;
    private final String color;
    private final String comments;
    private String result;
    private  final String url = "https://qa-scooter.praktikum-services.ru/";


    public FormOrderTest(String order, String name, String surname, String address, String metro, String telephoneNumber, String date, int rentalPeriod, String color, String comments) {
        this.order = order;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] getUsernname() {
        return new Object[][] {
                {"Наверху", "Мария", "Иванова", "Екатеринбург", "Черкизовская", "89190110101", "05.10.2024", 1, "black", "Спасибо"},
                {"Наверху", "Александр", "Семенов", "Ростов-на-Дону", "Лубянка", "85287569887", "06.02.2024", 5, "grey", "Очень ждем"},
                {"Внизу","Мария", "Иванова", "Екатеринбург", "Черкизовская", "89190110101", "05.10.2024", 1, "black", "Спасибо"},
        };
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void ordersFormTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.get(url);

        if(order.equals("Внизу")) {
            MainPage objMainPage = new MainPage(driver);
            objMainPage.clickButtonOrder(order);
            PersonalData objPersonalData = new PersonalData(driver);
            objPersonalData.waitLoadPersonalData();

            result = objPersonalData.getOrderHeaderText();

            MatcherAssert.assertThat("Не появилcя заголовок страницы", result, containsString("Для кого самокат"));
        } else {
            MainPage objMainPage = new MainPage(driver);
            objMainPage.clickButtonOrder(order);
            PersonalData objPersonalData = new PersonalData(driver);
            objPersonalData.waitLoadPersonalData();
            objPersonalData.setCloseCookiePanel();
            objPersonalData.setNameField(name);
            objPersonalData.setSurnameField(surname);
            objPersonalData.setAddressField(address);
            objPersonalData.selectMetroFromOptions(metro);
            objPersonalData.setTelephoneNumberField(telephoneNumber);
            objPersonalData.setButtonNext();

            AboutRent objAboutRent = new AboutRent(driver);
            objAboutRent.waitLoadAboutRent();
            objAboutRent.setDeliveryTimeField(date);
            objAboutRent.setRentalPeriod(rentalPeriod);
            objAboutRent.setColorCheckbox(color);
            objAboutRent.setCommentsField(comments);
            objAboutRent.setOrder();

            result = objAboutRent.getTextWindowOrder();

            MatcherAssert.assertThat("Не появилось окно об оформленом заказе", result, containsString("Заказ оформлен"));
        }
    }
}
