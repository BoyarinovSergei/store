package Pages;

import SeleniumConfig.ClassConf;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends ClassConf {
    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href=\"/user/auth/?backurl=%2F\"]")
    private WebElement logInButton;

    @FindBy(xpath = "//span[@class=\"float_l title\"]")
    private WebElement title;

    @FindBy(xpath = "//input[@name=\"USER_LOGIN\"]")
    private WebElement login;

    @FindBy(xpath = "//input[@name=\"USER_PASSWORD\"]")
    private WebElement password;

    @FindBy(xpath = "//a[@href=\"/user/passwordrecovery/\"]")
    private WebElement forgotPassword;

    @FindBy(xpath = "//span[contains(text(),'Регистрация ')]")
    private WebElement registration;

    @FindBy(xpath = "//a[@title=\"Войти\"]")
    private WebElement inputButton;

    @FindBy(xpath = "//a[@class=\"icon inner \"]")
    private WebElement userName;

    @FindBy(xpath = "//span[@id=\"authErrorCommon\"]")
    private WebElement error;

    @FindBy(xpath = "//div[@class=\"popup-inner paddingB\"]/span")
    private WebElement closeButton;

    @FindBy(xpath = "//li[@class=\"item logout\"]")
    protected WebElement logoutButton;

    public String getTextError(){
        return wait.until(ExpectedConditions.visibilityOf(error)).getText();
    }

    public String getUserName(){
        return userName.getText();
    }

    public MainPage clickOnLogInButton(){
        logInButton.click();
        return this;
    }

    public MainPage setLogin(String loginValue){
        login.sendKeys(loginValue);
        return this;
    }

    public MainPage setPassword(String passwordValue){
        password.sendKeys(passwordValue);
        return this;
    }

    public PasswordRecoveryPage clickOnForgotPassword(){
        forgotPassword.click();
        return new PasswordRecoveryPage();
    }

    public RegisterPage clickOnRegistration(){
        registration.click();
        return new RegisterPage();
    }

    public MainPage clickOnInputButton(){
        inputButton.click();
        return this;
    }
}