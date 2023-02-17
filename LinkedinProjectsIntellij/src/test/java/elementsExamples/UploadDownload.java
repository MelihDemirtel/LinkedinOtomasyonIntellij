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
    static WebElement downloadButton;
    static WebElement uploadButton;
    public WebElement uploadedFilePath;

    //OTHER
    static int milis = 1000;
    public String downloadFilePath;
    static String expectedFilePath = "C:\\fakepath\\sampleFile.txt";
    static String actualFilePath;

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
        downloadButton = cdriver.findElement(By.id("downloadButton"));
        downloadButton.click();
        Thread.sleep(milis);
        downloadFilePath = "C:\\Users\\ext02d47194\\Downloads\\";
        file = new File(downloadFilePath + "sampleFile.jpeg");
        Thread.sleep(milis);
        if (file.exists()){
            softAssert.assertEquals(file.getName(), "sampleFile.jpeg");
            System.out.println("Dosya İndirme İşlemi Başarılıdır.");
            System.out.println("İndirilen Dosya Adı: " + file.getName());

        }else {
            System.out.println("Dosya İndirme İşlemi Başarısızdır.");
        }
        softAssert.assertAll();
        file.delete();
    }
    @Test
    public void test04() throws InterruptedException {
        uploadButton = cdriver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys("C:\\Users\\ext02d47194\\Downloads\\sampleFile.txt");
        Thread.sleep(milis);
        uploadedFilePath = cdriver.findElement(By.id("uploadedFilePath"));
        actualFilePath = uploadedFilePath.getText();
        System.out.println(actualFilePath);
        if (actualFilePath == expectedFilePath){
            softAssert.assertEquals(actualFilePath, expectedFilePath);
            System.out.println("Dosya Yükleme İşlemi Başarılıdır.");
        }else {
            System.out.println("Dosya Yükleme İşlemi Başarısızdır.");
        }
        softAssert.assertAll();
    }
}
/*
File sınıfı, dosya ve dizin işlemlerini gerçekleştirmek için kullanılır.
Dosya sistemi üzerinde bir dosyayı ya da dizini temsil eden bir File nesnesi oluşturulabilir.
Bu nesne üzerinden, dosya adı, boyutu, yaratılma tarihi, son değiştirilme tarihi gibi dosya özelliklerine erişilebilir.
Ayrıca dosyaları kopyalama, silme, taşıma, ad değiştirme gibi işlemler de yapılabilir.

Public olarak downloadFilePath instance değişkeni olarak tanımlanırken, Static olarak downloadFilePath static bir değişken olarak tanımlanmıştır.
Bir sınıfın her nesnesi için farklı değerler taşıyabilen değişkenlere "instance variable" veya "member variable" denir.
Her bir örnek (instance) için ayrı bellek alanında saklanan bu değişkenler, sınıf içinde tanımlanır ve nesne oluşturulduğunda kullanılabilir hale gelirler.
Instance değişkenleri, sınıf içindeki herhangi bir metotdan, constructor'dan veya block'tan erişilebilir ve değiştirilebilir.

downloadFilePath instance değişkeni, her test çağrıldığında sıfırlanır ve her testin kendi downloadFilePath değerine sahip olmasını sağlar.
Ancak, downloadFilePath static bir değişken olduğunda, testler arasında ortak bir değere sahip olur ve son testten kalma bir değerle çalışabilir.
Bu nedenle, static örnekte, bir önceki testte indirilen dosyayı sildiğinden emin olmak için file.delete() satırını eklemek gerekir.
Aksi takdirde, bu dosya hala varsa, dosya indirme işlemi başarılı olmayacaktır.
 */