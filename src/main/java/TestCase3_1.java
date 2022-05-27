
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3_1 {
@Test
public void jewelryAisDropdownMenu (){
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.etsy.com/");
	String actual = driver.getCurrentUrl();
	String expected = "https://www.etsy.com/";
	
	WebElement checkJewelryAccessory = driver.findElement(By.id("catnav-primary-link-10855"));
	checkJewelryAccessory.isDisplayed();
	Assert.assertEquals(actual,expected);
	//System.out.println("Just testing");
	
}


public class TestCase3_1 {

}
