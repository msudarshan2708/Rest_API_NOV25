package Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties props = new Properties();

	static {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\Admin\\eclipse-workspace\\cucumber-restassured\\src\\test\\resources\\Resources\\config.propertes");
			props.load(file);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}
}
