import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7_1 {

    @Test
    public void SelectAnyTime() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");


        Thread.sleep(1000);
        WebElement clothingShoes = driver.findElement(By.xpath("//span[@id=\"catnav-primary-link-10923\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clothingShoes).perform();
        actions.click(clothingShoes).perform();

        Thread.sleep(1000);
        WebElement estArrivalTimeButton = driver.findElement(By.xpath("//span[contains(text(),' Estimated Arrival ')]"));
        estArrivalTimeButton.click();

        Thread.sleep(1000);
        WebElement anyTime = driver.findElement(By.xpath("//input[@id=\"edd-any-radio-input-tf\"]"));
        Thread.sleep(1000);
        actions.click(anyTime).perform();
        Thread.sleep(2000);

        anyTime= driver.findElement(By.xpath("//input[@id=\"edd-any-radio-input-tf\"]"));

        boolean actual = anyTime.isSelected();
        boolean expected = true;

        Assert.assertEquals(actual,expected);




    }
}
