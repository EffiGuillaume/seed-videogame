package seed.field;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.engine.Entity;

public class Block extends Entity {
	public static int MAX_NUMBER_TYPE = 10;
	public static int BLOCK_SIZE = 50;
	
	boolean used;
	boolean showBorder = false;
	BlockType[] types = new BlockType[MAX_NUMBER_TYPE];
	int nb_types = 0;
	
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
	
	public boolean isType(BlockType.Types t){
		int i;
		for(i = 0; i < nb_types && t != types[i].getType(); i++);
		if(i == nb_types)
			return false;
		return true;
	}
	
	public void addType(BlockType t){
		if(nb_types < MAX_NUMBER_TYPE && !isType(t.getType())){
			types[nb_types] = t;
			nb_types++;
		}	
	}
	
	public void removeType(BlockType.Types t){
		int i;
		for(i = 0; i < nb_types && t != types[i].getType(); i++);
		if(i != nb_types){
			types[i].setType(types[nb_types].getType());
			nb_types--;
		}
	}	
	
}
