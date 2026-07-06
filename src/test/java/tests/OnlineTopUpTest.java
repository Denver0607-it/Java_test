package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.TopUpPage;

public class OnlineTopUpTest extends BaseTest {

    @Test
    public void checkBlockTitle() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getBlockTitleText(), "ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ");
    }

    @Test
    public void checkPaymentLogosDisplayed() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertFalse(mainPage.getPaymentLogos().isEmpty(), "Логотипы не найдены");
    }

    @Test
    public void checkMoreInfoLinkWorks() {
        MainPage mainPage = new MainPage(driver);
        String urlBefore = driver.getCurrentUrl();
        mainPage.clickMoreInfoLink();
        Assert.assertNotEquals(driver.getCurrentUrl(), urlBefore, "URL не изменился");
    }

    @Test
    public void checkContinueButtonWithPhoneNumber() {
        TopUpPage topUpPage = new TopUpPage(driver);
        topUpPage.enterPhoneNumber("297777777");
        topUpPage.enterSum("10");
        Assert.assertTrue(topUpPage.isContinueButtonEnabled(), "Кнопка неактивна");
        topUpPage.clickContinue();
    }
}