package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.config.Configs;
import seed.interactions.Evolution;

public class Tree extends Plant {

	public Tree(String id) throws SlickException {
		super(id);
		this.delay = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("DELAY"));
		this.range = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("RANGE"));
		this.storage = 0;
		this.energy = 0;
		this.energyDelay = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("ENERGYDELAY"));
		this.cost = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("COST"));
		this.waterEvolQty = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("WATEREVOLQTY"));
		this.airProd = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("AIRPROD"));
		this.waterRegressQty = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("WATERREGRESSQTY"));
		this.energyRegressQty = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("ENERGYREGRESSQTY"));
		this.imageReference = Integer.parseInt(Configs.getPlantConfig("TREE_LVL1").getProperty("IMAGEREFERENCE"));
		
		//TODO
//		ArrayList<Evolution> evolutions = new ArrayList<Evolution>();
//			Evolution lvl1 = new Evolution("LVL1_TREE_Evolution");
//			lvl1.setEnergyCost(Integer.parseInt(Configs.getType("TREE").getProperty("LVL1_EVOLCOST")));
//			ArrayList<BlockType> fields0 = new ArrayList<BlockType>();
//				fields0.add(BlockType.DESERT);
//				fields0.add(BlockType.FORET);
//			lvl1.setFields(fields0);
//			lvl1.setType("TREE");
//			lvl1.setEvol("LVL1");
//		
//			Evolution lvl2 = new Evolution("LVL2_TREE_Evolution");
//				lvl2.setEnergyCost(Integer.parseInt(Configs.getType("TREE").getProperty("LVL2_EVOLCOST")));
//				ArrayList<BlockType> fields = new ArrayList<BlockType>();
//					fields.add(BlockType.DESERT);
//					fields.add(BlockType.FORET);
//				lvl2.setFields(fields);
//				lvl2.setType("TREE");
//				lvl2.setEvol("LVL2");
//				
//			Evolution lvl3 = new Evolution("LVL3_TREE_Evolution");
//				lvl3.setEnergyCost(Integer.parseInt(Configs.getType("TREE").getProperty("LVL3_EVOLCOST"))); 
//				ArrayList<BlockType> fields2 = new ArrayList<BlockType>();
//					fields.add(BlockType.DESERT);
//					fields2.add(BlockType.FORET);
//				lvl3.setFields(fields2);
//				lvl3.setType("TREE");
//				lvl3.setEvol("LVL3");
//		
//		this.evolutions = evolutions;
		
		addComponent(new PlantRenderComponent(id+"_Render", new Image("res/graineSprite.png")));
	}

	public Tree(String id, 
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
		super(id+"_Tree", delay, range, energyDelay, cost, waterEvolQty, airProd, waterRegressQty, energyRegressQty, imageReference, image);
	}

}
