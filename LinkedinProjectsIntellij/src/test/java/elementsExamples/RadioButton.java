package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class RadioButton {

    static String expectedRadioPageMessage = "Do you like the site?";
    static String expectedYesButtonMessage = "Yes";
    static String expectedImpressiveButtonMessage = "Impressive";

    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();

        int milis = 2000;

        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.get("https://demoqa.com");

        WebElement elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
        Thread.sleep(milis);

        WebElement radioButton = cdriver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButton.click();
        Thread.sleep(milis);

        String actualRadioPageMessage = cdriver.findElement(By.cssSelector(".mb-3")).getText();

        Assert.assertEquals(actualRadioPageMessage, expectedRadioPageMessage);

        WebElement radioYesButton = cdriver.findElement(By.cssSelector("label[for='yesRadio']"));
        radioYesButton.click();
        Thread.sleep(milis);

        String actualYesButtonMessage = cdriver.findElement(By.className("text-success")).getText();

        Assert.assertEquals(actualYesButtonMessage, expectedYesButtonMessage);

        WebElement radioImpressiveButton = cdriver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        radioImpressiveButton.click();
        Thread.sleep(milis);

        String actualImpressiveButtonMessage = cdriver.findElement(By.className("text-success")).getText();

        Assert.assertEquals(actualImpressiveButtonMessage, expectedImpressiveButtonMessage);

        WebElement radioNoButton = cdriver.findElement(By.cssSelector("label[for='noRadio']"));

        boolean isClickableNoButton = radioNoButton.isEnabled();

        System.out.println("STATE: " + isClickableNoButton);

        if (isClickableNoButton){
            System.out.println("No is not clickable");
        }else{
            System.out.println("No is clickable");
            cdriver.quit();
        }

        Thread.sleep(milis);

        cdriver.quit();
    }
}
