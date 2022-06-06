
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2_2 {


    @Test
    public void FatherDayIsDisplayed() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        WebElement btn = driver.findElement(By.xpath("//a[contains(text(), ' Shop these unique finds')]"));
        BrowserUtils.scrollWithJS(driver, btn);
        String actual = BrowserUtils.getText(btn);
        String expected ="Shop these unique finds";
        Assert.assertEquals(actual,expected);
        btn.click();
        BrowserUtils.switchByTitle(driver, "Father’s Day Gifts 2022");
        WebElement newPage = driver.findElement(By.xpath("//h1[.='Father’s Day Gifts 2022']"));
        System.out.println(newPage.isDisplayed());

    }

}
