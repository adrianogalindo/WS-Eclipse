package ca.qc.grasset._420_pa4_ag.tp03.commons;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public abstract class AbstractFunctionalTest {

    protected static final String DEVKEY = "8838dd64da152b264ca393b9a72743b1"; // TODO:
                                                                               // Changer
                                                                               // pour
                                                                               // votre
                                                                               // DEVKEY

    protected static final String URL = "http://192.168.56.3/lib/api/xmlrpc/v1/xmlrpc.php"; // TODO:
                                                                                            // Changer
                                                                                            // pour
                                                                                            // l'URL
                                                                                            // de
                                                                                            // votre
                                                                                            // machine
                                                                                            // VirtualBox

    private static final int TIMEOUT_DURATION_SECONDS = 5;

    private boolean acceptNextAlert = true;

    private WebDriver driver;

    private final StringBuffer verificationErrors = new StringBuffer();

    public AbstractFunctionalTest() {

        super();
    }

    @Before
    public final void setUp() {

        final String firefoxDriverPath = System.getProperty("user.dir") + "/tools/geckodriver";
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        this.driver = new FirefoxDriver();
        this.driver.manage()
            .timeouts()
            .implicitlyWait(AbstractFunctionalTest.TIMEOUT_DURATION_SECONDS, TimeUnit.SECONDS);
    }

    @After
    public final void tearDown() {

        this.driver.quit();
        String verificationErrorString = this.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }

    protected final String closeAlertAndGetItsText() {

        try {
            Alert alert =
                this.driver.switchTo()
                    .alert();
            String alertText = alert.getText();
            if (this.acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            this.acceptNextAlert = true;
        }
    }

    protected final WebDriver getDriver() {

        return this.driver;
    }

    protected final boolean isAlertPresent() {

        try {
            this.driver.switchTo()
                .alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected final boolean isElementPresent(
        final By byLocator_) {

        try {
            this.driver.findElement(byLocator_);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected final void reportResult(
        final String testProject_,
        final String testPlan_,
        final String testCase_,
        final String build_,
        final String notes_,
        final String result_)
        throws TestLinkAPIException {

        TestLinkAPIClient testLinkApi =
            new TestLinkAPIClient(AbstractFunctionalTest.DEVKEY, AbstractFunctionalTest.URL);
        testLinkApi
            .reportTestCaseResult(testProject_, testPlan_, testCase_, build_, notes_, result_);
    }

    protected abstract void validate();
}
