package seed.config;

public class TreeConfig extends PlantConfig {
	
	public TreeConfig(int level){
		super(level);
		
		switch(level){
		case(0): //création d'un TreeConfig LVL0
		{
			properties.setProperty("DELAY", "400");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "400");
			properties.setProperty("COST", "1000");
			properties.setProperty("WATEREVOLQTY", "15");
			properties.setProperty("AIRPROD", "100");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-2");
			properties.setProperty("IMAGEREFERENCE", "5");
			
			break;
		}
		case(1): //création d'un TreeConfig LVL1
		{
			properties.setProperty("EVOLCOST", "40");
			properties.setProperty("DELAY", "200");
			properties.setProperty("RANGE", "200");
			properties.setProperty("ENERGYDELAY", "200");
			properties.setProperty("COST", "1000");
			properties.setProperty("WATEREVOLQTY", "25");
			properties.setProperty("AIRPROD", "300");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(2): //création d'un TreeConfig LVL2
		{
			properties.setProperty("EVOLCOST", "50");
			properties.setProperty("DELAY", "100");
			properties.setProperty("RANGE", "250");
			properties.setProperty("ENERGYDELAY", "100");
			properties.setProperty("COST", "1000");
			properties.setProperty("WATEREVOLQTY", "35");
			properties.setProperty("AIRPROD", "600");
			properties.setProperty("WATERREGRESSQTY", "5");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "7");
			
			break;
		}
		case(3): //création d'un TreeConfig LVL3
		{
			properties.setProperty("EVOLCOST", "50");
			properties.setProperty("DELAY", "100");
			properties.setProperty("RANGE", "250");
			properties.setProperty("ENERGYDELAY", "100");
			properties.setProperty("COST", "1000");
			properties.setProperty("WATEREVOLQTY", "70");
			properties.setProperty("AIRPROD", "1500");
			properties.setProperty("WATERREGRESSQTY", "10");
			properties.setProperty("ENERGYREGRESSQTY", "-10");
			properties.setProperty("IMAGEREFERENCE", "8");
			
			break;
		}
		default: //création d'un TreeConfig par défaut
		{
			properties.setProperty("DELAY", "400");
			properties.setProperty("RANGE", "100");
			properties.setProperty("ENERGYDELAY", "400");
			properties.setProperty("COST", "1000");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "100");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-10");
			properties.setProperty("IMAGEREFERENCE", "7");
		}
		}//end of switch
	}
}
