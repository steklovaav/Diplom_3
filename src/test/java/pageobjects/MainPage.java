package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    private By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By lkButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By fillingsButton = By.xpath(".//span[text()='Начинки']");
    private By fillingsButtonParent = By.xpath(".//span[text()='Начинки']/..");
    private By saucesButton = By.xpath(".//span[text()='Соусы']");
    private By saucesButtonParent = By.xpath(".//span[text()='Соусы']/..");
    private By rollsButton = By.xpath(".//span[text()='Булки']");
    private By rollsButtonParent = By.xpath(".//span[text()='Булки']/..");

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

    public void waitForChooseRolls(){
        waitClass(rollsButtonParent,"tab_tab_type_current__2BEPc");
    }
    public void waitForChooseFillings(){
        waitClass(fillingsButtonParent,"tab_tab_type_current__2BEPc");
    }
    public void waitForChooseSauces(){
        waitClass(saucesButtonParent,"tab_tab_type_current__2BEPc");
    }

    public void clickLKButton() {
        driver.findElement(lkButton).click();
    }

    public void waitForLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(constructorHeader));
    }

    public boolean getDisplayedOrderButton() {
        return driver.findElement(orderButton).isDisplayed();
    }

    private void waitClass(By xpath, String className) {
        new WebDriverWait(driver, 3).until((ExpectedCondition<Boolean>) driver -> {
            WebElement element = driver.findElement(xpath);

            String classes = element.getAttribute("class");
            return classes.contains(className);
        });
    }
}
