package Pages;

import SeleniumConfig.ClassConf;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage  extends ClassConf {
    public RegisterPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class=\"page_title single\"]")
    private WebElement h2;

    public String getTitleName(){
        return h2.getText();
    }
}