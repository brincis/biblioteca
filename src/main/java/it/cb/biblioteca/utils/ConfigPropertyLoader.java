package it.cb.biblioteca.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropertyLoader {
	
	public Properties loadConfigFile(String filePath) throws Exception {
		Properties prop = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				fis.close();
			}
		}
		return prop;
	}	
	}
	

