package seed.config;

public class AlgaConfig extends PlantConfig {
	
	public AlgaConfig(){
		super();
		properties.setProperty("LVL0_DELAY", "1000");
		properties.setProperty("LVL0_RANGE", "50");
		properties.setProperty("LVL0_ENERGYDELAY", "200");
		properties.setProperty("LVL0_COST", "100");
		properties.setProperty("LVL0_WATEREVOLQTY", "5");
		properties.setProperty("LVL0_AIRPROD", "0");
		properties.setProperty("LVL0_WATERREGRESSQTY", "0");
		properties.setProperty("LVL0_ENERGYREGRESSQTY", "-10");
		properties.setProperty("LVL0_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL1_EVOLCOST", "5");
		properties.setProperty("LVL1_DELAY", "750");
		properties.setProperty("LVL1_RANGE", "50");
		properties.setProperty("LVL1_ENERGYDELAY", "100");
		properties.setProperty("LVL1_COST", "100");
		properties.setProperty("LVL1_WATEREVOLQTY", "5");
		properties.setProperty("LVL1_AIRPROD", "100");
		properties.setProperty("LVL1_WATERREGRESSQTY", "0");
		properties.setProperty("LVL1_ENERGYREGRESSQTY", "-5");
		properties.setProperty("LVL1_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL2_EVOLCOST", "10");
		properties.setProperty("LVL2_DELAY", "500");
		properties.setProperty("LVL2_RANGE", "75");
		properties.setProperty("LVL2_ENERGYDELAY", "75");
		properties.setProperty("LVL2_COST", "100");
		properties.setProperty("LVL2_WATEREVOLQTY", "10");
		properties.setProperty("LVL2_AIRPROD", "200");
		properties.setProperty("LVL2_WATERREGRESSQTY", "5");
		properties.setProperty("LVL2_ENERGYREGRESSQTY", "0");
		properties.setProperty("LVL2_IMAGEREFERENCE", "6");
		
		properties.setProperty("LVL3_EVOLCOST", "20");
		properties.setProperty("LVL3_DELAY", "250");
		properties.setProperty("LVL3_RANGE", "75");
		properties.setProperty("LVL3_ENERGYDELAY", "75");
		properties.setProperty("LVL3_COST", "100");
		properties.setProperty("LVL3_WATEREVOLQTY", "10");
		properties.setProperty("LVL3_AIRPROD", "300");
		properties.setProperty("LVL3_WATERREGRESSQTY", "10");
		properties.setProperty("LVL3_ENERGYREGRESSQTY", "5");
		properties.setProperty("LVL3_IMAGEREFERENCE", "6");
	}
}
