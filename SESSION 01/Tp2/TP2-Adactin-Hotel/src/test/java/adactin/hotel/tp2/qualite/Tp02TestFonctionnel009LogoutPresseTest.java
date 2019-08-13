package adactin.hotel.tp2.qualite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class Tp02TestFonctionnel009LogoutPresseTest
    extends AbstractFunctionalTest {

    public Tp02TestFonctionnel009LogoutPresseTest() {

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
        getDriver().findElement(By.linkText("Logout"))
            .click();
        validate();
    }

    @Override
    protected final void validate() {

        WebElement element =
            getDriver()
                .findElement(By.xpath("/html/body/table[2]/tbody/tr/td[1]/table/tbody/tr/td"));
        String actualMessage = element.getText();
        Assert.assertTrue(
            "You have successfully logged out. Click here to login again".equals(actualMessage));

    }

}
