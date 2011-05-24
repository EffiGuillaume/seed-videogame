package seed.config;

public class HerbConfig extends PlantConfig{
		
	public HerbConfig(int level){
		super(level);
		
		switch(level){
		case(0): //création d'un HerbConfig LVL0
		{
			properties.setProperty("DELAY", "600");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "500");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "3");
			properties.setProperty("AIRPROD", "10");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-10");
			properties.setProperty("IMAGEREFERENCE", "4");
			
			break;
		}
		case(1): //création d'un HerbConfig LVL1
		{
			properties.setProperty("EVOLCOST", "15");
			properties.setProperty("DELAY", "300");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "250");
			properties.setProperty("COST", "50");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "50");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "5");
			
			break;
		}
		case(2): //création d'un HerbConfig LVL2
		{
			properties.setProperty("EVOLCOST", "20");
			properties.setProperty("DELAY", "200");
			properties.setProperty("RANGE", "125");
			properties.setProperty("ENERGYDELAY", "200");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "20");
			properties.setProperty("AIRPROD", "100");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-3");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(3): //création d'un HerbConfig LVL3
		{
			properties.setProperty("EVOLCOST", "25");
			properties.setProperty("DELAY", "150");
			properties.setProperty("RANGE", "150");
			properties.setProperty("ENERGYDELAY", "150");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "30");
			properties.setProperty("AIRPROD", "200");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-3");
			properties.setProperty("IMAGEREFERENCE", "7");
			
			break;
		}
		default: //création d'un HerbConfig par défaut
		{
			properties.setProperty("DELAY", "600");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "200");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "0");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-10");
			properties.setProperty("IMAGEREFERENCE", "4");
		}
		}//end of switch
		
	}

}
