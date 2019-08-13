package ca.qc.grasset._420_pa4_ag.lab05.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class WrongPasswordTest
    extends AbstractFunctionalTest {

    public WrongPasswordTest() {

        super();
    }

    @Test
    public void test() {

        getDriver().get("https://the-internet.herokuapp.com/login");
        getDriver().findElement(By.id("username"))
            .click();
        getDriver().findElement(By.id("username"))
            .clear();
        getDriver().findElement(By.id("username"))
            .sendKeys("tomsmith");
        getDriver().findElement(By.id("password"))
            .click();
        getDriver().findElement(By.id("password"))
            .clear();
        getDriver().findElement(By.id("password"))
            .sendKeys("teste");
        getDriver().findElement(By.id("login"))
            .submit();

        validate();
    }

    @Override
    protected final void validate() {

        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualMessage = element.getText();
        Assert.assertTrue("Your password is invalid!\n×".equals(actualMessage));

    }

}
