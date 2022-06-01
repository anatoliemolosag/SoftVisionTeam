import BrowsUtils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5_1 {
    @Test
    public void languageSet() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        Thread.sleep(3000);
        WebElement changeButton= driver.findElement(By.xpath("//span[@class='wt-display-inline-block wt-vertical-align-middle']"));
        BrowserUtils.scrollWithJS(driver,changeButton);
        Thread.sleep(500);
        changeButton.click();
        WebElement selectLanguage= driver.findElement(By.id("locale-overlay-select-language_code"));
        Thread.sleep(500);
        BrowserUtils.selectBy(selectLanguage,"it","value");
        Thread.sleep(500);
        Select select= new Select(selectLanguage);
        WebElement option= select.getFirstSelectedOption();
        String actualOption = option.getText().trim();
        String expectedOption = "Italiano";
        Assert.assertEquals(actualOption, expectedOption);
        System.out.println(actualOption);
        System.out.println(expectedOption);

    }

}
