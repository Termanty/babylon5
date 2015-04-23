import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can delete reference from database'

scenario "user can go to home page ", {
    given 'home page and list of references', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")
        base = driver.findElement(By.id("numOfReferences"))
        driver.get("http://localhost:8080/references/newBook")     
        element = driver.findElement(By.name("title"))
        element.sendKeys("Viisikko ja ilkeä täti");
        element = driver.findElement(By.name("author"))
        element.sendKeys("Akka Kebnekaise");
        element = driver.findElement(By.name("publisher"))
        element.sendKeys("UudetJulkaisut");
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1955");
        element.submit();
    }

    when 'user click delete link for reference', {
        element = driver.findElement(By.linkText("delete"))   
        element.click();
               
    }

    then 'the number of references is correct', {
        driver.getPageSource().contains("Number of references: 4").shouldBe true
    }
}
