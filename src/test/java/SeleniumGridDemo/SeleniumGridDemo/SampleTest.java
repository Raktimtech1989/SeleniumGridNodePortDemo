package SeleniumGridDemo.SeleniumGridDemo;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {
	
	private static final String IP = "localhost";
    private static final int PORT = 4444;
 
    private RemoteWebDriver driver;
    private ActiveNodeDeterminer determiner = new ActiveNodeDeterminer(IP, PORT);
 
    @BeforeClass
    public void setup() throws Exception {
        URL url = new URL("http://" + IP + ":" + PORT + "/wd/hub");
        driver = new RemoteWebDriver(url, DesiredCapabilities.firefox());
    }
 
    @Test
    public void test() {
        Reporter.log("Node : " + determiner.getNodeInfoForSession(driver.getSessionId()), true);
    }
 
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
