package BrowsUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class BrowserUtils {


    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);

        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available, Use text,value , or index for method name");
        }
    }

    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void switchByID(WebDriver driver, String mainId) {
        Set<String> allPageID = driver.getWindowHandles();
        for (String id : allPageID) {
            System.out.println(id);// I am expecting 2 ids but one of them will be main ID
            if (!id.equals(mainId)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allIds = driver.getWindowHandles();
        for (String id : allIds) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

}
