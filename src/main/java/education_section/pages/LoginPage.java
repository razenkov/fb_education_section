package education_section.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    private final String URL = "https://www.facebook.com/";
    private final String EMAIL = "eva.thomposon@gmail.com";
    private final String PASSWORD = "e1v2a3t4";

    @FindBy(how = How.ID, using = "email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "pass")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "loginbutton")
    private WebElement loginButton;

    public void loginToTestAccount(WebDriver driver){
        driver.get(URL);
        emailField.sendKeys(EMAIL);
        passwordField.sendKeys(PASSWORD);
        loginButton.click();
    }

}
