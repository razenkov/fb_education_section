package education_section.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//*[@data-tab-key='about'][@class='_6-6']")
    private WebElement aboutTab;

    @FindBy(how = How.XPATH, using = "//*[@data-testid='nav_edu_work']")
    private WebElement workEducationTab;

    @FindBy(how = How.XPATH, using = "//*[@data-testid='nav_overview']")
    private WebElement overviewTab;

    private String linksToEdit_loc = "clearfix";
    private String workplace = "Add a workplace";
    private String skills = "Add a professional skill";
    private String college = "Add a college";
    private String high_school = "Add a high school";

    public void getAboutSection() {
        aboutTab.click();
    }

    public void getOverviewSection() {
        overviewTab.click();
    }

    public void getWorkEducationSection() {
        workEducationTab.click();
    }

    public void getWorkSpace(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(workplace)) {
                element.click();
            }
        }
    }

    public void getSkills(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(skills)) {
                element.click();
            }
        }
    }

    public void getCollage(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(college)) {
                element.click();
            }
        }
    }

    public void getHighSchool(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.className(linksToEdit_loc));
        for (WebElement element : links) {
            if (element.getText().equals(high_school)) {
                element.click();
            }
        }
    }

}



