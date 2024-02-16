package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    private By closeCookiePanel = By.id("rcc-confirm-button");
    private By buttonOrderTop = By.className("Button_Button__ra12g");
    private By buttonOrderBot = By.xpath(".//div[@class = 'Home_ThirdPart__LSTEE']/div[@class = 'Home_RoadMap__2tal_']/div[@class = 'Home_FinishButton__1_cWm']/button");

    private By buttonsFaq =  By.className("accordion__button");
    private By textFaq = By.className("accordion__panel");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод закрытия панели кук
    public void setCloseCookiePanel() {
        driver.findElement(closeCookiePanel).click();
    }

    //Метод нажатия на кнопки заказать вверху и внизу главной страницы
    public void clickButtonOrder(String order) {
        if(order.equals("Наверху")) {
            driver.findElement(buttonOrderTop).click();
        }
        if(order.equals("Внизу")) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonOrderBot));
            driver.findElement(buttonOrderBot).click();
        }
    }
    //Метод нажатия на вопрос
    public void clickButtonQuestion(int index) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonsFaq));
        driver.findElements(buttonsFaq).get(index).click();
    }
    //Метод получения текста вопроса
    public String getTextButtonQuestion(int index) {
        return driver.findElements(buttonsFaq).get(index).getText();
    }

    //Метод получения текста из вопроса
    public String getTextQuestions(int index) {
        return driver.findElements(textFaq).get(index).getText();
    }
}