import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability("automationName", "UIAutomator2");
        //caps.setCapability("platformVersion", "13.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir")+"/app/fitnelly-0.1.0.apk");
        System.out.println("MAP: " + caps.toJson());

        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

    @Test
    public void tst(){
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"))
                .click();
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
