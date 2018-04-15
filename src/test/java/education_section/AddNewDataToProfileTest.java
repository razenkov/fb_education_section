package education_section;

import education_section.core.StaleElement;
import education_section.core.WebDriverTestBase;
import education_section.pages.LoginPage;
import education_section.pages.NavigationBar;
import education_section.pages.ProfilePage;
import education_section.pages.WorkEducationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewDataToProfileTest extends WebDriverTestBase {
    @Test
    public void addCurrentCompanyToProfileTest() {
        //Innit necessary entities
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationBar navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        WorkEducationPage workEducationPage = PageFactory.initElements(driver, WorkEducationPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        StaleElement staleElement = new StaleElement();

        //Navigation to target tab
        loginPage.loginToTestAccount(driver);
        navigationBar.getProfile();
        profilePage.getAboutSection();
        profilePage.getWorkEducationSection();
        profilePage.getWorkSpace(driver);

        //Create new company and new position
        workEducationPage.employer_name.sendKeys(profilePage.companyName);

        staleElement.refreshAndClick(driver, profilePage.createCompanyBtn_loc);
        staleElement.refreshAndClick(driver, profilePage.createCompanyBtn_loc);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profilePage.companyIsCreatedIcon_loc)));

        workEducationPage.position.sendKeys(profilePage.position);

        staleElement.refreshAndClick(driver, profilePage.createPositionBtn_loc);

        List<WebElement> positionDropDown = driver.findElements(By.xpath(profilePage.positionDropDown_loc));
        for (WebElement element : positionDropDown) {
            if(element.getText().equals(profilePage.textOnCreateBtn)){
                element.click();
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(profilePage.positionDropDownArea_loc)));

        //Set city
        workEducationPage.city.sendKeys(profilePage.city);
        WebElement city = driver.findElement(By.xpath(profilePage.city_loc));
        city.click();

        workEducationPage.description.sendKeys(profilePage.description);
        workEducationPage.enableCheckboxCurrentWork(driver);

        //Set start date of current position
        Select startDataYear = new Select(driver.findElement(By.name(workEducationPage.startDataYear_loc)));
        startDataYear.selectByValue(profilePage.year);

        Select startDataMonth = new Select(driver.findElement(By.name(workEducationPage.startDataMonth_loc)));
        startDataMonth.selectByValue(profilePage.mounth);

        Select startDataDay = new Select(driver.findElement(By.name(workEducationPage.startDataDay_loc)));
        startDataDay.selectByValue(profilePage.day);

        //Opening share filter dropdown
        staleElement.refreshAndClick(driver, profilePage.shareDrop_loc);

        //Activating "Friends" filter
        List<WebElement> shareFilter = driver.findElements(By.xpath(profilePage.shareFilterMenu));
        for (WebElement element : shareFilter) {
            if(element.getText().equals(profilePage.shareFilterMenuToChoose)){
                element.click();
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(workEducationPage.saveChangesBtn));
        workEducationPage.saveChanges();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profilePage.experienceSection_loc)));

        //Getting all elements on page with employee position name to check added position has been saved
        List<WebElement> listOfInfoTabs = driver.findElements(By.xpath("//*[@class='fsm fwn fcg']"));
        boolean addedPositionIsPresent = false;
        for (WebElement element : listOfInfoTabs) {
            if(element.getText().contains(profilePage.position)){
                addedPositionIsPresent = true;
            }
        }
        //Is added position successfully saved
        Assert.assertTrue(addedPositionIsPresent);

        profilePage.getOverviewSection();

        //New added company successfully saved and visible from other(overview) tabs of user profile
        WebElement companyNameTab = driver.findElement(By.className(profilePage.companyDescriptionFromOverviewTab_loc));
        Assert.assertTrue(companyNameTab.getText().equals(profilePage.companyName));
    }
}
