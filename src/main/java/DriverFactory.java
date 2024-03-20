import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static jdk.jpackage.internal.ApplicationLayout.PathRole.APP;

public class DriverFactory {
    AndroidDriver<?> driver;

    public AndroidDriver<?> setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ANDROID");
        capabilities.setCapability(APP, "/Users/skillboxuser/Downloads/ZOOM.apk");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(remoteUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;


    }
}
