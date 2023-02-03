package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Links {
    static WebDriver cdriver;

    //Elements
    static WebElement elementsButton;
    static WebElement linksButtons;
    static WebElement homeLink;
    static boolean elementsButtonIsDisplayed;

    //Windows
    static Set<String> windows;
    static Iterator<String> window;
    static String parentId;
    static String childIdOne;

    //Links


    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cdriver.get("https://demoqa.com");
    }
    @AfterClass
    public static void tearDown(){
        cdriver.quit();
    }

    @Test
    public void test01() {
        elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
    }
    @Test
    public void test02(){
        linksButtons = cdriver.findElement(By.xpath("//span[text()='Links']"));
        linksButtons.click();
    }
    @Test
    public void test03(){
        homeLink = cdriver.findElement(By.linkText("Home"));
        homeLink.click();
    }
    @Test
    public void test04(){
        windows = cdriver.getWindowHandles();
        window = windows.iterator();
        parentId = window.next();
        childIdOne = window.next();
        cdriver.switchTo().window(childIdOne);
        elementsButtonIsDisplayed = elementsButton.isDisplayed();
        if (elementsButtonIsDisplayed){
            Assert.assertTrue(elementsButtonIsDisplayed);
            System.out.println("You are at Home Page");
        }else{
            Assert.assertTrue(elementsButtonIsDisplayed);
            System.out.println("ERROR");
        }
        cdriver.close();
        cdriver.switchTo().window(parentId);
    }
    @Test
    public void test05(){

    }
}
