
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can add new book to the reference database'

scenario "user can go to page where new article can be added to database", {
    given 'home page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")
    }

    when 'two links have been followed from home page', {
        element = driver.findElement(By.linkText("newReference"))   
        element.click()
        element = driver.findElement(By.linkText("Book"))   
        element.click()
    }

    then 'user will see form for adding new article to database', {
        driver.getPageSource().contains("Create a New Book Reference").shouldBe true
    }
}

scenario "user can't send form without title", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")
    }

    when 'user have not filled the title field in the form and clicked submit', {
        element = driver.findElement(By.name("author"))
        element.sendKeys("J.R.R.Tolkien");
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send form without author", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")
    }

    when 'user have not filled the author field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Lord of the Rings");
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send form without year", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")
    }

    when 'user have not filled the year field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Lord of the Rings");
        element = driver.findElement(By.name("author"))
        element.sendKeys("J.R.R.Tolkien");
        element = driver.findElement(By.name("publisher"))
        element.sendKeys("WSOY");
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can't send form without publisher", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")
    }

    when 'user have not filled the c field in the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Lord of the Rings");
        element = driver.findElement(By.name("author"))
        element.sendKeys("J.R.R.Tolkien");
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1968");
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("number of references").shouldBe false
    }
}

scenario "user can fill the form and send it", {
    given 'the form page', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references/newBook")
    }

    when 'user have filled all fields from the form and clicked submit', {
        element = driver.findElement(By.name("title"))
        element.sendKeys("Lord of the Rings");
        element = driver.findElement(By.name("author"))
        element.sendKeys("J.R.R.Tolkien");
        element = driver.findElement(By.name("publisher"))
        element.sendKeys("WSOY");
        element = driver.findElement(By.name("pubYear"))
        element.sendKeys("1968");
        element.submit()
    }

    then 'user finds new reference from home page listing', {
        driver.getPageSource().contains("Lord of the Rings").shouldBe true
    }
}
