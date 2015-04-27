import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.List;

description 'User can add his own key to a reference'

scenario "user can create a reference with a unique key ", {
    given 'User adds a reference with a unique key', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")     
        element = driver.findElement(By.name("title"))
        element.sendKeys("How to write tests");
        element = driver.findElement(By.name("author"))
        element.sendKeys("George Artin");
        element = driver.findElement(By.name("publisher"))
        element.sendKeys("ThronesPublish");
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1943");
        element = driver.findElement(By.linkText("Specify key"))
        element.click();
        element = driver.findElement(By.name("pubKey"))
        element.sendKeys("JepS56");
        element.submit();
    }

    when 'user click show bibtex', {
        element = driver.findElement(By.linkText("bibtex"))
        element.click();
               
    }

    then 'bibtex shows the user added key', {
        driver.getPageSource().contains("JepS56").shouldBe true
    }
}

scenario "user creates a reference with a same key ", {
    given 'User adds a reference with a same key', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")     
        element = driver.findElement(By.name("title"))
        element.sendKeys("Second book");
        element = driver.findElement(By.name("author"))
        element.sendKeys("Ynjevi");
        element = driver.findElement(By.name("publisher"))
        element.sendKeys("PublishUtd");
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1985");
        element = driver.findElement(By.linkText("Specify key"))
        element.click();
        element = driver.findElement(By.name("pubKey"))
        element.sendKeys("JepS56");
        element.submit();
    }

    when 'user click show bibtex', {
        element = driver.findElement(By.linkText("bibtex"))
        element.click();
               
    }

    then 'bibtex shows only one reference with the same key', {
        int size = driver.getPageSource().split("JepS56").length-1;
        size.shouldEqual 1
    }
}

