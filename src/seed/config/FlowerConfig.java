package seed.config;

public class FlowerConfig extends PlantConfig {
	
	protected FlowerConfig(){
		super();
	}
	
	public static void init(){
		properties.setProperty("LVL0_DELAY", "600");
		properties.setProperty("LVL0_RANGE", "50");
		properties.setProperty("LVL0_ENERGYDELAY", "300");
		properties.setProperty("LVL0_COST", "150");
		properties.setProperty("LVL0_WATEREVOLQTY", "5");
		properties.setProperty("LVL0_AIRPROD", "10");
		properties.setProperty("LVL0_WATERREGRESSQTY", "0");
		properties.setProperty("LVL0_ENERGYREGRESSQTY", "-5");
		properties.setProperty("LVL0_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL1_EVOLCOST", "10");
		properties.setProperty("LVL1_DELAY", "300");
		properties.setProperty("LVL1_RANGE", "100");
		properties.setProperty("LVL1_ENERGYDELAY", "150");
		properties.setProperty("LVL1_COST", "150");
		properties.setProperty("LVL1_WATEREVOLQTY", "5");
		properties.setProperty("LVL1_AIRPROD", "300");
		properties.setProperty("LVL1_WATERREGRESSQTY", "0");
		properties.setProperty("LVL1_ENERGYREGRESSQTY", "-1");
		properties.setProperty("LVL1_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL2_EVOLCOST", "20");
		properties.setProperty("LVL2_DELAY", "300");
		properties.setProperty("LVL2_RANGE", "100");
		properties.setProperty("LVL2_ENERGYDELAY", "150");
		properties.setProperty("LVL2_COST", "150");
		properties.setProperty("LVL2_WATEREVOLQTY", "10");
		properties.setProperty("LVL2_AIRPROD", "600");
		properties.setProperty("LVL2_WATERREGRESSQTY", "0");
		properties.setProperty("LVL2_ENERGYREGRESSQTY", "5");
		properties.setProperty("LVL2_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL3_EVOLCOST", "30");
		properties.setProperty("LVL3_DELAY", "300");
		properties.setProperty("LVL3_RANGE", "100");
		properties.setProperty("LVL3_ENERGYDELAY", "100");
		properties.setProperty("LVL3_COST", "150");
		properties.setProperty("LVL3_WATEREVOLQTY", "10");
		properties.setProperty("LVL3_AIRPROD", "900");
		properties.setProperty("LVL3_WATERREGRESSQTY", "5");
		properties.setProperty("LVL3_ENERGYREGRESSQTY", "10");
		properties.setProperty("LVL3_IMAGEREFERENCE", "6");
	}
}
