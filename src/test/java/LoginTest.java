import org.junit.Before;
import org.junit.Test;
import pageobjects.ForgotPasswordPage;
import pageobjects.RegistrationPage;

public class LoginTest extends Base{

    @Before
    public void init() {
        this.createUser();
    }

    @Test
    public void enterOnMain(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickEnterButton();
        this.login();
    }
    @Test
    public void enterLoginByLK(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickLKButton();
        this.login();
    }
    @Test
    public void enterFromRegistration(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage page = new RegistrationPage(driver);
        page.waitForLoad();
        page.clickEnterButton();
        this.login();
    }
    @Test
    public void enterFromForgotPasswordPage(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage page = new ForgotPasswordPage(driver);
        page.waitForLoad();
        page.clickEnterButton();
        this.login();
    }


}
