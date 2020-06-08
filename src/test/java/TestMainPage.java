import SeleniumConfig.ClassConf;
import Pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestMainPage extends ClassConf {
    private MainPage mainPage;

    @BeforeClass
    public void beforeClass(){
        initialization();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(properties.getProperty("URL"));
    }

    @AfterMethod
    public void afterMethod(){
        clearCookiesAndLocalStorage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @io.qameta.allure.Description("Авторизоваться валидными данными и проверить имя авторизованного пользователя на сайте")
    @Test(priority = 1)
    public void positiveTest1(){
        mainPage.clickOnLogInButton()
                .setLogin(properties.getProperty("e-mail"))
                .setPassword(properties.getProperty("password"))
                .clickOnInputButton();
        Assert.assertEquals(mainPage.getUserName(), "Пользователь");
    }

    @io.qameta.allure.Description("Нажать на кнопку войти с пустыми полями")
    @Test(priority = 2)
    public void negativeTest1(){
        mainPage.clickOnLogInButton()
                .clickOnInputButton();
        Assert.assertEquals(mainPage.getTextError(), "Неверный логин или пароль");
    }

    @io.qameta.allure.Description("Ввести валидный логин без пароля и проверить, что ошибка появилась")
    @Test(priority = 3)
    public void negativeTest2(){
        mainPage.clickOnLogInButton()
                .setLogin(properties.getProperty("e-mail"))
                .clickOnInputButton();
        Assert.assertEquals(mainPage.getTextError(), "Неверный логин или пароль");
    }

    @io.qameta.allure.Description("Ввести валидный пароль без логина и проверить, что ошибка появилась")
    @Test(priority = 4)
    public void negativeTest3(){
        mainPage.clickOnLogInButton()
                .setPassword(properties.getProperty("password"))
                .clickOnInputButton();
        Assert.assertEquals(mainPage.getTextError(), "Неверный логин или пароль");
    }

    @io.qameta.allure.Description("Авторизоваться невалидными данными и проверить, что ошибка появилась")
    @Test(priority = 5)
    public void negativeTest4(){
        mainPage.clickOnLogInButton()
                .setLogin("asoduihf3324")
                .setPassword("asdfij342")
                .clickOnInputButton();
        Assert.assertEquals(mainPage.getTextError(), "Неверный логин или пароль");
    }

    @io.qameta.allure.Description("Нажать на Забыли пароль и проверить, что переход произошел")
    @Test(priority = 6)
    public void positiveTest2(){
        String name = mainPage.clickOnLogInButton()
                .clickOnForgotPassword()
                .getTitleName();
        Assert.assertEquals(name, "Восстановление пароля");
    }

    @io.qameta.allure.Description("Нажать на Регистрация и проверить, что переход произошел")
    @Test(priority = 7)
    public void positiveTest3(){
        String name = mainPage.clickOnLogInButton()
                .clickOnRegistration()
                .getTitleName();
        Assert.assertEquals(name, "Регистрация");
    }
}