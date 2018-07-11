package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("utility.properties");
			prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		
		String value = prop.getProperty(key);
		
		return value;
	}

}
