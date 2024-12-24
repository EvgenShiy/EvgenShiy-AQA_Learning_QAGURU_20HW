package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackAppConfig;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {


    public static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static BrowserstackAppConfig browserstackAppConfig = ConfigFactory.create(BrowserstackAppConfig.class, System.getProperties());


    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserstackAppConfig.getBrowserstackUser());
        caps.setCapability("browserstack.key", browserstackAppConfig.getBrowserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", browserstackAppConfig.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", webDriverConfig.getDevice());
        caps.setCapability("os_version", webDriverConfig.getOsVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", webDriverConfig.getProjectName());
        caps.setCapability("build", webDriverConfig.getBuildName());
        caps.setCapability("name", webDriverConfig.getTestName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserstackAppConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
