
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase3_2 {
@Test
public void JewelryAccIsDisplayed () throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.etsy.com/");
	Thread.sleep(3000);
	WebElement checkDropdown = driver.findElement(By.id("//catnav-primary-link-10855"));
	Thread.sleep(3000);
	checkDropdown.isDisplayed();
	List<WebElement> allCatergories = driver.findElements(By.xpath("//span[@class='wt-text-black']"));
	List<String > names = new ArrayList<>();
	Actions actions = new Actions(driver);
	for (int i =0;i<allCatergories.size();i ++){
		names.add(allCatergories.get(i).getText());
	}
	Collections.sort(names);
	System.out.println(names);
	
}

public class TestCase3_2 {

}
