package seed.field;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.engine.Entity;

public class Block extends Entity {
	public static int MAX_NUMBER_TYPE = 10;
	public static int BLOCK_SIZE = 50;
	
	boolean used;
	boolean showBorder = false;
	
	//types du block
	BlockType[] types = new BlockType[MAX_NUMBER_TYPE];
	int nb_types = 0;
	
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
		int i;
		for(i = 0; i < nb_types && t != types[i]; i++);
		if(i == nb_types)
			return false;
		return true;
	}
	
	public void addType(BlockType t){
		if(nb_types < MAX_NUMBER_TYPE && !isType(t)){
			types[nb_types] = t;
			nb_types++;
		}	
	}
	
	public void removeType(BlockType t){
		int i;
		for(i = 0; i < nb_types && t != types[i]; i++);
		if(i != nb_types){
			types[i] = types[nb_types];
			nb_types--;
		}
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
	
}