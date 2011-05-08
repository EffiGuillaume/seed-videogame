package seed.config;

public class TreeConfig extends PlantConfig {
	
	public TreeConfig(){
		super();
		properties.setProperty("LVL0_DELAY", "400");
		properties.setProperty("LVL0_RANGE", "100");
		properties.setProperty("LVL0_ENERGYDELAY", "400");
		properties.setProperty("LVL0_COST", "500");
		properties.setProperty("LVL0_WATEREVOLQTY", "5");
		properties.setProperty("LVL0_AIRPROD", "100");
		properties.setProperty("LVL0_WATERREGRESSQTY", "0");
		properties.setProperty("LVL0_ENERGYREGRESSQTY", "-10");
		properties.setProperty("LVL0_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL1_EVOLCOST", "15");
		properties.setProperty("LVL1_DELAY", "200");
		properties.setProperty("LVL1_RANGE", "200");
		properties.setProperty("LVL1_ENERGYDELAY", "200");
		properties.setProperty("LVL1_COST", "500");
		properties.setProperty("LVL1_WATEREVOLQTY", "5");
		properties.setProperty("LVL1_AIRPROD", "500");
		properties.setProperty("LVL1_WATERREGRESSQTY", "0");
		properties.setProperty("LVL1_ENERGYREGRESSQTY", "-5");
		properties.setProperty("LVL1_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL2_EVOLCOST", "25");
		properties.setProperty("LVL2_DELAY", "100");
		properties.setProperty("LVL2_RANGE", "250");
		properties.setProperty("LVL2_ENERGYDELAY", "75");
		properties.setProperty("LVL2_COST", "500");
		properties.setProperty("LVL2_WATEREVOLQTY", "15");
		properties.setProperty("LVL2_AIRPROD", "1000");
		properties.setProperty("LVL2_WATERREGRESSQTY", "5");
		properties.setProperty("LVL2_ENERGYREGRESSQTY", "5");
		properties.setProperty("LVL2_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL3_EVOLCOST", "35");
		properties.setProperty("LVL3_DELAY", "100");
		properties.setProperty("LVL3_RANGE", "250");
		properties.setProperty("LVL3_ENERGYDELAY", "50");
		properties.setProperty("LVL3_COST", "500");
		properties.setProperty("LVL3_WATEREVOLQTY", "25");
		properties.setProperty("LVL3_AIRPROD", "1500");
		properties.setProperty("LVL3_WATERREGRESSQTY", "10");
		properties.setProperty("LVL3_ENERGYREGRESSQTY", "20");
		properties.setProperty("LVL3_IMAGEREFERENCE", "6");
	}
}
