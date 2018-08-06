package Utilities;

import java.io.File;
import java.io.FileInputStream;
 
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	public static String getValueForkey(String key) throws Exception, IOException
	{
		Properties configProperties =new Properties();
		configProperties.load(new FileInputStream(new File("./propertiesFile/Environment.Properties")));
	    return configProperties.getProperty(key);
	}

}
