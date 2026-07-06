package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PaymentWidgetPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By amountText = By.cssSelector(".pay-description__cost span");
    private By orderInfoText = By.cssSelector(".pay-description__text span");

    private By cardNumberLabel = By.cssSelector(".card-number label");
    private By expiryInput = By.cssSelector("input[formcontrolname='expirationDate']");
    private By expiryLabel = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");
    private By cvcLabel = By.xpath("//input[@name='verification_value']/following-sibling::label");
    private By holderLabel = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");

    private By payButton = By.cssSelector("button[type='submit']");
    private By paymentSystemIcons = By.cssSelector(".cards-brands img");

    public PaymentWidgetPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getDisplayedAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountText)).getText();
    }

    public String getOrderInfoText() {
        return driver.findElement(orderInfoText).getText();
    }

    public String getCardNumberLabelText() {
        return driver.findElement(cardNumberLabel).getText();
    }

    public String getExpiryPlaceholder() {
        return driver.findElement(expiryInput).getAttribute("placeholder");
    }

    public String getExpiryLabelText() {
        return driver.findElement(expiryLabel).getText();
    }

    public String getCvcLabelText() {
        return driver.findElement(cvcLabel).getText();
    }

    public String getHolderLabelText() {
        return driver.findElement(holderLabel).getText();
    }

    public String getPayButtonText() {
        return driver.findElement(payButton).getText().trim();
    }

    public List<WebElement> getPaymentSystemIcons() {
        return driver.findElements(paymentSystemIcons);
    }
}