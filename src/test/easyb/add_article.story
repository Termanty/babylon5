import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can add new article to the reference database'

scenario "user can go to page where new article can be added to database", {
    given 'home page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")
    }

    when 'two links have been followed from home page', {
        element = driver.findElement(By.linkText("newReference"))   
        element.click()
        element = driver.findElement(By.linkText("Article"))   
        element.click()
    }

    then 'user will see form for adding new article to database', {
        driver.getPageSource().contains("Create a New Article Reference").shouldBe true
    }
}

scenario "user can't send the form without title", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newArticle")
    }

    when 'user have not filled the title field in the form and clicked submit', {
        element = driver.findElement(By.name("author"))
        element.sendKeys("Allan Collins")
        element = driver.findElement(By.name("journal"))
        element.sendKeys("American Educator")
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can not send the form without author", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newArticle")
    }

    when 'user have not filled the author field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Cognitive apprenticeship")
       element = driver.findElement(By.name("journal"))
        element.sendKeys("American Educator")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1991")
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send the form without journal", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newArticle")
    }

    when 'user have not filled journal field in the form part and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Cognitive apprenticeship")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Allan Collins")
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send the form without year", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newArticle")
    }

    when 'user have not filled year field in the form part and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Cognitive apprenticeship")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Allan Collins")
        element = driver.findElement(By.name("journal"))
        element.sendKeys("American Educator")
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send the form without volume", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newArticle")
    }

    when 'user have not filled volume field in the form part and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Cognitive apprenticeship")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Allan Collins")
        element = driver.findElement(By.name("journal"))
        element.sendKeys("American Educator")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1991")
        element.submit()
    }

    then 'user is not passed to home page', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can fill the form and send it", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newArticle")
    }

    when 'user have filled all fields from the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Cognitive apprenticeship")
        element = driver.findElement(By.name("author"))
        element.sendKeys("Allan Collins")
        element = driver.findElement(By.name("journal"))
        element.sendKeys("American Educator")
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1991")
        element = driver.findElement(By.name("volume"))
        element.sendKeys("6")
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("Allan Collins").shouldBe true
    }
}
