package kernel.util;

import java.io.IOException;
import java.util.Properties;

import kernel.tests.security.Login_User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KernelConfiguration {
	
	Properties properties = null;
	static final Logger logger = LoggerFactory.getLogger(Login_User.class);
	
	public final static String BROWSER_NAME 			= "browser_name";     
    public final static String CHROME_DRIVER_PATH 		= "chrome_driver_path"; 
    public final static String MAXIMIZED 				= "maximized";	 
    public final static String CONFIG_FILE_NAME 		= "configuration.properties";
 
    private KernelConfiguration() {
        this.properties = new Properties();
        try {
            properties.load(KernelConfiguration.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
    
    public static KernelConfiguration getInstance() {
        return ConfigurationHolder.INSTANCE;
    }
    
    private static class ConfigurationHolder {    	 
        private static final KernelConfiguration INSTANCE = new KernelConfiguration();
    } 
    
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}