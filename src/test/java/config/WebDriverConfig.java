package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:properties/${env}.properties",
//        "classpath:properties/android.properties"
})
public interface WebDriverConfig extends Config {


    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getOsVersion();

    @Key("projectName")
    @DefaultValue("Default Mobile Java Project")
    String getProjectName();

    @Key("buildName")
    @DefaultValue("Default-browserstack-build")
    String getBuildName();

    @Key("testName")
    @DefaultValue("Default Mobile Test")
    String getTestName();
}
