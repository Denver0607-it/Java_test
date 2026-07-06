package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TopUpPage {
    private WebDriver driver;

    private By phoneField = By.id("connection-phone");
    private By sumField = By.id("connection-sum");
    private By emailField = By.id("connection-email");
    private By continueButton = By.cssSelector("#pay-connection button[type='submit']");
    private By paymentWidgetMarker = By.cssSelector(".pay-description__cost");
    private By paymentIframe = By.cssSelector("iframe.payment-widget-iframe");

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

    public boolean isContinueButtonEnabled() {
        return driver.findElement(continueButton).isEnabled();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentIframe));
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentWidgetMarker));
    }
}