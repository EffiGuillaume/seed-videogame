package seed.interactions;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;
import seed.field.ImageRenderComponent;

public class Water extends Entity {
	
	private int speed;
	private int quantity;
	
	private Vector2f toReach;
	private Vector2f imageSize;

	public Water(String id, int speed, int quantity, Image image) {
		super(id);
		this.setSpeed(speed);
		this.setQuantity(quantity);
		this.setToReach(new Vector2f(0,0));
		
		setPosition(new Vector2f(0,0));
		this.imageSize = new Vector2f((float)image.getWidth(), (float)image.getHeight());
		
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

	public Vector2f getCenter() {
		float x = getPosition().getX() + imageSize.getX()/2;
		float y = getPosition().getY() + imageSize.getY()/2;
		return new Vector2f(x,y);
	}

}