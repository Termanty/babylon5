package ohtumini.seleniumtests;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ClickIntegrationTest {
     
    private WebDriver driver;
    
    @Before
    public void setUp() {
        this.driver = new HtmlUnitDriver();
    }
    
    
    @Test
    public void resourcesPageLinksWorkTest() {
        driver.get("http://localhost:8080/references");
        System.out.println(driver.getPageSource());
        
        WebElement element = driver.findElement(By.linkText("newReference"));   
        element.click();
        Assert.assertTrue(driver.getPageSource().contains("Choose Reference Type to create"));
    }
}