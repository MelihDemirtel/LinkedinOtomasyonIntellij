package elementsExamples;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTables {
    static WebDriver cdriver;
    static int milis = 1000;
    static JavascriptExecutor jsx;
    static WebElement elementsButton;
    static WebElement webTablesButton;
    static List<WebElement> rows;
    static String expectedFirstRowsFirstColm = "Cierra";
    static String actualFirstRowsFirstColm;
    static WebElement searchBox;
    static String searchBoxInputData = "al";
    static WebElement searchButton;
    static String expectedFirstRowsFirstColmSearch = "Alden";
    static WebElement addButton;
    static WebElement firstName;
    static WebElement lastName;
    static WebElement email;
    static WebElement age;
    static WebElement salary;
    static WebElement department;
    static WebElement submitButton;
    static String firstNameLabel = "Test";
    static String lastNameLabel = "Deneme";
    static String emailLabel = "test@deneme.com";
    static String ageLabel = "20";
    static String salaryLabel = "15600";
    static String departmentLabel = "Bank";
    static List<WebElement> fifthRows;
    static boolean isEmptyFifthRow;
    static WebElement deleteFirstButton;

    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.navigate().to("https://demoqa.com");
    }
    @AfterClass
    public static void tearDown(){
        cdriver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test02() throws InterruptedException {
        webTablesButton = cdriver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test03() throws InterruptedException {
        rows = cdriver.findElements(By.className("rt-td"));
        actualFirstRowsFirstColm = rows.get(0).getText();
        System.out.println("actualFirstRowsFirstColm: " + actualFirstRowsFirstColm);
        Assert.assertEquals(actualFirstRowsFirstColm, expectedFirstRowsFirstColm);
    }
    @Test
    public void test04() throws InterruptedException {
        searchBox = cdriver.findElement(By.id("searchBox"));
        searchBox.sendKeys(searchBoxInputData);
        Thread.sleep(milis);
        rows = cdriver.findElements(By.className("rt-td"));
        actualFirstRowsFirstColm = rows.get(0).getText();
        System.out.println("actualFirstRowsFirstColm: " + actualFirstRowsFirstColm);
        Assert.assertEquals(actualFirstRowsFirstColm, expectedFirstRowsFirstColmSearch);
        searchBox.clear();
        Thread.sleep(milis);
        searchButton = cdriver.findElement(By.id("basic-addon2"));
        searchButton.click();
        cdriver.navigate().refresh();
        Thread.sleep(milis);
    }
    @Test
    public void test05() throws InterruptedException {
        addButton = cdriver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        Thread.sleep(milis);

        firstName = cdriver.findElement(By.id("firstName"));
        firstName.sendKeys(firstNameLabel);
        Thread.sleep(milis);
        lastName = cdriver.findElement(By.id("lastName"));
        lastName.sendKeys(lastNameLabel);
        Thread.sleep(milis);
        email = cdriver.findElement(By.id("userEmail"));
        email.sendKeys(emailLabel);
        Thread.sleep(milis);
        age = cdriver.findElement(By.id("age"));
        age.sendKeys(ageLabel);
        Thread.sleep(milis);
        salary = cdriver.findElement(By.id("salary"));
        salary.sendKeys(salaryLabel);
        Thread.sleep(milis);
        department = cdriver.findElement(By.id("department"));
        department.sendKeys(departmentLabel);
        Thread.sleep(milis);
        submitButton = cdriver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test06() throws InterruptedException {
        fifthRows = cdriver.findElements(By.xpath("(//div[@role='row'])[5]"));
        System.out.println("fifthRows: " + fifthRows.get(0).getText());
        isEmptyFifthRow = fifthRows.isEmpty();
        System.out.println("STATE: " + isEmptyFifthRow);//false
        if (isEmptyFifthRow){
            System.out.println("Fift Row is Empty");
        }else{
            System.out.println("Fifth Row is Full");
            Assert.assertFalse(isEmptyFifthRow);
        }
    }
    @Test
    public void test07() throws InterruptedException {
        deleteFirstButton = cdriver.findElement(By.id("delete-record-1"));
        deleteFirstButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test08() throws InterruptedException {
        rows = cdriver.findElements(By.className("rt-td"));
        actualFirstRowsFirstColm = rows.get(0).getText();
        System.out.println("actualFirstRowsFirstColm: " + actualFirstRowsFirstColm);
        Assert.assertEquals(actualFirstRowsFirstColm, expectedFirstRowsFirstColmSearch);
    }
}
