package education_section.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class WorkEducationPage {
    @FindBy(how = How.NAME, using = "employer_name")
    public WebElement employer_name;

    @FindBy(how = How.NAME, using = "position_text")
    public WebElement position;

    @FindBy(how = How.NAME, using = "location_text")
    public WebElement city;

    @FindBy(how = How.NAME, using = "description")
    public WebElement description;

    @FindBy(how = How.NAME, using = "date[current]")
    private WebElement isCurrentCheckbox;

    @FindBy(how = How.ID, using = "u_v_0")
    private WebElement shareFilter;

    @FindBy(how = How.ID, using = "u_18_0")
    private WebElement menuItemCheckbox;

    @FindBy(how = How.NAME, using = "__submit__")
    public WebElement saveChangesBtn;

    public String employerName_loc = "//*[@name='employer_name']";
    public String startDataYear_loc = "date_start[year]";
    public String startDataMonth_loc = "date_start[month]";
    public String startDataDay_loc = "date_start[day]";
    private String filter_loc = "//*[@role='menuitemcheckbox']";

    public void enableCheckboxCurrentWork(WebDriver driver){
        try {
            WebElement isCurrentActivated = driver.findElement(By.xpath(
                    "//*[@class='uiProgressiveDatepickerRange uiProgressiveDatepickerRangeCurrent']"));
        }
        catch (Exception e){
            isCurrentCheckbox.click();
        }
    }

    public void disableCheckboxCurrentWork(WebDriver driver){
        try {
            WebElement isCurrentActivated = driver.findElement(By.xpath(
                    "//*[@class='uiProgressiveDatepickerRange']"));
        }
        catch (Exception e){
            isCurrentCheckbox.click();
        }
    }

    public void choosePublicFilter(WebDriver driver){
        menuItemCheckbox.click();
        List<WebElement> list = driver.findElements(By.xpath(filter_loc));
        for (WebElement element : list) {
            if(element.getText().equals("Public")){
                element.click();
            }
        }
    }

    public void chooseFriendsFilter(WebDriver driver){
        shareFilter.click();
        List<WebElement> list = driver.findElements(By.xpath(filter_loc));
        for (WebElement element : list) {
            if(element.getText().equals("Friends")){
                element.click();
            }
        }

    }

    public void chooseOnlyMeFilter(WebDriver driver){
        menuItemCheckbox.click();
        List<WebElement> list = driver.findElements(By.xpath(filter_loc));
        for (WebElement element : list) {
            if(element.getText().equals("Only me")){
                element.click();
            }
        }
    }

    public void saveChanges(){
        saveChangesBtn.click();
    }
}







