package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopUpPage {
    private WebDriver driver;

    private By phoneField = By.id("connection-phone");
    private By sumField = By.id("connection-sum");
    private By continueButton = By.cssSelector("#pay-connection button[type='submit']");

    public TopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterSum(String sum) {
        driver.findElement(sumField).clear();
        driver.findElement(sumField).sendKeys(sum);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isContinueButtonEnabled() {
        return driver.findElement(continueButton).isEnabled();
    }
}