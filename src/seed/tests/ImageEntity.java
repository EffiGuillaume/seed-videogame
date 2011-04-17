package seed.tests;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.engine.Entity;

public class ImageEntity extends Entity {
	public ImageEntity(String id, Image img) throws SlickException{
		super(id);
		this.addComponent(new ImageRenderComponent(id+"Render", img));
	}
}
