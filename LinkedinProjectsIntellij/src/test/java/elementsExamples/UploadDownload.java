package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;

public class UploadDownload {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static File file;

    //ELEMENTS
    static WebElement elementsButton;
    static WebElement upDwnButton;
    static WebElement uploadButton;
    static WebElement downloadButton;
    public WebElement uploadedFileName;

    //OTHER
    static String downloadUrl;
    public String downloadedFilePath;
    static String actualFileName;
    static String expectedFileName = "C:\\fakepath\\sampleFile.txt";


    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        softAssert = new SoftAssert();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cdriver.get("https://demoqa.com");
    }
    @AfterClass
    public static void tearDown(){ cdriver.quit();
    }

    @Test
    public void test01() {
        elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
    }
    @Test
    public void test02() {
        upDwnButton = cdriver.findElement(By.xpath("//span[text()='Upload and Download']"));
        upDwnButton.click();
    }
    @Test
    public void test03() throws InterruptedException {
        downloadUrl = cdriver.findElement(By.id("downloadButton")).getAttribute("href");
        downloadButton = cdriver.findElement(By.id("downloadButton"));
        downloadButton.click();
        Thread.sleep(1000);
        downloadedFilePath = "C:\\Users\\ext02d47194\\Downloads\\";
        file = new File(downloadedFilePath + "sampleFile.jpeg");
        Thread.sleep(1000);
        if (file.exists()) {
            softAssert.assertEquals(file.getName(), "sampleFile.jpeg");
            System.out.println("İndirilen Dosya Adı: " + file.getName());
            System.out.println("Dosya indirme işlemi başarılıdır");
        } else {
            System.out.println("Dosya indirme işlemi başarısızdır");
        }
        file.delete();
    }
    @Test
    public void test04() throws InterruptedException {
        uploadButton = cdriver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys("C:\\Users\\ext02d47194\\Downloads\\sampleFile.txt");
        Thread.sleep(1000);
        uploadedFileName = cdriver.findElement(By.id("uploadedFilePath"));
        actualFileName = uploadedFileName.getText();
        softAssert.assertEquals(actualFileName, expectedFileName);
    }
}
