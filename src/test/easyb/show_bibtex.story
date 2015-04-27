import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import ohtumini.Init;

description 'User can see added references in bibtex format'

scenario "user can go to page where bibtex is shown", {
    given 'home page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")

        element = driver.findElement(By.linkText("newReference"))   
        element.click()
        element = driver.findElement(By.linkText("Book"))   
        element.click()
    
        element = driver.findElement(By.name("title"))
        element.sendKeys("Lord of the Rings");
        element = driver.findElement(By.name("author"))
        element.sendKeys("J.R.R.Tolkien");
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1968");
        element = driver.findElement(By.name("publisher"))
        element.sendKeys("WSOY");
        element.submit()
    }

    when 'follow link bibtex when references added', {
        element = driver.findElement(By.linkText("bibtex"))   
        element.click()
    }

    then 'user will see all added references in bibtex format', {
        driver.getPageSource().contains("title = {Lord of the Rings}").shouldBe true
        driver.getPageSource().contains("author = {J.R.R.Tolkien}").shouldBe true
        driver.getPageSource().contains("publisher = {WSOY}").shouldBe true
        driver.getPageSource().contains("pubyear = {1968}").shouldBe true
    }
}

