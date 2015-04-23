
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can add new inproceeding to the reference database'

scenario "user can go to page where new inproceeding can be added to database", {
    given 'home page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")
    }

    when 'two links have been followed from home page', {
        element = driver.findElement(By.linkText("newReference"))   
        element.click()
        element = driver.findElement(By.linkText("Inproceeding"))   
        element.click()
    }

    then 'user will see form for adding new article to database', {
        driver.getPageSource().contains("Create a New Inproceeding Reference").shouldBe true
    }
}

scenario "user can't send the form without title", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newInproceeding")
    }

    when 'user have not filled the title field in the form and clicked submit', {
        element = driver.findElement(By.name("author"))
        element.sendKeys("Vihavainen, Arto")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("2001")
        element = driver.findElement(By.name("bookTitle"))
        element.sendKeys("Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}


scenario "user can't send the form without author", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newInproceeding")
    }

    when 'user have not filled the author field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Extreme Apprenticeship Method in Teaching Programming for Beginners.")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("2001")
        element = driver.findElement(By.name("bookTitle"))
        element.sendKeys("Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send the form without year", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newInproceeding")
    }

    when 'user have not filled the year field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Extreme Apprenticeship Method in Teaching Programming for Beginners.")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Vihavainen, Arto")
        element = driver.findElement(By.name("bookTitle"))
        element.sendKeys("Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send the form without year", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newInproceeding")
    }

    when 'user have not filled the year field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Extreme Apprenticeship Method in Teaching Programming for Beginners.")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Vihavainen, Arto")
        element = driver.findElement(By.name("bookTitle"))
        element.sendKeys("Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}


scenario "user can't send the form without booktitle", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newInproceeding")
    }

    when 'user have not filled the booktitle field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Extreme Apprenticeship Method in Teaching Programming for Beginners.")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Vihavainen, Arto")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("2001")
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can fill the form and send it", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newInproceeding")
    }

    when 'user have filled all fields from the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Extreme Apprenticeship Method in Teaching Programming for Beginners.")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Vihavainen, Arto")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("2001")
        element = driver.findElement(By.name("bookTitle"))
        element.sendKeys("Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("Extreme Apprenticeship Method in Teaching Programming for Beginners.").shouldBe true
    }
}
