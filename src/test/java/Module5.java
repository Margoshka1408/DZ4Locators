import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class Module5<MobileElement> {

    @AndroidFindBy(id = "btnJoinConf")
    MobileElement btnJoinConf;

    @AndroidFindBy(id = "txtTitle")
    MobileElement txtTitle;

    @AndroidFindBy(id = "btnBack")
    MobileElement btnBack;

    @AndroidFindBy(id = "panelConfNumber")
    MobileElement panelConfNumber;

    @AndroidFindBy(id = "btnGotoVanityUrl")
    MobileElement btnGotoVanityUrl;

    @AndroidFindBy(id = "panelScreenName")
    MobileElement panelScreenName;

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeStaticText\" AND name == \"Summary\"")
    MobileElement summaryTitle;

    @iOSXCUITFindBy(accessibility = "Profile")
    MobileElement profileIcon;

    @iOSXCUITFindBy(accessibility = "Favorites")
    MobileElement favoritesTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "type ==\"XCUIElementTypeButton\" AND name == \"Edit\"")
    MobileElement editButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther['name=\"feeditem_identifier\"'][1]/XCUIElementTypeButton*)
    MobileElement stepsButton;

    private static final DriverFactory driverFactory = new DriverFactory();
    private static AndroidDriver<?> driver;

    @BeforeAll
    public static void setDriver() throws MalformedURLException{
        driver = driverFactory.setUp();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Test
    public void homeTest() throws InterruptedException {
        btnJoinConf.click();

        Thread.sleep(2000);

        txtTitle.isDisplayed();
        btnBack.isDisplayed();
        panelConfNumber.isDisplayed();
        btnGotoVanityUrl.isDisplayed();
        panelScreenName.isDisplayed();

        MobileElement joinButton = (MobileElement) driver.findElementById("btnJoin");
        MobileElement linkText = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"tap on the link to join the meeting\")");
        MobileElement optionsTitle = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"JOIN OPTIONS\")");
        MobileElement optionNoAudio = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"Don`t Connect To Audio\")");
        MobileElement chkNoAudio = (MobileElement) driver.findElementById("chkNoAudio");

        joinButton.isDisplayed();
        linkText.isDisplayed();
        optionsTitle.isDisplayed();
        optionNoAudio.isDisplayed();
        chkNoAudio.isDisplayed();
    }
    @Test
    public void iosHomeTest{
        summaryTitle.isDisplyed();
        profileIcon.isDisplyed();
        favoritesTitle.isDisplyed();
        editButton.isDisplyed();
        stepsButton.isDisplyed();
        MobileElement noDataText = (MobileElement) driver.findElementByAccessibilityId("No Data");

        MobileElement showAllHealthDataButton = (MobileElement) driver.findElement(
                MobileBy.iOSNsPredicateString("type == \"XCUIElementTypeButton\" AND name == \"Show All Health Data\""));

        MobileElement getMoreTitle = (MobileElement) driver.findElementByAccessibilityId("Get More From Health");

        MobileElement medicalIdIcon = (MobileElement) driver.findElementByAccessibilityId("medical id");

        MobileElement getStartedButton = (MobileElement) driver.findElement(
                MobileBy.iOSClassChain("**/XCUIElementTypeButton['name==\"Get Started\*'][1]"));

        noDataText.isDisplyed();
        showAllHealthDataButton.isDisplyed();
        getMoreTitle.isDisplyed();
        medicalIdIcon.isDisplyed();
        getStartedButton.isDisplyed();
        }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
