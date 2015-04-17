
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can log in with valid username/password-combination'

scenario "user can login with correct password", {
    given 'login selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8080/references")
    }

    when 'a valid username and password are given', {
        element = driver.findElement(By.linkText("newReference"));   
        element.click();
    }

    then 'user will be logged in to system', {
        driver.getPageSource().contains("Choose Reference Type to create").shouldBe true
    }
}

scenario "user can not login with incorrect password", {
    given 'command login selected'
    when 'a valid username and incorrect password are given'
    then 'user will not be logged in to system'
}

scenario "nonexistent user can not login to system", {
    given 'command login selected'
    when 'a nonexistent username and some password are given'
    then 'user will not be logged in to system'
}