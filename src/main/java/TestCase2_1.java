import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2_1 {

    @Test
    public void FatherDayIsDisplayed() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        WebElement FatherDay = driver.findElement(By.xpath("//h1[.='Father’s Day Gifts 2022']"));
        String actualResult = FatherDay.getText();
        String expectedResult = "Father’s Day Gifts 2022";

        Assert.assertEquals(actualResult, expectedResult);
    }


}
