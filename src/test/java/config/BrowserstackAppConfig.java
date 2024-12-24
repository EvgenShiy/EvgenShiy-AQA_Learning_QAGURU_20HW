package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/browserstack.properties"})
public interface BrowserstackAppConfig extends Config {
    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();
}
