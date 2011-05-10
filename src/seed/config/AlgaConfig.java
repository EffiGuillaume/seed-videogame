package seed.config;

public class AlgaConfig extends PlantConfig {
	
	public AlgaConfig(int level){
super(level);
		
		switch(level){
		case(0): //création d'un AlgaConfig LVL0
		{
			properties.setProperty("DELAY", "1000");
			properties.setProperty("RANGE", "50");
			properties.setProperty("ENERGYDELAY", "200");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "0");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-10");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(1): //création d'un AlgaConfig LVL1
		{
			properties.setProperty("EVOLCOST", "5");
			properties.setProperty("DELAY", "750");
			properties.setProperty("RANGE", "50");
			properties.setProperty("ENERGYDELAY", "100");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "100");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-5");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(2): //création d'un AlgaConfig LVL2
		{
			properties.setProperty("EVOLCOST", "10");
			properties.setProperty("DELAY", "500");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "75");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "200");
			properties.setProperty("WATERREGRESSQTY", "5");
			properties.setProperty("ENERGYREGRESSQTY", "0");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		case(3): //création d'un AlgaConfig LVL3
		{
			properties.setProperty("EVOLCOST", "20");
			properties.setProperty("DELAY", "250");
			properties.setProperty("RANGE", "75");
			properties.setProperty("ENERGYDELAY", "75");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "10");
			properties.setProperty("AIRPROD", "300");
			properties.setProperty("WATERREGRESSQTY", "10");
			properties.setProperty("ENERGYREGRESSQTY", "5");
			properties.setProperty("IMAGEREFERENCE", "6");
			
			break;
		}
		default: //création d'un AlgaConfig par défaut
		{
			properties.setProperty("DELAY", "1000");
			properties.setProperty("RANGE", "50");
			properties.setProperty("ENERGYDELAY", "200");
			properties.setProperty("COST", "100");
			properties.setProperty("WATEREVOLQTY", "5");
			properties.setProperty("AIRPROD", "0");
			properties.setProperty("WATERREGRESSQTY", "0");
			properties.setProperty("ENERGYREGRESSQTY", "-10");
			properties.setProperty("IMAGEREFERENCE", "6");
		}
		}//end of switch
	
	}
}
