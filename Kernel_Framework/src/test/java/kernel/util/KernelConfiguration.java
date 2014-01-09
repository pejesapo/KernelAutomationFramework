package kernel.util;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KernelConfiguration {

	Properties properties = null;
	public final Logger logger = LoggerFactory
			.getLogger(KernelConfiguration.class);

	public final static String BROWSER_NAME = "browser_name";
	public final static String CHROME_DRIVER_PATH = "chrome_driver_path";
	public final static String IE_DRIVER_PATH = "ie_driver_path";
	public final static String MAXIMIZED = "maximized";
	public final static String CONFIG_FILE_NAME = "configuration.properties";

	private static KernelConfiguration config = null;

	private KernelConfiguration() {

	}

	// Get instance for class KernelConfiguration
	public static KernelConfiguration getInstance() {

		if (null == config) {
			config = new KernelConfiguration();
			config.properties = new Properties();
			try {
				config.properties.load(KernelConfiguration.class.getClassLoader().getResourceAsStream(KernelConfiguration.CONFIG_FILE_NAME));
			} catch (Exception ex) {
				config.logger.error(ex.getMessage());
				ex.printStackTrace();
				
			}

		}

		return config;
	}

	public String getProperty(String key) {
		return this.properties.getProperty(key);
	}

}
