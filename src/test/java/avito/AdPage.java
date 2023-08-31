package avito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdPage {

    public WebDriver driver;

    public AdPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'desktop-p6xjn6')]")
    private WebElement favBtn;

    public void clickFavBtn() {
        favBtn.click();
    }
}
