package elementsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TextBox {
    static String expectedValidationText = "Please select an item from left to start practice.";
    static String fullName = "Test";
    static String email = "deneme@test.com";
    static String currentAddress = "Test mahallesi";
    static String permanentAddress = "Deneme Test";

    public static void main(String[] args) throws InterruptedException {
        WebDriver cdriver = new ChromeDriver();//Chrome Driver çalıştırılacak
        int milis = 2000;
        cdriver.manage().window().maximize();
        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.navigate().to("https://demoqa.com");//URL kurulan browser ile açılacak
        jsx.executeScript("window.scrollBy(0,350)");
        Thread.sleep(milis);

        WebElement elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
        Thread.sleep(milis);

        String actualValidationText = cdriver.findElement(By.cssSelector(".col-12.mt-4.col-md-6")).getText();
        //String actualValidationText = cdriver.findElement(By.xpath("//div[contains(text(),'Please')]")).getText();
        Assert.assertEquals(actualValidationText, expectedValidationText);
        Thread.sleep(milis);

        WebElement textBoxButton = cdriver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxButton.click();
        Thread.sleep(milis);

        WebElement fullNameLabel = cdriver.findElement(By.id("userName"));
        WebElement emailLabel = cdriver.findElement(By.id("userEmail"));
        WebElement currentAddressLabel = cdriver.findElement(By.id("currentAddress"));
        WebElement permanentAddressLabel = cdriver.findElement(By.id("permanentAddress"));
        WebElement submitButton = cdriver.findElement(By.id("submit"));

        fullNameLabel.sendKeys(fullName);
        Thread.sleep(milis);
        emailLabel.sendKeys(email);
        Thread.sleep(milis);
        currentAddressLabel.sendKeys(currentAddress);
        Thread.sleep(milis);
        permanentAddressLabel.sendKeys(permanentAddress);
        Thread.sleep(milis);
        submitButton.click();
        Thread.sleep(milis);
        jsx.executeScript("window.scrollBy(0,350)");
        Thread.sleep(milis);

        String actualName = cdriver.findElement(By.id("name")).getText();
        String actualEmail = cdriver.findElement(By.id("email")).getText();
        String actualCurrentAddress = cdriver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String actualPermanentAddress = cdriver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

        Assert.assertEquals(actualName, "Name:"+fullName);
        Assert.assertEquals(actualEmail, "Email:"+email);
        Assert.assertEquals(actualCurrentAddress, "Current Address :"+currentAddress);
        Assert.assertEquals(actualPermanentAddress, "Permananet Address :"+permanentAddress);

        System.out.println(actualName);
        System.out.println(actualEmail);
        System.out.println(actualCurrentAddress);
        System.out.println(actualPermanentAddress);

        cdriver.navigate().refresh();

        cdriver.quit();

    }
}

