package ca.qc.grasset._420_pa4_ag.lab05.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class SuccessfullLoginTest
    extends AbstractFunctionalTest {

    public SuccessfullLoginTest() {

        super();
    }

    @Test
    public void test() {

        getDriver().get("https://the-internet.herokuapp.com/login");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Login Page'])[1]/following::em[1]"))
            .click();
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Login Page'])[1]/following::em[1]"))
            .click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick |
        // xpath=(.//*[normalize-space(text()) and normalize-space(.)='Login
        // Page'])[1]/following::em[1] | ]]
        getDriver().findElement(By.id("username"))
            .click();
        getDriver().findElement(By.id("username"))
            .clear();
        getDriver().findElement(By.id("username"))
            .sendKeys("tomsmith");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='tomsmith'])[1]/following::em[1]"))
            .click();
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='tomsmith'])[1]/following::em[1]"))
            .click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick |
        // xpath=(.//*[normalize-space(text()) and
        // normalize-space(.)='tomsmith'])[1]/following::em[1] | ]]
        getDriver().findElement(By.id("password"))
            .click();
        getDriver().findElement(By.id("password"))
            .clear();
        getDriver().findElement(By.id("password"))
            .sendKeys("SuperSecretPassword!");
        getDriver().findElement(By.id("login"))
            .submit();

        validate();
    }

    @Override
    protected final void validate() {

        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualMessage = element.getText();
        Assert.assertTrue("You logged into a secure area!\n×".equals(actualMessage));

    }

}
