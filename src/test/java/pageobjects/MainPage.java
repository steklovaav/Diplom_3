package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By lkButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By fillingsButton = By.xpath(".//span[text()='Начинки']");
    private By fillingsLabel = By.xpath(".//h2[text()='Начинки']");
    private By saucesButton = By.xpath(".//span[text()='Соусы']");
    private By saucesLabel = By.xpath(".//h2[text()='Соусы']");
    private By rollsButton = By.xpath(".//span[text()='Булки']");
    private By rollsLabel = By.xpath(".//h2[text()='Булки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRollsButton() {
        driver.findElement(rollsButton).click();
    }
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }
    public void clickfillingsButton() {
        driver.findElement(fillingsButton).click();
    }
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    public boolean isVisibleFillings() {
        return   driver.findElement(fillingsLabel).isDisplayed();
    }
    public boolean isVisibleSauces() {
        return   driver.findElement(saucesLabel).isDisplayed();
    }
    public boolean isVisibleRolls() {
        return   driver.findElement(rollsLabel).isDisplayed();
    }
    public void clickLKButton() {
        driver.findElement(lkButton).click();
    }

    public void waitForLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(constructorHeader));
    }

    public boolean getDisplayedOrderButton(){
        return  driver.findElement(orderButton).isDisplayed();
    }

}
