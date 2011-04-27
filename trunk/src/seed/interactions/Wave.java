package seed.interactions;
 
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;

public class Wave extends Entity {

	public ArrayList<Water> water;

	public Wave(String id, int numberOfWater, int delay, int speed, int waterQuantity, String imageRef) {
		super(id);
		
		water = new ArrayList<Water>();
		addComponent(new WaveComponent(id+"_Component", numberOfWater, delay, speed, waterQuantity, imageRef));
		
		//Utilisation du pattern Listener : on enregistre l'instance de Wave auprès de WaterAbsorptionComponent afin que ce dernier ait une référence sur l'instance
		WaterAbsorptionComponent.addListener(this);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		super.update(gc, sb, delta);
		
		for(int i = 0; i < water.size(); i++)
		{
			water.get(i).update(gc, sb, delta);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		super.render(gc, sb, gr);
		
		for(int i = 0; i < water.size(); i++)
		{
			water.get(i).render(gc, sb, gr);
		}
	}
}