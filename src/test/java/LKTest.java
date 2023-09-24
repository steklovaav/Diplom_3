import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LKPage;
import pageobjects.LoginPage;

public class LKTest extends Base {

    private LKPage page;
    @Before
    public void init() {
        this.createUser();
        page = new LKPage(driver);
    }

    @Test
    public void enterOnMain(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickEnterButton();
        this.login();
        mainPage.clickLKButton();
        page.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile", driver.getCurrentUrl());
    }
    @Test
    public void goToConstructor(){
        this.enterOnMain();
        page.clickConstructorButton();
        mainPage.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }
    @Test
    public void goToLogo(){
        this.enterOnMain();
        page.clickLogo();
        mainPage.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }
    @Test
    public void exit(){
        this.enterOnMain();
        page.clickExitButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

}
