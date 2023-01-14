package getMethods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args){
        WebDriver cdriver = new ChromeDriver();

        cdriver.get("https://demoqa.com");

        System.out.println("Mevcut Pencere URL: " + cdriver.getCurrentUrl());

        System.out.println("Hash Code: " + cdriver.getWindowHandle());

        System.out.println("Sayfa Başlık: " + cdriver.getTitle());

        System.out.println("-------------------PAGE SOURCE-------------------");
        System.out.println(cdriver.getPageSource());
    }

}
