package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    private By blockTitle = By.cssSelector("section.pay h2");
    private By paymentLogos = By.cssSelector(".pay__partners img");
    private By moreInfoLink = By.cssSelector("section.pay a[href*='poryadok-oplaty']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBlockTitleText() {
        return driver.findElement(blockTitle).getText().replace("\n", " ");
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    public void clickMoreInfoLink() {
        driver.findElement(moreInfoLink).click();
    }
}
