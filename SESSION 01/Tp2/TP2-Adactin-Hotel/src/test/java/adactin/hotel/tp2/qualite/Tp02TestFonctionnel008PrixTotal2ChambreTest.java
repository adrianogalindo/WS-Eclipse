package adactin.hotel.tp2.qualite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class Tp02TestFonctionnel008PrixTotal2ChambreTest
    extends AbstractFunctionalTest {

    public Tp02TestFonctionnel008PrixTotal2ChambreTest() {

        super();
    }

    @Test
    public void test() {

        getDriver().get("http://adactin.com/HotelApp/index.php");
        getDriver().findElement(By.id("username"))
            .click();
        getDriver().findElement(By.id("username"))
            .clear();
        getDriver().findElement(By.id("username"))
            .sendKeys("adrianogalindo");
        getDriver().findElement(By.id("password"))
            .clear();
        getDriver().findElement(By.id("password"))
            .sendKeys("institutgrasset");
        getDriver().findElement(By.id("password"))
            .sendKeys(Keys.ENTER);
        new Select(getDriver().findElement(By.id("location"))).selectByVisibleText("Sydney");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::option[2]"))
            .click();
        new Select(getDriver().findElement(By.id("room_type"))).selectByVisibleText("Deluxe");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/preceding::option[2]"))
            .click();
        new Select(getDriver().findElement(By.id("room_nos"))).selectByVisibleText("2 - Two");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/following::option[3]"))
            .click();
        getDriver().findElement(By.id("datepick_in"))
            .click();
        getDriver().findElement(By.id("datepick_in"))
            .click();
        getDriver().findElement(By.id("datepick_in"))
            .click();
        getDriver().findElement(By.id("datepick_in"))
            .clear();
        getDriver().findElement(By.id("datepick_in"))
            .sendKeys("01/12/2018");
        getDriver().findElement(By.id("datepick_out"))
            .click();
        getDriver().findElement(By.id("datepick_out"))
            .click();
        getDriver().findElement(By.id("datepick_out"))
            .click();
        getDriver().findElement(By.id("datepick_out"))
            .clear();
        getDriver().findElement(By.id("datepick_out"))
            .sendKeys("10/12/2018");
        getDriver().findElement(By.id("Submit"))
            .click();
        validate();
    }

    @Override
    protected final void validate() {

        WebElement element = getDriver().findElement(By.xpath("//*[@id=\"total_price_1\"]"));
        String actualValue = element.getAttribute("value");
        Assert.assertTrue("AUD $ 2700".equals(actualValue));
        element = getDriver().findElement(By.xpath("//*[@id=\"total_price_2\"]"));
        actualValue = element.getAttribute("value");
        Assert.assertTrue("AUD $ 2925".equals(actualValue));
        element = getDriver().findElement(By.xpath("//*[@id=\"total_price_3\"]"));
        actualValue = element.getAttribute("value");
        Assert.assertTrue("AUD $ 3150".equals(actualValue));
        element = getDriver().findElement(By.xpath("//*[@id=\"total_price_4\"]"));
        actualValue = element.getAttribute("value");
        Assert.assertTrue("AUD $ 3375".equals(actualValue));

    }

}
