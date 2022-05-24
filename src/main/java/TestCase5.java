import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase5 {
    @Test
    public void wrongPassword() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");

        WebElement clickSignIn = driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button"));
        clickSignIn.click();

        WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        inputEmail.sendKeys("nglady21@gmail.com");

        WebElement inputPass = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        inputPass.sendKeys("abcdefg123");

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        signIn.click();
        Thread.sleep(2000);

        WebElement passwordError = driver.findElement(By.xpath("//*[@id=\"aria-join_neu_password_field-error\"]"));
        String actualResult = passwordError.getText();
        String expectedResult = "Password was incorrect";
        if (actualResult.equalsIgnoreCase(expectedResult))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        driver.quit();

    }
}
