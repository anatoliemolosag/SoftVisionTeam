package Code;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase4_1 {

    @Test
    public void SortButtonLowerPrice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement jewelryAccessoriesButton = driver.findElement(By.xpath("//span[@id=\"catnav-primary-link-10855\"]"));
        jewelryAccessoriesButton.click();

        Thread.sleep(2000);
        WebElement sortButton = driver.findElement(By.xpath("//div[@id=\"sortby\"]"));
        sortButton.click();
        Thread.sleep(1000);
        WebElement lowPrice = driver.findElement(By.xpath("//a[contains(text(),'Lowest Price')]"));
        lowPrice.click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[9]/div/div/div/ul/li/div/div/a/div[2]/div/div[2]/p[1]/span[2]"));
        List<Double> actualPrices = new ArrayList<>();
        List<Double> expectedPrices = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {
            actualPrices.add(Double.parseDouble(allProducts.get(i).getText().replace("$","")));
            expectedPrices.add(Double.parseDouble(allProducts.get(i).getText().replace("$","")));
            Collections.sort(expectedPrices);

            Assert.assertEquals(actualPrices,expectedPrices);

        }
        System.out.println(actualPrices);
        System.out.println(expectedPrices);

    }

}
