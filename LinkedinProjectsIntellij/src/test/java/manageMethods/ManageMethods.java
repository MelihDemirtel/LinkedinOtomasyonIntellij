package manageMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();

        cdriver.get("https://demoqa.com");

        System.out.println("Mevcut Büyüklük: " + cdriver.manage().window().getSize());
        Thread.sleep(2000);

        cdriver.manage().window().setSize(new Dimension(800, 600));
        Thread.sleep(2000);

        System.out.println("Mevcut Konum: " + cdriver.manage().window().getPosition());
        Thread.sleep(2000);

        cdriver.manage().window().setPosition(new Point(200, 15));
        Thread.sleep(2000);

        System.out.println("Yeni Büyüklük: " + cdriver.manage().window().getSize());
        System.out.println("Yeni Konum: " + cdriver.manage().window().getPosition());

        cdriver.manage().window().fullscreen();
        System.out.println("FullScreen Büyüklük: " + cdriver.manage().window().getSize());
        Thread.sleep(2000);

        cdriver.manage().window().maximize();
        System.out.println("Maximize Büyüklük: " + cdriver.manage().window().getSize());
        Thread.sleep(2000);

        cdriver.manage().window().minimize();
        System.out.println("Minimize Büyüklük: " + cdriver.manage().window().getSize());
        System.out.println("Minimize Konum: " + cdriver.manage().window().getPosition());

        cdriver.quit();

    }


}
