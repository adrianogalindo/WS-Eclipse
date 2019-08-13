package ca.qc.grasset._420_pa4_ag.lab05.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class SuccessfullLogoutTest
    extends AbstractFunctionalTest {

    public SuccessfullLogoutTest() {

        super();
    }

    @Test
    public void test() {

        getDriver().get("https://the-internet.herokuapp.com/login");
        getDriver().findElement(By.xpath("//body"))
            .click();
        getDriver().findElement(By.id("username"))
            .click();
        getDriver().findElement(By.id("username"))
            .clear();
        getDriver().findElement(By.id("username"))
            .sendKeys("tomsmith");
        getDriver().findElement(By.id("password"))
            .clear();
        getDriver().findElement(By.id("password"))
            .sendKeys("SuperSecretPassword!");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::button[1]"))
            .click();
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='Welcome to the Secure Area. When you are done click logout below.'])[1]/following::i[1]"))
            .click();

        validate();
    }

    @Override
    protected final void validate() {

        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"flash\"]"));
        String actualMessage = element.getText();
        Assert.assertTrue("You logged out of the secure area!\n×".equals(actualMessage));

    }

}
