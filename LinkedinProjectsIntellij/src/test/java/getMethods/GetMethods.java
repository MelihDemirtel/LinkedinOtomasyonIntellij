package getMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args){
        WebDriver cdriver = new ChromeDriver();//Chrome Driver çalıştırılacak

        cdriver.get("https://demoqa.com");//URL kurulan browser ile açılacak

        System.out.println("Sayfa Title: "+cdriver.getTitle());//Açık sayfanın ismini verir

        System.out.println("Açık Sayfa URL'i: "+cdriver.getCurrentUrl());//Açık sayfanın url'ini verir

        System.out.println("Açık Sayfanın Hash Code'u: "+cdriver.getWindowHandle());//Açık Sayfanın Hash Code'unu verir

        System.out.println("Açık Tüm Sayfaların Hash Code'u: "+cdriver.getWindowHandles());//Açık Tüm Sayfaların Hash Code'unu  verir

        System.out.println("=================================");
        System.out.println(cdriver.getPageSource());//Sayfanın kaynak kodunu verir.
        System.out.println("=================================");

        cdriver.quit();//Browserı kapatmak için
    }
}
