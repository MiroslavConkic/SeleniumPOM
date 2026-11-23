package Base;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PracticePage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    public String validUsername = "student";
    public String validPassword = "Password123";
    public String invalidCredentials = "invalid";
    @BeforeClass
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://practicetestautomation.com/");

        homePage = new HomePage(driver);
        practicePage = new PracticePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }
}
