package seed.interactions;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;
import seed.field.Block;

public class Absorber extends Entity {
	
	private boolean placed;
	protected int delay;
	protected float range;
	protected int storage;
	protected int imageReference;
	
	public Absorber(String id) throws SlickException {
		super(id);
		this.placed = false;
		this.delay = 100;
		this.range = 100;
		this.storage = 0;
		this.imageReference = 1;
		
		addComponent(new AbsorptionComponent());
		addComponent(new PlacementComponent());
		addComponent(new AbsorberRenderComponent(id+"_Render", new Image("res/point.png")));
	}

	public Absorber(String id, int delay, float range, int imageReference, Image image) {
		super(id);
		this.placed = false;
		this.delay = delay;
		this.range = range;
		this.storage = 0;
		this.imageReference = imageReference;
		
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
		float x = getPosition().getX() + Block.BLOCK_SIZE/2;
		float y = getPosition().getY() + Block.BLOCK_SIZE/2;
		return new Vector2f(x,y);
	}
	
	public int getImageReference() {
		return imageReference;
	}

	public void setImageReference(int imageReference) {
		this.imageReference = imageReference;
	}

}