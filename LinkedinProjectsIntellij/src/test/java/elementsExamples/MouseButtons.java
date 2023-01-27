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
    static int milis = 1500;
    static WebDriver cdriver;
    static Actions actions;
    static WebElement elementsButton;
    static WebElement buttonsButtons;

    static WebElement doubleClickButton;
    static String expectedDoubleClickMessage = "You have done a double click";
    static String actualDoubleClickMessage;

    static WebElement rightClickButton;
    static String expectedRightClickMessage = "You have done a right click";
    static String actualRightClickMessage;

    static WebElement clickButton;
    static String expectedClickMessage = "You have done a dynamic click";
    static String actualClickMessage;


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
   //Testleri alfabetik sırayla koşuyor. Bu nedenle test1, test2 yerine farklı bir şey yazarsanız sıra bozuluyor.
   @Test
    public void test01() throws InterruptedException {
       elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
       elementsButton.click();
       //Thread.sleep(milis);
   }
    @Test
    public void test02() throws InterruptedException {
       buttonsButtons = cdriver.findElement(By.xpath("//span[text()='Buttons']"));
       buttonsButtons.click();
       //Thread.sleep(milis);
    }
    @Test
    public void test03() throws InterruptedException {
        doubleClickButton = cdriver.findElement(By.id("doubleClickBtn"));
        actions.moveToElement(doubleClickButton).doubleClick().perform();
        //Thread.sleep(milis);
        actualDoubleClickMessage = cdriver.findElement(By.id("doubleClickMessage")).getText();
        System.out.println(actualDoubleClickMessage);
        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage);
    }
    @Test
    public void test04() throws InterruptedException {
        rightClickButton = cdriver.findElement(By.id("rightClickBtn"));
        actions.moveToElement(rightClickButton).contextClick().perform();
        //Thread.sleep(milis);
        actualRightClickMessage = cdriver.findElement(By.id("rightClickMessage")).getText();
        System.out.println(actualRightClickMessage);
        Assert.assertEquals(actualRightClickMessage, expectedRightClickMessage);
    }
    @Test
    public void test05() throws InterruptedException {
        clickButton = cdriver.findElement(By.xpath("//button[text()='Click Me']"));
        clickButton.click();
        //Thread.sleep(milis);
        actualClickMessage = cdriver.findElement(By.id("dynamicClickMessage")).getText();
        System.out.println(actualClickMessage);
        Assert.assertEquals(actualClickMessage, expectedClickMessage);
    }
}
