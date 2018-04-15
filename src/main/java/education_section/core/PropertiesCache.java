package education_section.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {

    private Properties config = new Properties();
    private static final PropertiesCache INSTANCE = new PropertiesCache();

    private PropertiesCache() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("fb_properties");
        try {
            config.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String getProperty(String key) {
        return INSTANCE.config.getProperty(key);
    }
}
