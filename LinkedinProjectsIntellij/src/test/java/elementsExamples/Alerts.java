package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Alerts {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static WebDriverWait wait;

    //ELEMENTS
    static WebElement alertsFrameWindowsButton;
    static WebElement alertsButton;
    static WebElement alertButton;
    static WebElement timerAlertButton;
    static WebElement confirmButton;
    static WebElement promtButton;
    static WebElement confirmResult;
    static WebElement promptResult;

    //OTHER
    static String expectedAlertMessage1 = "You clicked a button";
    static String expectedAlertMessage2 = "This alert appeared after 5 seconds";
    static String expectedAlertMessage3 = "Do you confirm action?";
    static String expectedAlertMessage4 = "Please enter your name";
    static String expectedConfirmMessageOk = "You selected Ok";
    static String expectedConfirmMessageCancel = "You selected Cancel";
    static String name = "Test";
    static String expectedPromptResult = "You entered " + name;
    static String actualAlertMessage1;
    static String actualAlertMessage2;
    static String actualAlertMessage3;
    static String actualAlertMessage4;
    static String actualConfirmMessageOk;
    static String actualConfirmMessageCancel;
    static String actualPromptResult;

    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(cdriver, Duration.ofSeconds(6));
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cdriver.get("https://demoqa.com");
    }
    @AfterClass
    public static void tearDown(){ cdriver.quit();
    }
    @Test
    public void test01() {
        alertsFrameWindowsButton = cdriver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowsButton.click();
    }
    @Test
    public void test02() {
        alertsButton = cdriver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsButton.click();
    }
    @Test
    public void test03() throws InterruptedException {
        alertButton = cdriver.findElement(By.id("alertButton"));
        softAssert.assertTrue(alertButton.isDisplayed());
        Thread.sleep(1000);
        alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        actualAlertMessage1 = cdriver.switchTo().alert().getText();
        System.out.println("actualAlertMessage1: " + actualAlertMessage1);
        softAssert.assertEquals(actualAlertMessage1, expectedAlertMessage1);
        cdriver.switchTo().alert().accept();

        softAssert.assertAll();
    }
    @Test
    public void test04() {
        timerAlertButton = cdriver.findElement(By.id("timerAlertButton"));
        softAssert.assertTrue(timerAlertButton.isDisplayed());
        timerAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        actualAlertMessage2 = cdriver.switchTo().alert().getText();
        System.out.println("actualAlertMessage2: " + actualAlertMessage2);
        softAssert.assertEquals(actualAlertMessage2, expectedAlertMessage2);
        cdriver.switchTo().alert().accept();

        softAssert.assertAll();
    }
    @Test
    public void test05() {
        confirmButton = cdriver.findElement(By.id("confirmButton"));
        softAssert.assertTrue(confirmButton.isDisplayed());
        confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        actualAlertMessage3 = cdriver.switchTo().alert().getText();
        System.out.println("actualAlertMessage3: " + actualAlertMessage3);
        softAssert.assertEquals(actualAlertMessage3, expectedAlertMessage3);
        cdriver.switchTo().alert().accept();
        confirmResult = cdriver.findElement(By.id("confirmResult"));
        System.out.println("confirmResult: " + confirmResult.getText());
        actualConfirmMessageOk = confirmResult.getText();
        softAssert.assertEquals(actualConfirmMessageOk, expectedConfirmMessageOk);
        confirmButton.click();
        cdriver.switchTo().alert().dismiss();
        confirmResult = cdriver.findElement(By.id("confirmResult"));
        System.out.println("confirmResult: " + confirmResult.getText());
        actualConfirmMessageCancel = confirmResult.getText();
        softAssert.assertEquals(actualConfirmMessageCancel, expectedConfirmMessageCancel);

        softAssert.assertAll();
    }
    @Test
    public void test06() {
        promtButton = cdriver.findElement(By.id("promtButton"));
        softAssert.assertTrue(promtButton.isDisplayed());
        promtButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        actualAlertMessage4 = cdriver.switchTo().alert().getText();
        System.out.println("actualAlertMessage4: " + actualAlertMessage4);
        softAssert.assertEquals(actualAlertMessage4, expectedAlertMessage4);
        cdriver.switchTo().alert().sendKeys(name);
        cdriver.switchTo().alert().accept();
        promptResult = cdriver.findElement(By.id("promptResult"));
        System.out.println("promptResult: " + promptResult.getText());
        actualPromptResult = promptResult.getText();
        softAssert.assertEquals(actualPromptResult, expectedPromptResult);

        softAssert.assertAll();
    }
}
