package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By blockTitle = By.cssSelector("section.pay h2");
    private By paymentLogos = By.cssSelector(".pay__partners img");
    private By moreInfoLink = By.cssSelector("section.pay a[href*='poryadok-oplaty']");

    private By selectHeader = By.cssSelector(".select__header");
    private By selectItems = By.cssSelector(".select__list .select__item");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return driver.findElement(blockTitle).getText().replace("\n", " ").toUpperCase();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLink).click();
    }

    public void selectServiceOption(String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectItems));
        List<WebElement> items = driver.findElements(selectItems);
        for (WebElement item : items) {
            if (item.getText().trim().equalsIgnoreCase(optionText)) {
                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        throw new RuntimeException("Пункт '" + optionText + "' не найден в списке");
    }

    public String getPlaceholderInActiveForm(String cssSelectorForInput) {
        WebElement input = driver.findElement(
                By.cssSelector("form.pay-form.opened " + cssSelectorForInput));
        return input.getAttribute("placeholder");
    }

    public boolean isImageLoaded(WebElement image) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && " +
                        "typeof arguments[0].naturalWidth != 'undefined' && " +
                        "arguments[0].naturalWidth > 0", image);
    }
}