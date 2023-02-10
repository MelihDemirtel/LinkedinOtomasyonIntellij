package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class BrokenLinksImages {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static String url;
    static String urlText;
    static String imagesUrl;
    static String imagesUrlText;

    //ELEMENTS
    static WebElement elementsButton;
    static WebElement brokenLinksButton;
    static List<WebElement> images;
    static List<WebElement> links;

    //HTTP
    static HttpURLConnection connection;
    static int responseCodeImg;
    static int responseCodeLink;

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
        brokenLinksButton = cdriver.findElement(By.xpath("(//span[@class='text' and contains(text(),'Broken')])"));
        brokenLinksButton.click();
    }
    @Test
    public void test03() {
        images = cdriver.findElements(By.tagName("img"));
        for (int i = 2; i < images.size(); i++){
            imagesUrl = images.get(i).getAttribute("src");
            imagesUrlText = images.get(i).getText();
            try{
                connection = (HttpURLConnection) new URL(imagesUrl).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCodeImg = connection.getResponseCode();
                if (responseCodeImg == 200){
                    System.out.println("IMG IS VALID: " + imagesUrl + " | " + "Returned Response Code: " + responseCodeImg + " | " + "URL Text: " + imagesUrlText);
                }else {
                    softAssert.assertTrue(responseCodeImg > 200);
                    System.out.println("IMG IS BROKEN: " + imagesUrl + " | " + "Returned Response Code: " + responseCodeImg + " | " + "URL Text: " + imagesUrlText);
                }
            }catch (IOException e){
                System.out.println("Error Checking Response Code For URL: " + imagesUrl + " | " + "URL Text: " + imagesUrlText);
            }
        }
        softAssert.assertAll();
    }
    @Test
    public void test04() {
        links = cdriver.findElements(By.tagName("a"));
        for (int i = 2; i < links.size(); i++){
            url = links.get(i).getAttribute("href");
            urlText = links.get(i).getText();
            try{
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCodeLink = connection.getResponseCode();
                if (responseCodeLink == 301){
                    System.out.println("LINK IS VALID: " + url + " | " + "Returned Response Code: " + responseCodeLink + " | " + "URL Text: " + urlText);
                }else {
                    softAssert.assertTrue(responseCodeLink > 301);
                    System.out.println("LINK IS BROKEN: " + url + " | " + "Returned Response Code: " + responseCodeLink + " | " + "URL Text: " + urlText);
                }
            }catch (IOException e){
                System.out.println("Error Checking Response Code For URL: " + url + " | " + "URL Text: " + urlText);
            }
        }
        softAssert.assertAll();
    }

}
/*
Evet, bu Java kodu, Selenium WebDriver ve TestNG kütüphanelerini kullanarak web sayfasındaki bozuk resim ve bağlantıları tespit etmeyi amaçlar.
Kod, demoqa.com adresindeki "Elements" sekmesine gitmeyi ve "Broken Links" sekmesini tıklama işlemlerini içeren test metodları (test01 ve test02) içerir.
Test03 metodu, sayfadaki tüm resimlerin geçerli olup olmadığını denetler ve "IMG IS VALID" veya "IMG IS BROKEN" şeklinde sonuçları yazdırır.
Test04 metodu, sayfadaki tüm bağlantıların geçerli olup olmadığını denetler ve "LINK IS VALID" veya "LINK IS BROKEN" şeklinde sonuçları yazdırır.
Her iki metod da, sonuçların doğruluğunu kontrol etmek için SoftAssert nesnesi kullanır.
Her iki metod sonunda da "softAssert.assertAll();" ile tüm denetimlerin geçerli olduğu doğrulanır.

Soft Assert, test otomasyonunda bir hata oluştuğunda testin devam etmesini sağlar ve tüm hataların toplu olarak raporlandığı bir yapıdır.
Normal bir assert yapısı, bir hata oluştuğunda testin durmasına neden olur ve diğer test adımları çalışmaz.
Ancak, soft assert ile bir hata oluştuğunda, test devam eder ve hatalar bir sonraki test adımına kadar birikir.
Sonunda, tüm hatalar bir arada raporlanır ve hata raporu daha tam ve kapsamlı hale gelir.
Örneğin, Java programlama dili için JUnit kütüphanesinde, assertEquals metodu ile bir assert yapısı yapılabilir ve bir hata oluştuğunda test durur.
Ancak, JUnit içinde de mevcut olan assertAll metodu ile soft assert yapısı oluşturulabilir.
 */