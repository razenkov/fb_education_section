package education_section;

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
    public void addCurrentCompanyToProfileTest() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationBar navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
        WorkEducationPage workEducationPage = PageFactory.initElements(driver, WorkEducationPage.class);

        loginPage.loginToTestAccount(driver);
        Thread.sleep(2000);

        navigationBar.getProfile();


        profilePage.getAboutSection();

        Thread.sleep(2000);

        profilePage.getWorkEducationSection();

        profilePage.getWorkSpace(driver);


        String companyName = "newCompany";

        workEducationPage.employer_name.sendKeys(companyName);
        //Thread.sleep(1000);

        List<WebElement> companyDropDown = driver.findElements(By.xpath("//*[@class='text']"));
        for (WebElement element : companyDropDown) {
            if(element.getText().equals("Create \"newCompany\"")){
                element.click();
            }
        }

        workEducationPage.position.sendKeys("newEmpoloee");
        Thread.sleep(1000);
        List<WebElement> positionDropDown = driver.findElements(By.xpath("//*[@class='text']"));
        for (WebElement element : positionDropDown) {
            if(element.getText().equals("Create \"newEmpoloee\"")){
                element.click();
            }
        }

        workEducationPage.position.sendKeys();
        Thread.sleep(3000);


        workEducationPage.city.sendKeys("Los Angeles, California");

        WebElement el = driver.findElement(By.xpath("//*[@title='Los Angeles, California']"));
        el.click();


        workEducationPage.description.sendKeys("Test public description");

        Thread.sleep(2000);

        workEducationPage.activateCheckboxCurrentWork(driver);

        Select startDataYear = new Select(driver.findElement(By.name(workEducationPage.startDataYear_loc)));
        startDataYear.selectByValue("2000");

        Select startDataMonth = new Select(driver.findElement(By.name(workEducationPage.startDataMonth_loc)));
        startDataMonth.selectByValue("3");

        Select startDataDay = new Select(driver.findElement(By.name(workEducationPage.startDataDay_loc)));
        startDataDay.selectByValue("11");

        WebElement share = driver.findElement(By.xpath("//*[@aria-label='Shared with Public']"));
        share.click();

        Thread.sleep(2000);
        List<WebElement> shareFilter = driver.findElements(By.xpath("//*[@role='menuitemcheckbox']"));
        for (WebElement element : shareFilter) {
            if(element.getText().equals("Friends")){
                element.click();
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);


        Thread.sleep(7000);
        wait.until(ExpectedConditions.elementToBeClickable(workEducationPage.saveChangesBtn));
        workEducationPage.saveChanges();

        Thread.sleep(10000);


        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fbRequestsJewelLoadingContent")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("fbRequestsJewelLoadingContent")));

        //check


        profilePage.getOverviewSection();

        Thread.sleep(2000);
        WebElement element4 = driver.findElement(By.className("profileLink"));
        Assert.assertTrue(element4.getText().equals(companyName));


    }

}
