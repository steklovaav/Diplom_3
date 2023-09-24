import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MainTest extends Base{
    @Test
    public void scrollFillings(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickfillingsButton();
        Assert.assertTrue(mainPage.isVisibleFillings());
    }
    @Test
    public void scrollSauces(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickSaucesButton();
        Assert.assertTrue(mainPage.isVisibleSauces());
    }
    @Test
    public void scrollRolls(){
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage.waitForLoad();
        mainPage.clickSaucesButton();
        mainPage.clickRollsButton();
        Assert.assertTrue(mainPage.isVisibleRolls());
    }

}
