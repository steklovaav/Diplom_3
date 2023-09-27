package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    private By inputEmail = By.xpath(".//label[text()='Email']/following-sibling::input[1]");
    private By inputPassword = By.xpath(".//label[text()='Пароль']/following-sibling::input[1]");
    private By enterButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
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

    public void waitForLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }


}
