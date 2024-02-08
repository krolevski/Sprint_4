package ru.yandex.praktikum.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalData {
    private WebDriver driver;

    //Локаторы полей формы заказа первая страница
    private By closeCookiePanel = By.id("rcc-confirm-button");
    private By pageTitleUsernameDetails = By.className("Order_Header__BZXOb");
    private By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroStantionField = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By telephoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //Метод закрытия панели кук
    public void setCloseCookiePanel() {
        driver.findElement(closeCookiePanel).click();
    }
    //Метод ожидание прогрузки страницы
    public void waitLoadPersonalData() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(pageTitleUsernameDetails).getText() != null
                && !driver.findElement(pageTitleUsernameDetails).getText().isEmpty()
        ));
    }
    public PersonalData(WebDriver driver) {
        this.driver = driver;
    }
    //Метод заполнения поля Имя
    public void setNameField(String name) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    //Метод заполнения поля Фамилия
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
    }
    //Метод заполнения поля Адрес
    public void setAddressField(String address) {
        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
    }
    //Метод выбора станции Метро
    public void selectMetroFromOptions(String metro) {
        final String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        final String metroStationSelected = String.format(metroOptionTemplate, metro);
        driver.findElement(metroStantionField).click();
        driver.findElement(By.xpath(metroStationSelected)).click();
    }
    //Метод заполнения поля Телефон
    public void setTelephoneNumberField(String telephoneNumber) {
        driver.findElement(telephoneNumberField).click();
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
    }
    //Метод нажатия кнопки Далее
    public  void setButtonNext() {
        driver.findElement(buttonNext).click();
    }
    //Метод получения текста заголовка страницы
    public String getOrderHeaderText() {
        return driver.findElement(pageTitleUsernameDetails).getText();
    }
}

