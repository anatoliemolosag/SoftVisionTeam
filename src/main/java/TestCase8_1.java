import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class TestCase8_1 {
    @Test
    public void pillowKeyWord() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBar.sendKeys("pillow");

        WebElement searchClick = driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button"));
        searchClick.click();
        Thread.sleep(5000);

        List<WebElement> titlesForPillow = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[10]/div[1]/div/div/ul//h3"));

        for (int i = 0; i < titlesForPillow.size(); i++) {
            Assert.assertTrue(titlesForPillow.get(i).getText().toLowerCase().trim().contains("pillow"));
        }

        //dog case

        searchBar = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBar.clear();
        searchBar.sendKeys("dog");

        searchClick = driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button"));
        searchClick.click();
        Thread.sleep(5000);

        List<WebElement> titlesForDogs = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[10]/div[1]/div/div/ul//h3"));

        for (int i = 0; i < titlesForDogs.size(); i++) {
            Assert.assertTrue(titlesForDogs.get(i).getText().toLowerCase().trim().contains("dog"));
        }
        driver.quit();
    }
}
