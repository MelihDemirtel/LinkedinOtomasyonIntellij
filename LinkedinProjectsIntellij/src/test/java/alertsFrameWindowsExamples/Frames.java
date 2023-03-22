package alertsFrameWindowsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Frames {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;

    //ELEMENTS
    static WebElement alertsFrameWindowsButton;
    static WebElement framesButton;


    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(6));
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeAllTests(){
        cdriver.get("https://demoqa.com");
        alertsFrameWindowsButton = cdriver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowsButton.click();
        framesButton = cdriver.findElement(By.xpath("//span[text()='Frames']"));
        framesButton.click();
    }
    @AfterClass
    public static void tearDown(){ cdriver.quit();
    }
    @Test
    public void test01() {

    }
    @Test
    public void test02() {

    }
    @Test
    public void test03() {

    }
    @Test
    public void test04() {

    }
}
