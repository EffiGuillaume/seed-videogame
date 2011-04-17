package seed.interactions;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;

public class Water extends Entity {
	
	private int speed;
	private int quantity;
	
	private Vector2f toReach;

	public Water(String id, int speed, int quantity, Image image) {
		super(id);
		this.setSpeed(speed);
		this.setQuantity(quantity);
		this.setToReach(new Vector2f(0,0));
		
		setPosition(new Vector2f(0,0));
		
		addComponent(new RailMovementComponent());
		addComponent(new ImageRenderComponent(id+"_Render", image));
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setToReach(Vector2f toReach) {
		this.toReach = toReach;
	}

	public Vector2f getToReach() {
		return toReach;
	}

}
