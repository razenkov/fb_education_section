package education_section.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//*[@data-tab-key='about'][@class='_6-6']")
    private WebElement aboutTab;

    @FindBy(how = How.XPATH, using = "//*[@data-testid='nav_edu_work']")
    private WebElement workEducationTab;

    @FindBy(how = How.XPATH, using = "//*[@data-testid='nav_overview']")
    private WebElement overviewTab;

    private String linksToEdit_loc = "//*[@class='_21ok _50f5']";
    private final int numberOfLinksToWaitFor = 4;

    private String workplace = "Add a workplace";
    private String skills = "Add a professional skill";
    private String college = "Add a college";
    private String high_school = "Add a high school";

    public String companyName = "newCompany";
    public String position = "newEmploee";
    public String textOnCreateBtn = "Create \"newEmploee\"";
    public String city = "Los Angeles, California";
    public String description = "Test public description";
    public String year = "2000";
    public String mounth = "3";
    public String day = "11";
    public String shareFilterMenuToChoose = "Friends";

    public String createCompanyBtn_loc = "//*[@aria-label='Create \"newCompany\"']";
    public String createPositionBtn_loc = "//*[@aria-label='Create \"newEmploee\"']";
    public String positionDropDown_loc = "//*[@class='text']";
    public String companyIsCreatedIcon_loc = "//*[@class='photo img']";
    public String positionDropDownArea_loc = "typeahead_list_u_17_c";
    public String city_loc = "//*[@title='Los Angeles, California']";
    public String shareDrop_loc = "//*[@aria-label='Shared with Public']";
    public String allExpBlocksOnPage = "//*[@class='fsm fwn fcg']";


    public String shareFilterMenu = "//*[@role='menuitemcheckbox']";
    public String experienceSection_loc = "//*[@class='_43c8 _5f6p fbEditProfileViewExperience experience _3m4o']";
    public String companyDescriptionFromOverviewTab_loc = "profileLink";




    public void getAboutSection() {
        aboutTab.click();
    }

    public void getOverviewSection() {
        overviewTab.click();
    }

    public void getWorkEducationSection() {
        workEducationTab.click();
    }

    public void getWorkSpace(WebDriver driver) {

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.numberOfElementsToBe(By.xpath(linksToEdit_loc),numberOfLinksToWaitFor));

        List<WebElement> links = driver.findElements(By.xpath(linksToEdit_loc));

        for (WebElement element : links) {
            if (element.getText().equals(workplace)) {
                        element.click();
                    }
        }
    }

    public void getSkills(WebDriver driver) {

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.numberOfElementsToBe(By.xpath(linksToEdit_loc),numberOfLinksToWaitFor));

        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(skills)) {
                element.click();
            }
        }
    }

    public void getCollage(WebDriver driver) {

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.numberOfElementsToBe(By.xpath(linksToEdit_loc),numberOfLinksToWaitFor));

        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(college)) {
                element.click();
            }
        }
    }

    public void getHighSchool(WebDriver driver) {

        new WebDriverWait(driver, 10).until(
                ExpectedConditions.numberOfElementsToBe(By.xpath(linksToEdit_loc),numberOfLinksToWaitFor));

        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(high_school)) {
                element.click();
            }
        }
    }

}



