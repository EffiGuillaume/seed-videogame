package seed.interactions;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;

public class Plant extends Entity {
	
	private boolean placed;
	private int delay;
	private float range;
	
	private Vector2f imageSize;

	public Plant(String id, int delay, float range, Image image) {
		super(id);
		this.setPlaced(false);
		this.delay = delay;
		this.setRange(range);
		
		this.imageSize = new Vector2f(image.getWidth(), image.getHeight());
		
		addComponent(new WaterAbsorptionComponent());
		addComponent(new PlacementComponent());
		addComponent(new PlantRenderComponent(id+"_Render", image));
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}

	public boolean isPlaced() {
		return placed;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getRange() {
		return range;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getDelay() {
		return delay;
	}
	
	public Vector2f getCenter(){
		float x = getPosition().getX() + imageSize.getX()/2;
		float y = getPosition().getY() + imageSize.getY()/2;
		return new Vector2f(x,y);
	}

}