package navigateMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();//Chrome driver çalıştırmak için
        int milis = 2000;//2 saniye bekleme süresi

        cdriver.get("https://demoqa.com");
        Thread.sleep(milis);//Bekleme adımı için gerekli. İşlemleri gözlemleyebilmek için.

        cdriver.navigate().to("https://www.google.com");//driver.get metotundan farkı bu şekilde verirseniz sayfada ileri geri yapabilirsiniz.
        Thread.sleep(milis);

        cdriver.navigate().back();//Bir önceki sayfaya döner
        Thread.sleep(milis);

        cdriver.navigate().forward();//Bir sonraki sayfaya gider
        Thread.sleep(milis);

        cdriver.navigate().refresh();//Sayfayı yeniler
        Thread.sleep(milis);

        cdriver.close();//driver.quit farkı quit tüm pencereleri kapatır close açık olan sekmeyi kapatır
    }
}
