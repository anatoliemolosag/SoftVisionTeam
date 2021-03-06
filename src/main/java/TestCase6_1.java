import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6_1 {

    @Test
    public void Validation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.etsy.com/");

        WebElement clickCartButton=driver.findElement(By.xpath("//a[@aria-label='Cart']"));
        clickCartButton.click();

        WebElement headerOfCart=driver.findElement(By.xpath("//h1[contains(text(),'Your cart is empty.')]"));
        String actualHeader=headerOfCart.getText().trim();
        String expectedHeader="Your cart is empty.";
        Assert.assertEquals(actualHeader,expectedHeader);




    }
}
