package seed.config;

import java.util.Properties;

public class HerbConfig extends PlantConfig{
	
	protected static Properties properties = new Properties();
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}
	
	protected HerbConfig(){
		super();
	}
	
	public static void init(){
		properties.setProperty("LVL0_DELAY", "600");
		properties.setProperty("LVL0_RANGE", "100");
		properties.setProperty("LVL0_ENERGYDELAY", "200");
		properties.setProperty("LVL0_COST", "100");
		properties.setProperty("LVL0_WATEREVOLQTY", "5");
		properties.setProperty("LVL0_AIRPROD", "0");
		properties.setProperty("LVL0_WATERREGRESSQTY", "0");
		properties.setProperty("LVL0_ENERGYREGRESSQTY", "-10");
		properties.setProperty("LVL0_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL1_EVOLCOST", "5");
		properties.setProperty("LVL1_DELAY", "300");
		properties.setProperty("LVL1_RANGE", "100");
		properties.setProperty("LVL1_ENERGYDELAY", "100");
		properties.setProperty("LVL1_COST", "100");
		properties.setProperty("LVL1_WATEREVOLQTY", "5");
		properties.setProperty("LVL1_AIRPROD", "100");
		properties.setProperty("LVL1_WATERREGRESSQTY", "0");
		properties.setProperty("LVL1_ENERGYREGRESSQTY", "-5");
		properties.setProperty("LVL1_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL2_EVOLCOST", "10");
		properties.setProperty("LVL2_DELAY", "200");
		properties.setProperty("LVL2_RANGE", "125");
		properties.setProperty("LVL2_ENERGYDELAY", "75");
		properties.setProperty("LVL2_COST", "100");
		properties.setProperty("LVL2_WATEREVOLQTY", "10");
		properties.setProperty("LVL2_AIRPROD", "200");
		properties.setProperty("LVL2_WATERREGRESSQTY", "0");
		properties.setProperty("LVL2_ENERGYREGRESSQTY", "0");
		properties.setProperty("LVL2_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL3_EVOLCOST", "15");
		properties.setProperty("LVL3_DELAY", "150");
		properties.setProperty("LVL3_RANGE", "150");
		properties.setProperty("LVL3_ENERGYDELAY", "75");
		properties.setProperty("LVL3_COST", "100");
		properties.setProperty("LVL3_WATEREVOLQTY", "10");
		properties.setProperty("LVL3_AIRPROD", "300");
		properties.setProperty("LVL3_WATERREGRESSQTY", "5");
		properties.setProperty("LVL3_ENERGYREGRESSQTY", "5");
		properties.setProperty("LVL3_IMAGEREFERENCE", "6");
	}

}
