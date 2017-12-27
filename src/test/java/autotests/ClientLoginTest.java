package autotests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ClientLoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D://MyPrograms//Bank//BankingManagement//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/web/login.jsp");
    }
    @Test
    public void clientLogin() {
        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("alex");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("77777");
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(.,'Войти в личный кабинет')]"));
        loginButton.click();
    }
}