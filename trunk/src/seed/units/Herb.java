package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.config.HerbConfig;
import seed.field.BlockType;
import seed.interactions.Evolution;

public class Herb extends Plant {
	
	public Herb(String id) throws SlickException {
		super(id);
		this.delay = Integer.parseInt(HerbConfig.getProperty("LVL1_DELAY"));
		this.range = Integer.parseInt(HerbConfig.getProperty("LVL1_RANGE"));
		this.storage = 0;
		this.energy = 0;
		this.energyDelay = Integer.parseInt(HerbConfig.getProperty("LVL1_ENERGYDELAY"));
		this.cost = Integer.parseInt(HerbConfig.getProperty("LVL1_COST"));
		this.waterEvolQty = Integer.parseInt(HerbConfig.getProperty("LVL1_WATEREVOLQTY"));
		this.airProd = Integer.parseInt(HerbConfig.getProperty("LVL1_AIRPROD"));
		this.waterRegressQty = Integer.parseInt(HerbConfig.getProperty("LVL1_WATERREGRESSQTY"));
		this.energyRegressQty = Integer.parseInt(HerbConfig.getProperty("LVL1_ENERGYREGRESSQTY"));
		this.imageReference = Integer.parseInt(HerbConfig.getProperty("LVL1_IMAGEREFERENCE"));
		
		ArrayList<Evolution> evolutions = new ArrayList<Evolution>();
			Evolution lvl1 = new Evolution("LVL1_Herb_Evolution");
			lvl1.setEnergyCost(Integer.parseInt(HerbConfig.getProperty("LVL1_EVOLCOST")));
			ArrayList<BlockType> fields0 = new ArrayList<BlockType>();
				fields0.add(BlockType.DESERT);
				fields0.add(BlockType.FORET);
			lvl1.setFields(fields0);
			lvl1.setType("LVL1");
		
			Evolution lvl2 = new Evolution("LVL2_Herb_Evolution");
				lvl2.setEnergyCost(Integer.parseInt(HerbConfig.getProperty("LVL2_EVOLCOST")));
				ArrayList<BlockType> fields = new ArrayList<BlockType>();
					fields.add(BlockType.DESERT);
					fields.add(BlockType.FORET);
				lvl2.setFields(fields);
				lvl2.setType("LVL2");
				
			Evolution lvl3 = new Evolution("LVL3_Herb_Evolution");
				lvl3.setEnergyCost(Integer.parseInt(HerbConfig.getProperty("LVL3_EVOLCOST"))); 
				ArrayList<BlockType> fields2 = new ArrayList<BlockType>();
					fields2.add(BlockType.FORET);
				lvl3.setFields(fields2);
				lvl3.setType("LVL3");
		
		this.evolutions = evolutions;
		
		addComponent(new PlantRenderComponent(id+"_Render", new Image("res/graineSprite.png")));
	}

	public Herb(String id, 
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
		super(id+"_Herb", delay, range, energyDelay, cost, waterEvolQty, airProd, waterRegressQty, energyRegressQty, evolutions, imageReference, image);
	}

}
