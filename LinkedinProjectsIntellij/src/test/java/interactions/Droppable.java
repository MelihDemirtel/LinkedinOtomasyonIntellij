package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Droppable {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static JavascriptExecutor jsx;
    static Actions actions;

    //ELEMENTS
    static WebElement interactionsButton;
    static WebElement droppableButton;
    static WebElement draggable;
    static WebElement droppable;

    //OTHERS
    static String actualMessage;
    static String expectedMessage = "Dropped!";


    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        jsx = (JavascriptExecutor) cdriver;
        actions = new Actions(cdriver);
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeAllTests(){
        cdriver.get("https://demoqa.com");
        interactionsButton = cdriver.findElement(By.xpath("//h5[text()='Interactions']"));
        interactionsButton.click();
        jsx.executeScript("window.scrollBy(0,300)");
        droppableButton = cdriver.findElement(By.xpath("//span[text()='Droppable']"));
        droppableButton.click();
    }
    @AfterClass
    public static void tearDown(){ cdriver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        draggable = cdriver.findElement(By.id("draggable"));
        droppable = cdriver.findElement(By.id("droppable"));
        actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().build().perform();
        Thread.sleep(1000);
        actualMessage = droppable.getText();
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();

        /*
        actions nesnesi, bir dizi farklı kullanıcı etkileşimi eylemi gerçekleştirmek için kullanılan bir Sürükle ve Bırak işlemi için bir yardımcıdır.

        moveToElement(draggable) yöntemi, sürükleme işleminin başlangıç noktasını belirlemek için "draggable" adlı öğeyi tıklar ve tutar.

        clickAndHold() yöntemi, "draggable" öğesini tıklayarak onu tutar.

        moveToElement(droppable) yöntemi, bırakma işleminin hedef noktasını belirlemek için "droppable" adlı öğeye taşır.

        release() yöntemi, "draggable" öğesini "droppable" öğesinin üzerine bırakarak sürükleme işlemini tamamlar.

        build() yöntemi, önceki adımları bir araya getirerek bir işlem zinciri oluşturur.

        perform() yöntemi, işlem zincirini gerçekleştirir ve sürükleme işlemini tamamlar.
         */
    }
}
