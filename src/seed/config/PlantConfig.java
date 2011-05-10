package seed.config;

import java.util.Properties;

public abstract class PlantConfig {
	protected Properties properties;
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public PlantConfig(int level){
		properties = new Properties();
	}
}
