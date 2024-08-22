import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GalvinusWebsiteDemo {

        public static WebDriver mDriver;


        @BeforeClass
        void initializers(){
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            mDriver = new ChromeDriver();
            mDriver.get("https://galvinus.com/");
            mDriver.manage().window().maximize();

        }

        @Test(priority = 1)
        void whatWeDoOption() throws InterruptedException {
            WebElement whatWeDoDropDown = mDriver.findElement(By.xpath("//*[@id=\"menu-item-12230\"]/a"));
            Actions actions = new Actions(mDriver);
            actions.moveToElement(whatWeDoDropDown).perform();
            whatWeDoDropDown.click();
            Thread.sleep(3000);
        }

        @Test(priority = 2)
        void systemTesting() throws InterruptedException {
            mDriver.findElement(By.xpath("//*[@id=\"menu-item-12230\"]/div/div/div[1]/div/div[3]/div[2]/div[2]/div/ul/li/a/span")).click();
            Thread.sleep(3000);
        }

        @Test(priority = 3)
        void titleOfThePage() throws InterruptedException {
            System.out.println(mDriver.getTitle());
            Thread.sleep(3000);
        }

        @Test(priority = 4)
        void enterDetails() throws InterruptedException {

            mDriver.findElement(By.id("form-field-name")).sendKeys("Bhaskar");
            mDriver.findElement(By.id("form-field-email")).sendKeys("basubhaskar14@gmail.com");
            // mDriver.findElement(By.xpath("//*[@id=\"form-field-field_\"]")).sendKeys("Galvinus");
            mDriver.findElement(By.xpath("//*[@id=\"form-field-field_d72975f\"]")).sendKeys("Galvinus");
            WebElement selectCountry = mDriver.findElement(By.xpath("//*[@id=\"form-field-field_73a7a64\"]"));
            Select select = new Select(selectCountry);
            select.selectByValue("India");
            mDriver.findElement(By.xpath("//*[@id=\"form-field-field_fb170dd\"]")).sendKeys("123456789");
            Thread.sleep(3000);

        }

        @Test(priority = 5)
        void clickOnLogo() {

            mDriver.findElement(By.xpath("//*[@id=\"Objects\"]")).click();
        }

        @AfterClass
        void closeTheBrowser(){
            mDriver.quit();
        }
    }

