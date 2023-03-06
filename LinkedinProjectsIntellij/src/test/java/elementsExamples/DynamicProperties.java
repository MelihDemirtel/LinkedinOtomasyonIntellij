package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DynamicProperties {
    static WebDriver cdriver;
    static JavascriptExecutor jsx;
    static SoftAssert softAssert;

    //ELEMENTS
    static WebElement elementsButton;
    static WebElement dynamicPropertiesButton;
    static WebElement enableButton;
    static WebElement colorButton;
    static WebElement visibleButton;

    //OTHER
    static int milis = 6000;
    static String firstRandomIdAttribute;
    static String secondRandomIdAttribute;
    static Boolean enableButtonIsEnable;
    static String firstColorButtonClassAttribute;
    static String secondColorButtonClassAttribute;
    static Boolean visibleButtonIsVisible;


    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeAllTests(){
        cdriver.navigate().to("https://demoqa.com");
        elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
        jsx.executeScript("window.scrollBy(0,350)");
        dynamicPropertiesButton = cdriver.findElement(By.xpath("//span[text()='Dynamic Properties']"));
        dynamicPropertiesButton.click();
    }
    @AfterClass
    public static void tearDown(){ cdriver.quit();
    }
    @Test
    public void test01() {
        firstRandomIdAttribute = cdriver.findElement(By.xpath("//p[contains(text(),'This text has random Id')]")).getAttribute("id");
        System.out.println("firstRandomIdAttribute: " + firstRandomIdAttribute);
        cdriver.navigate().refresh();
        secondRandomIdAttribute = cdriver.findElement(By.xpath("//p[contains(text(),'This text has random Id')]")).getAttribute("id");
        System.out.println("secondRandomIdAttribute: " + secondRandomIdAttribute);
        softAssert.assertNotEquals(firstRandomIdAttribute, secondRandomIdAttribute);
        System.out.println("IDs are dynamic");
        softAssert.assertAll();
    }
    @Test
    public void test02() throws InterruptedException {
        enableButton = cdriver.findElement(By.id("enableAfter"));
        enableButtonIsEnable = enableButton.isEnabled();
        softAssert.assertFalse(enableButtonIsEnable);
        System.out.println("STATE enableButtonIsEnable: " + enableButtonIsEnable);
        while (enableButtonIsEnable != true){
            System.out.println("Enable Button Is Not Enable, Wait For 5 Seconds");
            Thread.sleep(milis);
            enableButtonIsEnable = enableButton.isEnabled();
        }
        softAssert.assertTrue(enableButtonIsEnable);
        System.out.println("Enable Button Is Active, NOW | " + enableButtonIsEnable);
        softAssert.assertAll();
    }
    @Test
    public void test03() throws InterruptedException {
        colorButton = cdriver.findElement(By.id("colorChange"));
        firstColorButtonClassAttribute = colorButton.getAttribute("class");
        System.out.println("firstColorButtonClassAttribute: " + firstColorButtonClassAttribute);
        Thread.sleep(milis);
        secondColorButtonClassAttribute = colorButton.getAttribute("class");
        System.out.println("secondColorButtonClassAttribute: " + secondColorButtonClassAttribute);
        softAssert.assertNotEquals(firstColorButtonClassAttribute, secondColorButtonClassAttribute);
        System.out.println("Button Color Changed");
        softAssert.assertAll();
    }
    @Test
    public void test04() {
        visibleButton = cdriver.findElement(By.id("visibleAfter"));
        visibleButtonIsVisible = visibleButton.isDisplayed();
        softAssert.assertTrue(visibleButtonIsVisible);
        System.out.println("Visible Button Is Visible, NOW | " + visibleButtonIsVisible);
        softAssert.assertAll();
    }
}
