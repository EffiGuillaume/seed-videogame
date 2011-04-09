package seed.tests;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Plant {
	float x;
	float y;
	float range;
	float scale;
	boolean range_visiblility;
	Image picture_plant;
	Image picture_range;
	float base_range_scale = 0.01f;

	public float getX() {return x;}
	public float getY() {return y;}
	public float getRange(){return range;}
	public Image getPicture() {return picture_plant;}
	public Image getRangePicture() {return picture_range;}
	public float getScale() {return scale;}
	
	public void setX(float _x){ x = _x;}
	public void setY(float _y){ y = _y;}
	public void setRange(float _range){ range = _range;}
	public void setScale(float _scale) { scale = _scale;}
	public void setRangeVisibility(boolean visibility){ range_visiblility = visibility;}
	
	public Plant(float _x, float _y) throws SlickException {
		picture_plant = new Image("res/tree.png");
		x = _x;
		y = _y;
		range_visiblility = true;
		range = 300;
		scale = 1.0f;
		picture_range = new Image("res/point.png");
	}
	
	public Plant() throws SlickException {
		picture_plant = new Image("res/tree.png");
		x = 0;
		y = 0;
		range_visiblility = true;
		range = 300;
		scale = 1.0f;
		picture_range = new Image("res/point.png");
	}
	
	public void draw() throws SlickException {
		if(range_visiblility)
			picture_range.draw(x-range/2,y-range/2,range,range);
		picture_plant.draw(x-picture_plant.getWidth()/2,y-picture_plant.getHeight()/2,scale);
		//picture_range.setCenterOfRotation(picture_range.getWidth()/base_range_scale*range, picture_range.getHeight()/base_range_scale*range);
		
	}
}
