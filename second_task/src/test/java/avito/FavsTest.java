package avito;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FavsTest {

    public static WebDriver driver;
    public static AdPage adPage;
    public static FavsPage favsPage;

    private static final Logger log = Logger.getLogger(FavsTest.class.getName());



    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        adPage = new AdPage(driver);
        favsPage = new FavsPage(driver);
    }


    @Test
    public void test() {
        log.info("Starting test...");
        driver.get(ConfProperties.getProperty("advt"));
        adPage.clickFavBtn();
        driver.get(ConfProperties.getProperty("favs"));
        try {
            WebElement favElem = driver.findElement(By.className("item-snippet-column-2-md2mY")).findElement(By.tagName("a"));
            Assertions.assertEquals(favsPage.getFavLink(favElem), "https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363");
            Assertions.assertEquals(favsPage.getFavText(favElem), "Domain-Driven Design Distilled Vaughn Vernon");
        } catch(NoSuchElementException e) {
            log.log(Level.SEVERE, "No such element: ", e);
        }
        log.info("Test passed");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
