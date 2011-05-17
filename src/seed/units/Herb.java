package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.config.Configs;
import seed.interactions.Evolution;

public class Herb extends Plant {
	
	public Herb(String id) throws SlickException {
		super(id);
		
		Configs.LoadPlantConfig("HERB_LVL0", this);

		
		addComponent(new PlantRenderComponent(id+"_Render", new Image("res/herbSprite.png")));
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
		super(id+"_Herb", delay, range, energyDelay, cost, waterEvolQty, airProd, waterRegressQty, energyRegressQty, imageReference, image);
	}

}
