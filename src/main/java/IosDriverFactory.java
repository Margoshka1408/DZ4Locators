import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static jdk.jpackage.internal.ApplicationLayout.PathRole.APP;

public class IosDriverFactory {
    IOSDriver<?> driver;

    public IOSDriver<?> setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability(BUNDLE_ID, "com.apple.Health");
        capabilities.setCapability(DEVICE_NAME, "iPhone 12 Pro Max");
        capabilities.setCapability(PLATFORM_VERSION, "14.4");
        capabilities.setCapability(UDID, "5E854D79-5FE2-43A9-9EB7-1C663B3D8DE5");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new IOSDriver<>(remoteUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;


    }
}
