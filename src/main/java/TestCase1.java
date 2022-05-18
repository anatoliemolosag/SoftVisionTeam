

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
@Test

public void urlValidation(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demo.opencart.com/admin/");
    String actualUrl = driver.getCurrentUrl();
    String expectedUrl = "https://demo.opencart.com/admin/";
    Assert.assertEquals(actualUrl,expectedUrl);
    // Note : as a tester always do at least one negative scenario.
}
}
