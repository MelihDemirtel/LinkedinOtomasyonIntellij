package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {
    static String  expectedHomeResult = "home";
    static String actualFirstIndexHome;
    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();
        int milis = 1000;
        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        cdriver.get("https://demoqa.com");

        WebElement elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
        Thread.sleep(milis);

        WebElement checkBoxButton = cdriver.findElement(By.xpath("//span[text()='Check Box']"));
        checkBoxButton.click();
        Thread.sleep(milis);

        WebElement checkBoxHome = cdriver.findElement(By.className("rct-title"));

        boolean isSelectedHome = checkBoxHome.isSelected();
        if(isSelectedHome){
            System.out.println("CheckBox is already selected");
        }else {
            checkBoxHome.click();
            System.out.println("CheckBox is selected now");
        }
        Thread.sleep(milis);

        List<WebElement> resultHome = cdriver.findElements(By.className("text-success"));

        for (WebElement result : resultHome){
            System.out.println(result.getText());
        }
        actualFirstIndexHome = resultHome.get(0).getText();
        Assert.assertEquals(actualFirstIndexHome, expectedHomeResult);

        WebElement toggleButton1 = cdriver.findElement(By.xpath("//button[@title='Toggle']"));

        toggleButton1.click();
        Thread.sleep(milis);

        WebElement checkBoxDesktop = cdriver.findElement(By.xpath("//span[contains(text(),'Desktop')]"));
        WebElement checkBoxDocuments= cdriver.findElement(By.xpath("//span[contains(text(),'Documents')]"));
        WebElement checkBoxDownloads = cdriver.findElement(By.xpath("//span[contains(text(),'Downloads')]"));

        Assert.assertTrue(checkBoxDesktop.isDisplayed());
        Assert.assertTrue(checkBoxDocuments.isDisplayed());
        Assert.assertTrue(checkBoxDownloads.isDisplayed());

        checkBoxHome.click();
        Thread.sleep(milis);

        checkBoxDesktop.click();
        Thread.sleep(milis);

        if(isSelectedHome){
            System.out.println("CheckBox is already selected");
        }else{
            System.out.println("CheckBox is NOT selected");
        }

        cdriver.quit();
    }

}
