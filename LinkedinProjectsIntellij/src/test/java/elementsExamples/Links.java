package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Links {
    static WebDriver cdriver;

    //HTTP
    static HttpURLConnection connection;
    static int responseCode;

    //Elements
    static WebElement elementsButton;
    static WebElement linksButton;
    static WebElement homeLink;
    static WebElement elementsButtonWait;
    static ExpectedCondition elementsButtonIsDisplayed;

    //Windows
    static Set<String> windows;
    static Iterator<String> window;
    static String parentId;
    static String childIdOne;

    //Links
    static List<WebElement> links;
    static String url;
    static String urlText;

    @BeforeClass
    public static void setUp(){
    cdriver = new ChromeDriver();
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
    public void test02(){
        linksButton = cdriver.findElement(By.xpath("//span[text()='Links']"));
        linksButton.click();
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
        elementsButtonWait = new WebDriverWait(cdriver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Elements']")));
        elementsButtonIsDisplayed = ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Elements']"));
        cdriver.close();
        cdriver.switchTo().window(parentId);
    }
    @Test
    public void test05(){
        links = cdriver.findElements(By.tagName("a"));
        for (int i = 4; i<links.size(); i++){
            url = links.get(i).getAttribute("href");
            urlText = links.get(i).getText();
            try{
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                responseCode = connection.getResponseCode();

                System.out.println("URL: " + url + " | " + "Returned Response Code: " + responseCode + " | " + "URL Text: " + urlText);
            }catch (IOException e){
                System.out.println("Error Checking Response Code For URL: " + url + " | " + "URL Text: " + urlText);
            }
        }
    }
}
/*
Java'da, koleksiyonlar verilerin toplu olarak saklanmasını ve yönetilmesini sağlayan nesne yapılarıdır.
Koleksiyonlar, çeşitli veri türlerini saklamak için kullanılan farklı tasarımlar içerir ve
verilere hızlı erişim, sıralama, filtreleme, arama ve çok daha fazlasını sağlar.
--------------------------------------------------------------
Set ve List sınıfları Java'da koleksiyonlar için kullanılan veri yapılarıdır. Ancak aralarında önemli farklılıklar vardır:
Eleman eşsizliği: Set sınıfı elemanların eşsiz olduğunu garantiler, yani aynı eleman birden fazla kez bulunmaz.
List sınıfı ise elemanların tekrar edebileceğini garantiler.
Sıralı olma: Set sınıfı elemanlarının sıralı olma garantisi yoktur, ancak List sınıfı elemanların belirli bir sıralama garantisi verir.
Performans: Set sınıfının eleman arama işlemleri daha hızlıdır, ancak eleman ekleme ve silme işlemleri List sınıfından daha yavaştır.
Yukarıdaki farklılıklar dikkate alınarak, Set ve List sınıflarının hangi durumda kullanılması gerektiği belirlenir.
--------------------------------------------------------------
Iterator<String> bir Java veri yapısıdır ve belirtilen bir veri kümesinde (örneğin List, Set vb.) bulunan nesneleri tanımlar ve gezmek için kullanılır.
Iterator özelliği sayesinde, bir veri kümesindeki tüm nesnelere tek tek erişilebilir ve işlenebilir.
Örneğin, bir List<String> veri kümesindeki tüm elemanlar Iterator aracılığıyla tek tek gezilebilir ve işlenebilir.
--------------------------------------------------------------
Java'da next() metodu bir iterator nesnesinde bulunan verileri sırayla dolaşmak için kullanılır.
Bu metod her çağırıldığında iterator nesnesinin içindeki sonraki elemanı döndürür.
Eğer daha fazla eleman yoksa, metod NoSuchElementException istisnası fırlatır.
--------------------------------------------------------------
Tarayıcıda bulunan tüm pencerelerin ID'leri bir "Set<String>" olarak tanımlanır ve "windows" adında bir değişkene atanır.
Bu set içerisindeki verilerin iterasyonunu yapmak için bir "Iterator<String>" tanımlanır ve "it" adında bir değişkene atanır.
Iterator ile set içerisindeki ilk pencerenin ID'si "parentId" değişkenine atanır.
Iterator ile set içerisindeki ikinci pencerenin ID'si "childId" değişkenine atanır.
Tarayıcı, "driver.switchTo().window(childId)" ile "childId" değişkeninde bulunan pencereye geçirilir.
--------------------------------------------------------------
HttpURLConnection, Java programlama dillerinde, HTTP protokolü üzerinden veri transferi yapmak için kullanılan bir API'dir.
HttpURLConnection sınıfı, URL verilerini okumak veya göndermek için HTTP protokolünü kullanır.
HttpURLConnection sınıfı, URL nesnesinin openConnection() metodu ile oluşturulur ve setRequestMethod() metodu ile istek türü
(örneğin GET veya POST) belirtilir. Son olarak, connect() metodu ile bağlantı kurulur ve getResponseCode() metodu ile dönen cevap kodu okunabilir.
--------------------------------------------------------------
Bu kod, "links" adlı WebElement listesindeki her bir link üzerinde döngü oluşturur.
Her bir döngü iterasyonunda, bir linkin URL'si "url" değişkenine atanır ve bir HTTP bağlantısı oluşturulur.
Bağlantı, "HEAD" metodu ile yapılır ve bağlantı "connect" metodu ile başlatılır.
Bağlantının yanıt kodunu "responseCode" değişkenine atanır ve konsol üzerinde ekrana "URL: [URL] returned response code: [yanıt kodu]" şeklinde yazdırılır.
Eğer bağlantı sırasında bir IOException oluşursa, konsol üzerinde "Error checking response code for URL: [URL]" şeklinde bir hata mesajı yazdırılır.
--------------------------------------------------------------
"HEAD" metodu, HTTP protokolünde kullanılan bir istek türüdür.
Bu metodun amacı, sunucudan belirtilen URL'nin üst bilgilerini (metadata) almaktır.
HEAD isteği sunucuya gönderilir ve sunucu tarafından yanıt verilir, ancak sunucunun belirtilen URL'ye ait içerik döndürmemesi beklenir.
Bu, GET isteğinden farklı olarak, sadece URL'nin üst bilgilerinin alınmasını sağlar ve sunucuya istemci tarafından veri indirilmesi için fazla yük bindirmez.
 */