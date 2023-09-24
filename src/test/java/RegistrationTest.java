import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;

public class RegistrationTest extends Base{
    private RegistrationPage page;


    @Before
    public void init() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        page = new RegistrationPage(driver);
        page.waitForLoad();
    }

    @Test
    public void successRegistration() {
        page.setName(name);
        page.setEmail(email);
        page.setPassword(password);
        page.clickRegistrationButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @Test
    public void errorMinimalPassword() {
        page.setName(name);
        page.setEmail(email);
        page.setPassword("123");
        page.clickRegistrationButton();
        Assert.assertEquals("Некорректный пароль", page.getPasswordError());
    }



}
