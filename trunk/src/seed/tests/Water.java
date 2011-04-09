package seed.tests;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Water {
	float x;
	float y;
	Image picture;
	boolean visible;
	int to_reach;
	float scale;
	float speed;
	
	public float getX() {return x;}
	public float getY() {return y;}
	public int getToReach(){return to_reach;}
	public Image getPicture() {return picture;}
	public float getScale() {return scale;}
	public float getSpeed() {return speed;}
	
	public void setX(float _x){ x = _x;}
	public void setY(float _y){ y = _y;}
	public void setReach(int _toreach){ to_reach = _toreach;}
	public void setScale(float _scale) { scale = _scale;}
	public void setspeed(float _speed){ speed = _speed;}
	
	public Water(float _x, float _y) throws SlickException {
		picture = new Image("res/water.png");
		x = _x;
		y = _y;
		visible = true;
		to_reach = 0;
		scale = 1.0f;
		speed = 0.1f;
	}
	
	public Water() throws SlickException {
		picture = new Image("res/water.png");
		x = 0;
		y = 0;
		visible = true;
		to_reach = 0;
		scale = 1.0f;
		speed = 0.1f;
	}
	
	public void draw() throws SlickException {
		picture.draw(x,y,scale);
	}
}
