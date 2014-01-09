package kernel.sandbox;

import java.io.IOException;
import java.util.Properties;

public class tEST {

	public static void main(String[] args) {
		Properties prop = new Properties();
		 
    	try {
               //load a properties file from class path, inside static method
    		prop.load(tEST.class.getClassLoader().getResourceAsStream("configuration.properties"));
 
               //get the property value and print it out
                System.out.println(prop.getProperty("browser_name"));
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
 

	}

}
