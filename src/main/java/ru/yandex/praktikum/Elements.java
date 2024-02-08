package ru.yandex.praktikum;
import org.openqa.selenium.By;

public class Elements {

    //Локатор закрытия кук
    private By closeCookiePanel = By.id("rcc-confirm-button");

    //Локатор для раскрывающегося меню "Сколько стоит? Как платить"
    private By priceAndBuy = By.id("accordion__heading-0");
    //Локатор для раскрывающегося меню "Хочу сразу несколько"
    private By wantSomeScooters = By.id("accordion__heading-1");
    //Локатор для раскрывающегося меню "Как рассчитывается время аренды"
    private By timeCalculation = By.id("accordion__heading-2");
    //Локатор для раскрывающегося меню "Можно ли заказать сегодня?"
    private By orderToday = By.id("accordion__heading-3");
    //Локатор для раскрывающегося меню "Можно ли продлить или вернуть раньше"
    private By extendOrBeforeTheDeadline = By.id("accordion__heading-4");
    //Локатор для раскрывающегося меню "Привозите ли зарядку"
    private By theCharger = By.id("accordion__heading-5");
    //Локатор для раскрывающегося меню "Можно ли отменить заказ"
    private By cancelTheOrder = By.id("accordion__heading-6");
    //Локатор для раскрывающегося меню "Я живу за МКАДом"
    private By liveOutsideMkad = By.id("accordion__heading-7");


    //Локатор панели "Сколько стоит? Как платить"
    private By priceAndBuyPanel = By.id("accordion__panel-0");
    //Локатор панели "Хочу сразу несколько"
    private By wantSomeScootersPanel = By.id("accordion__panel-1");
    //Локатор панели "Как рассчитывается время аренды"
    private By timeCalculationPanel = By.id("accordion__panel-2");
    //Локатор панели "Можно ли заказать сегодня?"
    private By orderTodayPanel = By.id("accordion__panel-3");
    //Локатор панели "Можно ли продлить или вернуть раньше"
    private By extendOrBeforeTheDeadlinePanel = By.id("accordion__panel-4");
    //Локатор панели "Привозите ли зарядку"
    private By theChargerPanel = By.id("accordion__panel-5");
    //Локатор панели "Можно ли отменить заказ"
    private By cancelTheOrderPanel = By.id("accordion__panel-6");
    //Локатор панели "Я живу за МКАДом"
    private By liveOutsideMkadPanel = By.id("accordion__panel-7");


    //две кнопки "Заказать"
    private By buttonOrderTop = By.className("Button_Button__ra12g"); //Верхняя кнопка
    private By buttonOrderBot = By.className("Button_UltraBig__UU3Lp"); //Нижняя кнопка


    //Поля формы заказа первая страница
    //Заголовок страницы "Для кого самокат"
    private By pageTitleUsernameDetails = By.className("Order_Header__BZXOb");
    //Имя
    private By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    //Фамилия
    private By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Адрес
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Станция метро
    private By metroStantionField = By.className("select-search");
    // Телефон
    private By telephoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private By buttonNext = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //Поля формы заказа вторая страница "Про аренду"
    //Заголовой страницы Про аренду
    private By pageTitleRentDetails = By.className("Order_Header__BZXOb");
    //Когда заказать
    private By deliveryTimeField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Срок аренды
    private By rentalPeriodDays =By.className("Dropdown-root");
    //Выбор черного цвета
    private By colorBlackCheckbox = By.id("black");
    //Выбор сегорого цвета
    private By colorGreyCheckbox = By.id("grey");
    //Заполнение поля комментарий
    private By commentsField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
}
