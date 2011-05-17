package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.config.Configs;
import seed.interactions.Evolution;

public class Flower extends Plant {
	
	public Flower(String id) throws SlickException {
		super(id);
		this.evolution = "FLOWER_LVL1";
		this.delay = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("DELAY"));
		this.range = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("RANGE"));
		this.storage = 0;
		this.energy = 0;
		this.energyDelay = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("ENERGYDELAY"));
		this.cost = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("COST"));
		this.waterEvolQty = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("WATEREVOLQTY"));
		this.airProd = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("AIRPROD"));
		this.waterRegressQty = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("WATERREGRESSQTY"));
		this.energyRegressQty = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("ENERGYREGRESSQTY"));
		this.imageReference = Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL1").getProperty("IMAGEREFERENCE"));
		
		addComponent(new PlantRenderComponent(id+"_Render", new Image("res/flowerSprite.png")));
	}

	public Flower(String id, 
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
		super(id+"_Flower", delay, range, energyDelay, cost, waterEvolQty, airProd, waterRegressQty, energyRegressQty, imageReference, image);
	}
}
