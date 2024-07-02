package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Context.Constants;

public class TestProperties {

	public static Properties getProperties() throws IOException {
		FileInputStream fis = new FileInputStream(Constants.PROPERTIESFILE);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
}
