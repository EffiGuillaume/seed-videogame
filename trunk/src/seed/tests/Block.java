package seed.tests;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.engine.Entity;

public class Block extends Entity {
	static int BLOCK_SIZE = 50;
	boolean used;
	boolean showBorder = false;
	Image texture;
	
	public Block(String id) throws SlickException{
		super(id);
		used = false;
		texture = new Image("res/texture.png");
		this.AddComponent(new BlockRenderComponent(id+"Render",new Image("res/vertical.png"),new Image("res/horizontal.png")));
	}
	
	public Block(String id, Image block_texture,Image vertical_border, Image horizontal_border) throws SlickException{
		super(id);
		used = false;
		this.texture = block_texture;
		this.AddComponent(new BlockRenderComponent(id+"Render",vertical_border,horizontal_border));
	}
	
	public Block(String id, Image block_texture) throws SlickException{
		super(id);
		used = false;
		this.texture = block_texture;
		this.AddComponent(new BlockRenderComponent(id+"Render",new Image("res/vertical.png"),new Image("res/horizontal.png")));
	}
	
	public void setBorderVisibility(boolean show){
		showBorder = show;
	}
	
	public boolean isBorderVisible(){
		return showBorder;
	}
	
	public Image getTexture(){
		return texture;
	}
	public void setTexture(Image block_texture){
		texture = block_texture;
	}
}
