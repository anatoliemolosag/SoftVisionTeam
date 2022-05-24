import BrowsUtils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7_2 {

    @Test
    public void CustonDateSelect() throws InterruptedException {

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
        WebElement customDateBox = driver.findElement(By.xpath("//select[@id=\"edd_select_tf\"]"));
        Select select = new Select(customDateBox);
        select.selectByValue("6");
        Thread.sleep(3000);
        customDateBox = driver.findElement(By.xpath("//input[@id=\"edd-custom-radio-input-tf\"]"));

        boolean isSelected = customDateBox.isSelected();

        Assert.assertEquals(isSelected,true);









    }
}
