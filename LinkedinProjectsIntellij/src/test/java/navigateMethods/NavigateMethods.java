package navigateMethods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        int milis = 2000;
        WebDriver cdriver = new ChromeDriver();

        cdriver.get("https://demoqa.com");
        System.out.println("Anasayfa açıldı");
        Thread.sleep(milis);

        cdriver.navigate().to("https://demoqa.com/elements");
        System.out.println("Elements sayfasına gidildi");
        Thread.sleep(milis);

        cdriver.navigate().back();
        System.out.println("sayfada geri gelindi");
        Thread.sleep(milis);

        cdriver.navigate().refresh();
        System.out.println("sayfa yenilendi");
        Thread.sleep(milis);

        cdriver.navigate().forward();
        System.out.println("sayfada ileri gidildi");
        Thread.sleep(milis);

        System.out.println("sayfa kapatılıyor");
        cdriver.close();
        cdriver.quit();

    }


}
