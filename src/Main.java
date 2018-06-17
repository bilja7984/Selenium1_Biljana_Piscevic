
import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //opens windov in full screen
        driver.get("http://bvtest.school.cubes.rs/login");
        
        //LOGIN
        
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        //CATEGORISES
        
        //go to categories page
        
        WebElement categoriesLink = driver.findElement(By.partialLinkText("Cat"));
        categoriesLink.click();
        System.out.println("Page title is: " + driver.getTitle());
        
        //Click on "Add category" button, Fill the field, and click on "Save" button
        
        WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
        addCategoryButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(Helper.getRandomText());
        
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        
         //REGIONES
        
        WebElement navBar = driver.findElement(By.className("navbar-nav"));
        List<WebElement> liTags = navBar.findElements(By.tagName("li"));
        liTags.get(3).click();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addRegionButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addRegionButton.click();
        
        WebElement titleRegionField = driver.findElement(By.id("title"));
        titleRegionField.sendKeys(Helper.getRandomText());
        
        WebElement saveRegionButton = driver.findElement(By.id("save-region-button"));
        saveRegionButton.click();
        
        //PORTALS
     
        driver.findElement(By.className("navbar-nav")).findElements(By.tagName("li")).get(4).click();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        WebElement addPortalButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addPortalButton.click();
        
        WebElement titlePortalField = driver.findElement(By.id("title"));
        titlePortalField.sendKeys(Helper.getRandomText());
        
        WebElement urlPortalField = driver.findElement(By.id("url"));
        urlPortalField.sendKeys("http://test.rs");
        
        WebElement savePortalButton = driver.findElement(By.id("save-portal-button"));
        savePortalButton.click();
        
        //CLOSING WEBDRIVER
        Thread.sleep(7000);
        driver.quit();
        
       
    }
    
}
