package ru.yandex.praktikum.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRent {
    private WebDriver driver;

    private By pageTitleRentDetails = By.className("Order_Header__BZXOb");
    private By deliveryTimeField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By rentalPeriodDays = By.className("Dropdown-root");
    private By colorBlackCheckbox = By.id("black");
    private By colorGreyCheckbox = By.id("grey");
    private By commentsField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By order = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By orderYes = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private By windowOrder = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }
    //Метод ожидания загрузки страницы
    public void waitLoadAboutRent() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(pageTitleRentDetails).getText() != null
                && !driver.findElement(pageTitleRentDetails).getText().isEmpty()
        ));
    }
    //Метод выбора даты доставки
    public void setDeliveryTimeField(String date) {
        driver.findElement(deliveryTimeField).click();
        driver.findElement(deliveryTimeField).sendKeys(date);
        driver.findElement(deliveryTimeField).sendKeys(Keys.RETURN);
    }
    //Метод выбора срока аренды
    public  void setRentalPeriod(int rentalPeriod) {
        driver.findElement(rentalPeriodDays).click();
        String optionLocator = String.format("//div[@class='Dropdown-menu']/div[@class='Dropdown-option'][%d]", rentalPeriod);
        WebElement specificOption = driver.findElement(By.xpath(optionLocator));
        specificOption.click();
    }
    //Метод выбора цвета
    public void setColorCheckbox(String color){
        if(color.equals("black")) {
            driver.findElement(colorBlackCheckbox).click();
        } if(color.equals("grey")) {
            driver.findElement(colorGreyCheckbox).click();
        } else {
            driver.findElement(colorBlackCheckbox).click();
            driver.findElement(colorGreyCheckbox).click();
        }
    }
    //Метод заполнения поля комментарий для курьера
    public void setCommentsField(String comments) {
        driver.findElement(commentsField).click();
        driver.findElement(commentsField).sendKeys(comments);
    }
    //Метод нажатия на кнопку Заказать
    public void setOrder() {
        driver.findElement(order).click();
        driver.findElement(orderYes).click();
    }
    //Метод получения текста из окна, что заказ оформлен
    public String getTextWindowOrder() {
        return driver.findElement(windowOrder).getText();
    }
}