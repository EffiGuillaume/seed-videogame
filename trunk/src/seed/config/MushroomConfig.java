package seed.config;

public class MushroomConfig extends PlantConfig{
		
	public MushroomConfig(int level){
		super(level);
		
		switch(level){
		case(0): //création d'un MushroomConfig LVL0
		{
			properties.setProperty("DELAY", "700");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "400");
			properties.setProperty("COST", "250");
			properties.setProperty("WATEREVOLQTY", "2");
			properties.setProperty("AIRPROD", "50");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-40");
			properties.setProperty("IMAGEREFERENCE", "1");
			
			break;
		}
		case(1): //création d'un MushroomConfig LVL1
		{
			properties.setProperty("EVOLCOST", "5");
			properties.setProperty("DELAY", "600");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "300");
			properties.setProperty("COST", "250");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "75");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-15");
			properties.setProperty("IMAGEREFERENCE", "2");
			
			break;
		}
		case(2): //création d'un MushroomConfig LVL2
		{
			properties.setProperty("EVOLCOST", "10");
			properties.setProperty("DELAY", "500");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "75");
			properties.setProperty("COST", "250");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "75");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "3");
			
			break;
		}
		case(3): //création d'un MushroomConfig LVL3
		{
			properties.setProperty("EVOLCOST", "15");
			properties.setProperty("DELAY", "200");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "75");
			properties.setProperty("COST", "250");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "100");
			properties.setProperty("WATERREGRESSQTY", "5");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "4");
			
			break;
		}
		default: //création d'un MushroomConfig par défaut
		{
			properties.setProperty("DELAY", "700");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "400");
			properties.setProperty("COST", "250");
			properties.setProperty("WATEREVOLQTY", "2");
			properties.setProperty("AIRPROD", "50");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-40");
			properties.setProperty("IMAGEREFERENCE", "1");
		}
		}//end of switch
		
	}
}
