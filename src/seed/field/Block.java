package seed.field;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;

public class Block extends Entity {
	public static int BLOCK_SIZE = 50;
	
	boolean used;
	boolean showBorder = false;
	
	//types du block
	ArrayList<BlockType> types = new ArrayList<BlockType>();
	
	Entity occupant;
	
	public Block(String id) throws SlickException{
		super(id);
		used = false;
		this.addComponent(new ImageRenderComponent("TextureRender",new Image("res/texture.png")));
		this.addComponent(new BlockRenderComponent(id+"Render",new Image("res/vertical.png"),new Image("res/horizontal.png")));
	}
	
	public Block(String id, Image block_texture,Image vertical_border, Image horizontal_border) throws SlickException{
		super(id);
		used = false;
		this.addComponent(new ImageRenderComponent("TextureRender",block_texture));
		this.addComponent(new BlockRenderComponent(id+"Render",vertical_border,horizontal_border));
	}
	
	public Block(String id, Image block_texture) throws SlickException{
		super(id);
		used = false;
		this.addComponent(new ImageRenderComponent("TextureRender",block_texture));
		this.addComponent(new BlockRenderComponent(id+"Render",new Image("res/vertical.png"),new Image("res/horizontal.png")));
	}
	
	public void setBorderVisibility(boolean show){
		showBorder = show;
	}
	
	public boolean isBorderVisible(){
		return showBorder;
	}
	
	public Image getTexture(){
		return ((ImageRenderComponent)this.getComponent("TextureRender")).getImage();
	}
	public void setTexture(Image block_texture){
		((ImageRenderComponent)this.getComponent("TextureRender")).setImage(block_texture);
	}
	
	public boolean isType(BlockType t){
		Iterator<BlockType> it = types.iterator();
		while(it.hasNext()){
			BlockType type = (BlockType) it.next();
			if(type==t)
				return true;
		}
		return false;
	}
	
	public void addType(BlockType t){
		if(!isType(t)){
			types.add(t);
		}
	}
	
	public void removeType(BlockType t){
		types.remove(t);
	}

	public Vector2f getCenter() {
		float x = getPosition().getX() + BLOCK_SIZE/2;
		float y = getPosition().getY() + BLOCK_SIZE/2;
		return new Vector2f(x,y);
	}
	
	public boolean isFree() {
		return (!isType(BlockType.NON_CONSTRUCTIBLE) && occupant==null);
	}
	
	public void setOccupant(Entity e){
		occupant = e;
	}

	public ArrayList<BlockType> getTypes() {
		return types;
	}
	
}