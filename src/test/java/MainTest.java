import org.junit.Test;

public class MainTest extends Base{
    @Test
    public void scrollFillings(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickfillingsButton();
        mainPage.waitForChooseFillings();
    }
    @Test
    public void scrollSauces() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickSaucesButton();
        mainPage.waitForChooseSauces();
    }
    @Test
    public void scrollRolls() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickSaucesButton();
        mainPage.waitForChooseSauces();
        mainPage.clickRollsButton();
        mainPage.waitForChooseRolls();
    }

}
