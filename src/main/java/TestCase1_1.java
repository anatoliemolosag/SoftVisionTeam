import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1_1 {
    @Test
    public void signIn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button"));
        signIn.click();

        Thread.sleep(5000);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        email.sendKeys("nglady21@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        password.sendKeys("abcdefg12345");

        WebElement signInClick = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        signInClick.click();

        Thread.sleep(10000);

        WebElement welcomeText = driver.findElement(By.tagName("h1"));
        System.out.println(welcomeText.getText());
        Assert.assertTrue(welcomeText.getText().contains("Welcome to Etsy, nazar!"));
        driver.quit();
    }
}
