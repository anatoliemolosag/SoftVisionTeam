import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1_2 {
    @Test
    public void errorMSG() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button"));
        signIn.click();

        Thread.sleep(5000);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        email.sendKeys("nglady@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        password.sendKeys("abcdefg12345");

        WebElement signInClick = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        signInClick.click();

        Thread.sleep(1000);

        WebElement error1 = driver.findElement(By.xpath("//*[@id=\"aria-join_neu_email_field-error\"]"));
        Assert.assertTrue(error1.getText().contains("Email address is invalid."));

        Thread.sleep(3000);
        //password check
        email = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        email.clear();
        email.sendKeys("nglady21@gmail.com");

        password = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        password.clear();
        password.sendKeys("abcdefg123");

        signInClick = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        signInClick.click();

        Thread.sleep(1000);

        WebElement error2 = driver.findElement(By.xpath("//*[@id=\"aria-join_neu_password_field-error\"]"));
        Assert.assertTrue(error2.getText().contains("Password was incorrect"));

        driver.quit();


    }
}
