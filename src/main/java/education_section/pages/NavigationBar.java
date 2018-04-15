package education_section.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBar {

    @FindBy(how = How.CLASS_NAME, using = "_1qv9")
    private WebElement profileLink;

    public void getProfile() {
        profileLink.click();
    }

}
