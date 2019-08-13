package adactin.hotel.tp2.qualite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class Tp02TestFonctionnel001LoginSuccessfullTest
    extends AbstractFunctionalTest {
    public Tp02TestFonctionnel001LoginSuccessfullTest() {

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
        validate();
    }

    @Override
    protected final void validate() {

        WebElement username = getDriver().findElement(By.xpath("//*[@id=\"username_show\"]"));
        String actualValue = username.getAttribute("value");
        Assert.assertTrue("Hello adrianogalindo!".equals(actualValue));

    }

}
