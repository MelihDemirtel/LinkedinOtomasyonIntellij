package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseButtons{
    static WebDriver cdriver;
    static Actions actions;

    //Elements
    static WebElement elementsButton;
    static WebElement buttonsButtons;
    static WebElement doubleClickButton;
    static WebElement rightClickButton;
    static WebElement clickButton;

    //Strings
    static String actualDoubleClickMessage;
    static String expectedDoubleClickMessage = "You have done a double click";

    static String actualRightClickMessage;
    static String expectedRightClickMessage = "You have done a right click";

    static String actualClickMessage;
    static String expectedClickMessage = "You have done a dynamic click";

    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        actions = new Actions(cdriver);
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.get("https://demoqa.com");
    }
    @AfterClass
    public static void tearDown(){
        cdriver.quit();
    }
    @Test
    public void test01(){
        elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
    }
    @Test
    public void test02(){
        buttonsButtons = cdriver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsButtons.click();
    }
    @Test
    public void test03(){
        doubleClickButton = cdriver.findElement(By.id("doubleClickBtn"));
        actions.moveToElement(doubleClickButton).doubleClick().perform();
        actualDoubleClickMessage = cdriver.findElement(By.id("doubleClickMessage")).getText();
        System.out.println("Double Click Message: " + actualDoubleClickMessage);
        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage);
    }
    @Test
    public void test04(){
        rightClickButton = cdriver.findElement(By.id("rightClickBtn"));
        actions.moveToElement(rightClickButton).contextClick().perform();
        actualRightClickMessage = cdriver.findElement(By.id("rightClickMessage")).getText();
        System.out.println("Right Click Message: " + actualRightClickMessage);
        Assert.assertEquals(actualRightClickMessage, expectedRightClickMessage);
    }
    @Test
    public void test05(){
        clickButton = cdriver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.moveToElement(clickButton).doubleClick().perform();
        actualClickMessage = cdriver.findElement(By.id("dynamicClickMessage")).getText();
        System.out.println("Click Message: " + actualClickMessage);
        Assert.assertEquals(actualClickMessage, expectedClickMessage);
    }

}
