package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LKPage {
    private WebDriver driver;

    private By profileButton = By.xpath(".//a[text()='Профиль']");
    private By exitButton = By.xpath(".//button[text()='Выход']");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public LKPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void waitForLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    }


}
