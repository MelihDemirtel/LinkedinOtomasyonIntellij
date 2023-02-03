package elementsExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Links {
    static WebDriver cdriver;
}
    @BeforeClass
    public static void setUp(){
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.get("https://demoqa.com");
    }
    @AfterClass
    public static void tearDown(){
        cdriver.quit();
    }

    @Test
    public void test01() {

    }
}
