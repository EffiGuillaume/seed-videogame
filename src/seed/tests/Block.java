package seed.tests;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.engine.Entity;

public class Block extends Entity {
	static int BLOCK_SIZE = 50;
	boolean used;
	
	public Block(String id) throws SlickException{
		super(id);
		used = false;
		this.AddComponent(new BlockRenderComponent(id+"Render", new Image("res/vertical.png"),new Image("res/horizontal.png")));
	}
	public Block(String id, Image vertical_border, Image horizontal_border) throws SlickException{
		super(id);
		used = false;
		this.AddComponent(new BlockRenderComponent(id+"Render", vertical_border,horizontal_border));
	}
}
