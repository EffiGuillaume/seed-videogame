package seed.tests;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;

public class Square extends Entity {
	static int SQUARE_SIZE = 50;
	boolean used;
	Image vertical = null;
	Image horizontal = null;
	
	public Square(String id) throws SlickException{
		super(id);
		used = false;
		vertical = new Image("res/vertical.png");
		horizontal = new Image("res/horizontal.png");
	}
	public Square() throws SlickException{
		super("test");
		used = false;
		vertical = new Image("res/vertical.png");
		horizontal = new Image("res/horizontal.png");
	}
	
	 public boolean isUsed(){
		 return used;
    }
	 
	 static public int getSize(){ 
		return SQUARE_SIZE;
	}
	 
	 public void render(GameContainer gc, Graphics gr){
		 Vector2f position = this.getPosition();
		 vertical.draw(position.getX(),position.getY());
		 vertical.draw(position.getX()+SQUARE_SIZE,position.getY());
		 horizontal.draw(position.getX(),position.getY());
		 horizontal.draw(position.getX(),position.getY()+SQUARE_SIZE);
	 }
}
