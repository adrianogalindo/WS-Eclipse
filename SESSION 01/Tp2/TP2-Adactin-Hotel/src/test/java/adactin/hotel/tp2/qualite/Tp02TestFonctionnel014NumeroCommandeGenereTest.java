package adactin.hotel.tp2.qualite;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ca.qc.grasset._420_pa4_ag.lab05.commons.AbstractFunctionalTest;

public class Tp02TestFonctionnel014NumeroCommandeGenereTest
    extends AbstractFunctionalTest {
    public Tp02TestFonctionnel014NumeroCommandeGenereTest() {

        super();
    }

    @Test
    public void test() {

        getDriver().get("http://adactin.com/HotelApp/");
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
        getDriver().findElement(By.id("login"))
            .click();
        getDriver().findElement(By.id("location"))
            .click();
        new Select(getDriver().findElement(By.id("location"))).selectByVisibleText("Sydney");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::option[2]"))
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
            .clear();
        getDriver().findElement(By.id("datepick_out"))
            .sendKeys("10/12/2018");
        getDriver().findElement(By.id("Submit"))
            .click();
        getDriver().findElement(By.id("radiobutton_1"))
            .click();
        getDriver().findElement(By.id("continue"))
            .click();
        getDriver().findElement(By.id("first_name"))
            .click();
        getDriver().findElement(By.id("first_name"))
            .clear();
        getDriver().findElement(By.id("first_name"))
            .sendKeys("a");
        getDriver().findElement(By.id("last_name"))
            .click();
        getDriver().findElement(By.id("last_name"))
            .clear();
        getDriver().findElement(By.id("last_name"))
            .sendKeys("a");
        getDriver().findElement(By.id("address"))
            .click();
        getDriver().findElement(By.id("address"))
            .clear();
        getDriver().findElement(By.id("address"))
            .sendKeys("a");
        getDriver().findElement(By.id("cc_num"))
            .click();
        getDriver().findElement(By.id("cc_num"))
            .clear();
        getDriver().findElement(By.id("cc_num"))
            .sendKeys("9999999999999999");
        getDriver().findElement(By.id("cc_type"))
            .click();
        new Select(getDriver().findElement(By.id("cc_type")))
            .selectByVisibleText("American Express");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[5]/following::option[2]"))
            .click();
        getDriver().findElement(By.id("cc_exp_month"))
            .click();
        new Select(getDriver().findElement(By.id("cc_exp_month"))).selectByVisibleText("November");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[6]/following::option[12]"))
            .click();
        getDriver().findElement(By.id("cc_exp_year"))
            .click();
        new Select(getDriver().findElement(By.id("cc_exp_year"))).selectByVisibleText("2021");
        getDriver().findElement(
            By.xpath(
                "(.//*[normalize-space(text()) and normalize-space(.)='*'])[6]/following::option[25]"))
            .click();
        getDriver().findElement(By.id("cc_cvv"))
            .click();
        getDriver().findElement(By.id("cc_cvv"))
            .clear();
        getDriver().findElement(By.id("cc_cvv"))
            .sendKeys("999");
        getDriver().findElement(By.id("book_now"))
            .click();
        validate();
    }

    @Override
    protected void validate() {

        final int timeOut = 10;

        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element =
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_no")));
        String actualValue = element.getAttribute("value");
        Assert.assertFalse("".equals(actualValue));

    }

}
