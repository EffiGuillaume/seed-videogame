package seed.interactions;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;

public class Absorber extends Entity {
	
	private boolean placed;
	private int delay;
	private float range;
	private int storage;
	
	private Vector2f imageSize;

	public Absorber(String id, int delay, float range, Image image) {
		super(id);
		this.placed = false;
		this.delay = delay;
		this.range = range;
		this.storage = 0;
		
		this.imageSize = new Vector2f(image.getWidth(), image.getHeight());
		
		addComponent(new AbsorptionComponent());
		addComponent(new PlacementComponent());
		addComponent(new AbsorberRenderComponent(id+"_Render", image));
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

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public int getStorage() {
		return storage;
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