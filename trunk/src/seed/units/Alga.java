package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.config.Configs;
import seed.field.BlockType;
import seed.interactions.Evolution;

public class Alga extends Plant {
	
	public Alga(String id) throws SlickException {
		super(id);
		this.delay = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_DELAY"));
		this.range = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_RANGE"));
		this.storage = 0;
		this.energy = 0;
		this.energyDelay = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_ENERGYDELAY"));
		this.cost = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_COST"));
		this.waterEvolQty = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_WATEREVOLQTY"));
		this.airProd = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_AIRPROD"));
		this.waterRegressQty = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_WATERREGRESSQTY"));
		this.energyRegressQty = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_ENERGYREGRESSQTY"));
		this.imageReference = Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_IMAGEREFERENCE"));
		
		ArrayList<Evolution> evolutions = new ArrayList<Evolution>();
			Evolution lvl1 = new Evolution("ALGA_LVL1_Evolution");
			lvl1.setEnergyCost(Integer.parseInt(Configs.getType("ALGA").getProperty("LVL1_EVOLCOST")));
			ArrayList<BlockType> fields0 = new ArrayList<BlockType>();
				fields0.add(BlockType.CHEMIN);
				fields0.add(BlockType.FORET);
			lvl1.setFields(fields0);
			lvl1.setType("ALGA");
			lvl1.setEvol("LVL1");
		
			Evolution lvl2 = new Evolution("ALGA_LVL2_Evolution");
				lvl2.setEnergyCost(Integer.parseInt(Configs.getType("ALGA").getProperty("LVL2_EVOLCOST")));
				ArrayList<BlockType> fields = new ArrayList<BlockType>();
					fields.add(BlockType.CHEMIN);
				lvl2.setFields(fields);
				lvl2.setType("ALGA");
				lvl2.setEvol("LVL2");
				
			Evolution lvl3 = new Evolution("ALGA_LVL3_Evolution");
				lvl3.setEnergyCost(Integer.parseInt(Configs.getType("ALGA").getProperty("LVL3_EVOLCOST"))); 
				ArrayList<BlockType> fields2 = new ArrayList<BlockType>();
					fields2.add(BlockType.CHEMIN);
				lvl3.setFields(fields2);
				lvl3.setType("ALGA");
				lvl3.setEvol("LVL3");
		
		this.evolutions = evolutions;
		
		addComponent(new PlantRenderComponent(id+"_Render", new Image("res/graineSprite.png")));
	}

	public Alga(String id, 
			int delay, 
			float range, 
			int energyDelay, 
			int cost, 
			int waterEvolQty, 
			int airProd, 
			int waterRegressQty, 
			int energyRegressQty, 
			ArrayList<Evolution> evolutions, 
			int imageReference,
			Image image){
		super(id+"_Alga", delay, range, energyDelay, cost, waterEvolQty, airProd, waterRegressQty, energyRegressQty, evolutions, imageReference, image);
	}
}
