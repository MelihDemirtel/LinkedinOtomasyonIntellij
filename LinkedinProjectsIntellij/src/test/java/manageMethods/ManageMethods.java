package manageMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();//Chrome Driver çalıştırılacak

        cdriver.get("https://demoqa.com");//URL kurulan browser ile açılacak

        // Açık olan sekmenin boyutunu verir. Örneğin 800x600
        System.out.println("Current Size: "+cdriver.manage().window().getSize());
        // İşlemleri rahat görebilelim diye 2 saniyelik bir bekleme ayarlayalım.
        // Farklı bekleme işlemleri var. Daha kullanışlı olanları sizlerle paylaşacağım şuan gerek yok.
        Thread.sleep(2000);

        // Açık olan sekmenin boyutunu ayarlamanızı sağlar.
        cdriver.manage().window().setSize(new Dimension(800,600));
        Thread.sleep(2000);

        // Açık olan sekmenin ekranda açıldığı konumun kordinatlarını almak için kullanılır.
        System.out.println("Current Position: "+cdriver.manage().window().getPosition());
        Thread.sleep(2000);

        // Açık olan sekmenin açılacağı konumu belirlemenizi sağlar.
        cdriver.manage().window().setPosition(new Point(200,15));
        Thread.sleep(2000);

        // Açık olan sekmenin boyutunu yazdırmak için.
        System.out.println("New Window Size : "+cdriver.manage().window().getSize());
        // Açık olan sekmenin konumunu yazdırmak için.
        System.out.println("New Position's Dimension : "+cdriver.manage().window().getPosition());
        Thread.sleep(2000);

        // Browser açıldığında tam ekran olması için.
        // Büyütüldüğünde pencerenin başlık çubuğu vb. görüntülenmeye devam eder.
        cdriver.manage().window().maximize();
        System.out.println("Maximize Window Size : "+cdriver.manage().window().getSize());
        System.out.println("Maximize Position : "+cdriver.manage().window().getPosition());
        Thread.sleep(2000);

        // Browserın tam ekran olması için.
        // Tam ekran modunda başlık çubuğu görüntülenmez. Klavyedeki F11 tuşu ile büyütme işlemidir.
        cdriver.manage().window().fullscreen();
        System.out.println("FullScreen Window Size : "+cdriver.manage().window().getSize());
        System.out.println("FullScreen Position : "+cdriver.manage().window().getPosition());
        Thread.sleep(2000);

        // Browserın minimize yani küçültülmesi taskbar'a inmesi.
        cdriver.manage().window().minimize();
        System.out.println("Minimize Window Size : "+cdriver.manage().window().getSize());
        System.out.println("Minimize Position : "+cdriver.manage().window().getPosition());
        Thread.sleep(2000);

        // 15 saniye bekleme için.
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Sayfadaki web öğelerinin bulunması için 15 saniye bekleyin. Elemanı bulursa beklemeden devam eder.
        //Öğeyi 15 saniye içinde bulamazsa bir hata atar.

        cdriver.quit();//Browserı kapatmak için
    }
}
