package education_section.core;

import org.openqa.selenium.*;

public class StaleElement {
    public void refreshAndClick(WebDriver driver, String locator) {
        WebElement element = null;
        boolean isAbleToInteract = false;
        int count = 0;
        while (!isAbleToInteract && count < 10)
            try {
                element = driver.findElement(By.xpath(locator));
                isAbleToInteract = true;
                element.click();
            } catch (Exception e) {
                count++;
            }
            if(element == null){
                System.out.println("WebElement cannot be refreshed.");
            }
    }
}

