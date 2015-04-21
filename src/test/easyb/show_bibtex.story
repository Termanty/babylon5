import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import ohtumini.Init;

description 'User can see added references in bibtex format'

scenario "user can go to page where bibtex is shown", {
    given 'home page', {
        Init init = new Init()
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")
    }

    when 'folow link bibtex when references added', {
        
        element = driver.findElement(By.linkText("bibtex"))   
        element.click()
    }

    then 'user will see all added references in bibtex format', {
        driver.getPageSource().contains("author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti},
                    title = {Extreme Apprenticeship Method in Teaching Programming for Beginners.},
                    year = {2011},
                    booktitle = {SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education},")
                    .shouldBe true
    }
}
