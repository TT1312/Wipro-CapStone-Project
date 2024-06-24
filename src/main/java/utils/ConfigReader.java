package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader class reads configuration properties from a file.
 */
public class ConfigReader {
    private Properties properties;

    /**
     * Constructor to initialize ConfigReader and load properties from config file.
     */
    public ConfigReader() {
        properties = new Properties(); // Initialize Properties object
        try {
            // Load properties from config.properties file
            FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Project\\src\\main\\java\\config.properties");
            properties.load(file); // Load properties into Properties object
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if file loading fails
        }
    }

    /**
     * Retrieves the property value for a given key.
     * @param key The key whose associated value is to be returned.
     * @return The value corresponding to the specified key, or null if the key is not found.
     */
    public String getProperty(String key) {
        return properties.getProperty(key); // Get property value based on key
    }
}
