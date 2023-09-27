import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pojo.Login;
import pojo.SuccessAuthResponse;
import pojo.UserFields;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Base {
    protected WebDriver driver;
    protected final String name = "Анна";
    protected final String email = "avsteklova@gmail.com";
    protected final String password = "пароль";
    protected SuccessAuthResponse tokens;
    protected MainPage mainPage;

    @Before
    public void baseInit() {
        driver = new ChromeDriver();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        mainPage = new MainPage(driver);
    }

    protected void createUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(new UserFields(email, password, name))
                .post("/api/auth/register");
        response.then().statusCode(200);
        response.then().assertThat().body("success", equalTo(true));
        this.tokens = response.body().as(SuccessAuthResponse.class);
    }

    protected void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickEnterButton();
        mainPage.waitForLoad();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
        Assert.assertTrue(mainPage.getDisplayedOrderButton());
    }


    @After
    public void close() {
       driver.quit();
        if (tokens == null) {
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(new Login(email, password))
                    .post("/api/auth/login");
            if (response.statusCode() == 200) {
                tokens = response.body().as(SuccessAuthResponse.class);
            }
        }
        if (tokens != null) {
            Response response = given().header("authorization", tokens.getAccessToken())
                    .delete("/api/auth/user", Map.of());
            response.then().statusCode(202);
            response.then().assertThat().body("success", equalTo(true));
        }
    }

}
