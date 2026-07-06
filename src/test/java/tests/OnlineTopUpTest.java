package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.PaymentWidgetPage;
import pages.TopUpPage;
import java.util.List;

public class OnlineTopUpTest extends BaseTest {

    @Test
    public void checkBlockTitle() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getBlockTitleText(), "ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ");
    }

    @Test
    public void checkPaymentLogosDisplayed() {
        MainPage mainPage = new MainPage(driver);
        List<WebElement> logos = mainPage.getPaymentLogos();
        Assert.assertFalse(logos.isEmpty(), "Логотипы не найдены");

        for (WebElement logo : logos) {
            Assert.assertTrue(mainPage.isImageLoaded(logo),
                    "Логотип не загрузился: " + logo.getAttribute("src"));
        }
    }

    @Test
    public void checkMoreInfoLinkWorks() {
        MainPage mainPage = new MainPage(driver);
        String urlBefore = driver.getCurrentUrl();
        mainPage.clickMoreInfoLink();
        Assert.assertNotEquals(driver.getCurrentUrl(), urlBefore, "URL не изменился");
    }

    @Test
    public void checkPlaceholdersForConnectionService() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceOption("Услуги связи");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#connection-phone"), "Номер телефона");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#connection-sum"), "Сумма");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#connection-email"), "E-mail для отправки чека");
    }

    @Test
    public void checkPlaceholdersForInternet() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceOption("Домашний интернет");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#internet-phone"), "Номер абонента");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#internet-sum"), "Сумма");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#internet-email"), "E-mail для отправки чека");
    }

    @Test
    public void checkPlaceholdersForInstalment() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceOption("Рассрочка");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#score-instalment"), "Номер счета на 44");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#instalment-sum"), "Сумма");
    }

    @Test
    public void checkPlaceholdersForArrears() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectServiceOption("Задолженность");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#score-arrears"), "Номер счета на 2073");
        Assert.assertEquals(mainPage.getPlaceholderInActiveForm("#arrears-sum"), "Сумма");
    }

    @Test
    public void checkPaymentWidgetAfterContinue() {
        TopUpPage topUpPage = new TopUpPage(driver);
        String phone = "297777777";
        String sum = "10";

        topUpPage.enterPhoneNumber(phone);
        topUpPage.enterSum(sum);
        Assert.assertTrue(topUpPage.isContinueButtonEnabled(), "Кнопка неактивна");
        topUpPage.clickContinue();

        PaymentWidgetPage widget = new PaymentWidgetPage(driver);

        Assert.assertEquals(widget.getDisplayedAmount(), sum + ".00 BYN", "Сумма отображается некорректно");
        Assert.assertTrue(widget.getPayButtonText().contains(sum + ".00 BYN"), "Сумма на кнопке некорректна");
        Assert.assertTrue(widget.getOrderInfoText().contains("375" + phone), "Номер телефона отображается некорректно");

        Assert.assertEquals(widget.getCardNumberLabelText(), "Номер карты");
        Assert.assertEquals(widget.getExpiryPlaceholder(), "ММ / ГГ");
        Assert.assertEquals(widget.getExpiryLabelText(), "Срок действия");
        Assert.assertEquals(widget.getCvcLabelText(), "CVC");
        Assert.assertEquals(widget.getHolderLabelText(), "Имя и фамилия на карте");

        Assert.assertFalse(widget.getPaymentSystemIcons().isEmpty(), "Иконки платёжных систем не найдены");
    }
}