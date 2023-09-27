package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;

    private By inputName = By.xpath(".//label[text()='Имя']/following-sibling::input[1]");
    private By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input[1]");
    private By inputPassword = By.xpath(".//label[text()='Пароль']/following-sibling::input[1]");
    private By errorLabel = By.xpath(".//label[text()='Пароль']/parent::div/following-sibling::p[1]");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By enterButton = By.xpath(".//a[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void setName(String name) {
        WebElement element = driver.findElement(inputName);
        element.clear();
        element.sendKeys(name);
    }

    public void setEmail(String email) {
        WebElement element = driver.findElement(inputEmail);
        element.clear();
        element.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement element = driver.findElement(inputPassword);
        element.clear();
        element.sendKeys(password);
    }
    public String getPasswordError() {
        WebElement element = driver.findElement(errorLabel);
        return element.getText();
    }

    public void waitForLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
    }

}
