package seed.config;

public class FlowerConfig extends PlantConfig {
	
	public FlowerConfig(int level){
		super(level);
		
		switch(level){
		case(0): //création d'un FlowerConfig LVL0
		{
			properties.setProperty("DELAY", "600");
			properties.setProperty("RANGE", "50");
			properties.setProperty("ENERGYDELAY", "300");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "10");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(1): //création d'un FlowerConfig LVL1
		{
			properties.setProperty("EVOLCOST", "10");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "150");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "300");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-1");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(2): //création d'un FlowerConfig LVL2
		{
			properties.setProperty("EVOLCOST", "20");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "150");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "600");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "5");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(3): //création d'un FlowerConfig LVL3
		{
			properties.setProperty("EVOLCOST", "30");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "100");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "900");
			properties.setProperty("WATERREGRESSQTY", "5");
			properties.setProperty("ENERGYREGRESSQTY", "10");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		default: //création d'un FlowerConfig par défaut
		{
			properties.setProperty("DELAY", "600");
			properties.setProperty("RANGE", "50");
			properties.setProperty("ENERGYDELAY", "300");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "10");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "6");
		}
		}//end of switch

	}
}
