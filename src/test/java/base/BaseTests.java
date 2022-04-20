package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTests {
    public static WebDriver driver;
    public void login(String user, String pass){
        try{
            WebElement UserID = driver.findElement(By.name("uid"));
            WebElement Password = driver.findElement(By.name("password"));
            WebElement btnLogin = driver.findElement(By.name("btnLogin"));
            UserID.sendKeys(user);
            Password.sendKeys(pass);
            btnLogin.click();
            try {
                driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
                System.out.println("Login passed!");
            } catch (Exception e) {
                System.out.println("Login failed!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
//        driver.manage().window().maximize();
//        driver.manage ().window().setSize(new Dimension( 375, 812));
        System.out.println(driver.getTitle());
    }
    public void logout(){
        String alert = "";
        WebElement logoutBtn = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a"));
        logoutBtn.click();
        try{
            alert = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
        System.out.println(alert);
    }
    public static void main(String[] args) throws InterruptedException {
        BaseTests test = new BaseTests();
        String username = "mngr400826";
        String password = "qehadAr";
        test.setUp();
        test.login("mngr400826","qehadAr");//tai khoan dung
        test.logout();
        driver.quit();


    }
}
