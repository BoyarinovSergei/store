package Pages;

import SeleniumConfig.ClassConf;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage extends ClassConf {
    public PasswordRecoveryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"float_l title\"]")
    private WebElement title;

    public String getTitleName(){
        return title.getText();
    }
}