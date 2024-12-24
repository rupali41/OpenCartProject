package properties_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class prop_file {
	
	static FileInputStream fis;
	public static String Extract_PropertyFile(String filepath,String key) {
		try {
			 fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String KeyValue = prop.getProperty(key);
		return KeyValue;
		
	}


}
