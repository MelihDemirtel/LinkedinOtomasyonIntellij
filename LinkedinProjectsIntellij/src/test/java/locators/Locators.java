package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

         /*
    KODU ÇALIŞTIRIRSANIZ HATA İLE KARŞILAŞABİLİRSİNİZ.
    AŞAĞIDAKİLER ÖRNEK AMAÇLI YAPILMIŞTIR.
     */

        WebDriver cdriver = new ChromeDriver();//Chrome driver çalıştırmak için
        int milis = 2000;//2 saniye bekleme süresi

        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;//Sayfada scroll yapabilmek için yazdık

        // Browser açıldığında tam ekran olması için.
        cdriver.manage().window().maximize();

        cdriver.get("https://demoqa.com/login");
        Thread.sleep(milis);//Bekleme adımı için gerekli. İşlemleri gözlemleyebilmek için.

        jsx.executeScript("window.scrollBy(0,250)","");//Sayfa aşağı kaydırılır

        //ID
        cdriver.findElement(By.id("userName"));//ID ile locator tanımlama -> "name of ID's attribute value"

        //CLASS NAME
        //cdriver.findElement(By.className("mr-sm-2 form-control"));//CLASS NAME ile locator tanımlama -> "name of CLASSNAME's attribute value"

        //NAME
        //cdriver.findElement(By.name(""));//NAME ile locator tanımlama -> "name of NAME's attribute value" //Sayfada name tipinde bir locator olmadığından örnek vermedim

        //TAG NAME
        cdriver.findElement(By.tagName("input"));//TAG NAME ile locator tanımlama -> "name of TAGNAME's attribute value"

        //LINK TEXT
        //cdriver.findElement(By.linkText("https://www.demoqa.com"));//LINK TEXT ile locator tanımlama -> href içerisinde yazan link adresi verilir

        //PARTIAL LINK TEXT
        //cdriver.findElement(By.partialLinkText("demoqa.com"));//PARTIAL LINK TEXT ile locator tanımlama -> href içerisinde yazan link adresinin bir kısmı verilir. Parça benzersiz olmalı

        //CSS Selectors
        cdriver.findElement(By.cssSelector("input[placeholder='UserName']"));//CSS ile locator tanımlama -> "tagname[attribute='attribute value']"
        cdriver.findElement(By.cssSelector("#userName"));//CSS ile locator tanımlama -> "#id attribute value"
        cdriver.findElement(By.cssSelector(".mr-sm-2.form-control"));//CSS ile locator tanımlama -> ".className" //Arada boşluk varsa boşluk yerine nokta koyulur

        //XPATH
        cdriver.findElement(By.xpath("//input[@id='userName']"));//XPATH ile locator tanımlama ->  //tagName[@attribute='attribute value']"));
        cdriver.findElement(By.xpath("(//input[@id='userName'])[1]"));//XPATH ile locator tanımlama ->  //tagName[@attribute='attribute value'][index value]"));
        cdriver.findElement(By.xpath("//h5[text()='Login in Book Store']"));//XPATH ile locator tanımlama ->  //tagName[text()='any text']"));
        cdriver.findElement(By.xpath("//h5[contains(text(),'Book Store')]"));//XPATH ile locator tanımlama ->  //tagName[contains(text(),'any text part')]"));

    }
}
