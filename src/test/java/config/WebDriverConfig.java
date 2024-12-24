package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:properties/${env}.properties",
})
public interface WebDriverConfig extends Config {

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

}
