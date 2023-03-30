package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {


    protected WebDriver driver; //declare the variable(interface)

    @BeforeAll
    static void oneTimeSetUp() {
        WebDriverManager.chromedriver().setup();//verifies the version of the browser(eg chrome, firefox, Edge etc.)
        // installed in your local machine by its own
        // uses the latest version of the driver
    }

    @BeforeEach
    void setUpBase() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
