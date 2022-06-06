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

public class TestCase4_2 {

    @Test
    public void SortButtonHigherPrice() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");

        WebElement jewelryAccessories = driver.findElement(By.xpath("//span[@id=\"catnav-primary-link-10855\"]"));
        jewelryAccessories.click();

        WebElement sortButton = driver.findElement(By.xpath("//span[.='Sort by:']"));
        sortButton.click();

        WebElement higherPrice = driver.findElement(By.xpath("//a[contains(text(),'Highest Price')]"));
        higherPrice.click();

        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@id=\"content\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[9]/div/div/div/ul/li/div/div/a/div[2]/div/div[2]/p[1]/span[2]"));
        Thread.sleep(3000);
        List<Double> actualResult = new ArrayList<>();
        List<Double> expectedResult = new ArrayList<>();
        Thread.sleep(3000);

        for (int i = 0; i < allPrices.size(); i++) {

            actualResult.add(Double.parseDouble(allPrices.get(i).getText().replace("$","").replace(",","")));
            expectedResult.add(Double.parseDouble(allPrices.get(i).getText().replace("$","").replace(",","")));
            Collections.sort(expectedResult);
            Collections.reverse(expectedResult);
            Assert.assertEquals(actualResult,expectedResult);

        }

        System.out.println(actualResult);
        System.out.println(expectedResult);


    }

}
