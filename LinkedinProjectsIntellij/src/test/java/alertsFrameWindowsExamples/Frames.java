package alertsFrameWindowsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    static JavascriptExecutor jsx;

    //ELEMENTS
    static WebElement alertsFrameWindowsButton;
    static WebElement framesButton;
    static WebElement frame1;
    static WebElement frame2;
    static WebElement parentWindowText;

    //OTHER
    static String actualFrame1Text;
    static String actualFrame2Text;
    static String expectedFrame1Text = "This is a sample page";
    static String expectedFrame2Text = "This is a sample page";
    static String parentWindow;

    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(2));
        jsx = (JavascriptExecutor) cdriver;
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
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        //frame1 = cdriver.findElement(By.id("frame1"));
        //softAssert.assertTrue(frame1.isDisplayed());
        //cdriver.switchTo().frame(frame1);
        actualFrame1Text = cdriver.findElement(By.id("sampleHeading")).getText();
        System.out.println("actualFrame1Text: " + actualFrame1Text);
        softAssert.assertEquals(actualFrame1Text, expectedFrame1Text);
    }
    @Test
    public void test02() throws InterruptedException {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame2")));
        parentWindow = cdriver.getWindowHandle();
        //frame2 = cdriver.findElement(By.id("frame2"));
        //softAssert.assertTrue(frame2.isDisplayed());
        //cdriver.switchTo().frame(frame2);
        Thread.sleep(1500);
        jsx.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1500);
        jsx.executeScript("window.scrollBy(100,0)");
        Thread.sleep(1500);
        actualFrame2Text = cdriver.findElement(By.id("sampleHeading")).getText();
        System.out.println("actualFrame2Text: " + actualFrame2Text);
        softAssert.assertEquals(actualFrame2Text, expectedFrame2Text);
        cdriver.switchTo().window(parentWindow);
        parentWindowText = cdriver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page There are 2 Iframes in this pag')]"));
        softAssert.assertTrue(parentWindowText.isDisplayed());
        System.out.println("parentWindowText: " + parentWindowText.getText());
    }
}
