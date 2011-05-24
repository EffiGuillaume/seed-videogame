package seed.config;

public class FlowerConfig extends PlantConfig {
	
	public FlowerConfig(int level){
		super(level);
		
		switch(level){
		case(0): //création d'un FlowerConfig LVL0
		{
			properties.setProperty("DELAY", "600");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "500");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "20");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "4");
			
			break;
		}
		case(1): //création d'un FlowerConfig LVL1
		{
			properties.setProperty("EVOLCOST", "15");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "150");
			properties.setProperty("ENERGYDELAY", "250");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "13");
			properties.setProperty("AIRPROD", "100");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-3");
			properties.setProperty("IMAGEREFERENCE", "5");
			
			break;
		}
		case(2): //création d'un FlowerConfig LVL2
		{
			properties.setProperty("EVOLCOST", "30");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "150");
			properties.setProperty("ENERGYDELAY", "200");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "20");
			properties.setProperty("AIRPROD", "200");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(3): //création d'un FlowerConfig LVL3
		{
			properties.setProperty("EVOLCOST", "50");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "150");
			properties.setProperty("COST", "150");
			properties.setProperty("WATEREVOLQTY", "35");
			properties.setProperty("AIRPROD", "400");
			properties.setProperty("WATERREGRESSQTY", "-5");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "7");
			
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
			properties.setProperty("IMAGEREFERENCE", "4");
		}
		}//end of switch

	}
}
