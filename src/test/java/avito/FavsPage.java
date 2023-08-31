package avito;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FavsPage {

    public WebDriver driver;

    public FavsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = WebDriverManager.chromedriver().create();

    }

    public String getFavLink(WebElement webElement) {
        return webElement.getAttribute("href");
    }

    public String getFavText(WebElement webElement) {
        return webElement.getText();
    }


}
