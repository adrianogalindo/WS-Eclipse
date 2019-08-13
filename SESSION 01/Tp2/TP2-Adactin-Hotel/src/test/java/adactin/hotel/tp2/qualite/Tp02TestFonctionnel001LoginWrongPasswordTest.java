package adactin.hotel.tp2.qualite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class Tp02TestFonctionnel001LoginWrongPasswordTest
    extends AbstractFunctionalTest {
    public Tp02TestFonctionnel001LoginWrongPasswordTest() {

        super();
    }

    @Test
    public void test() {

        getDriver().get("http://adactin.com/HotelApp/index.php");
        getDriver().findElement(By.id("username"))
            .clear();
        getDriver().findElement(By.id("username"))
            .sendKeys("adrianogalindo");
        getDriver().findElement(By.id("password"))
            .clear();
        getDriver().findElement(By.id("password"))
            .sendKeys("wrongpassword");
        getDriver().findElement(By.id("login"))
            .click();
        validate();
    }

    @Override
    protected final void validate() {

        WebElement element =
            getDriver().findElement(
                By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[5]/td[2]/div/b"));
        String actualMessage = element.getText();
        Assert.assertTrue(
            "Invalid Login details or Your Password might have expired. Click here to reset your password"
                .equals(actualMessage));

    }

}
