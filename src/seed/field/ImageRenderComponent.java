package seed.field;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
 
public class ImageRenderComponent extends RenderComponent {
 
	Image image;
 
	public ImageRenderComponent(String id, Image image)
	{
		super(id);
		this.image = image;
	}
 
	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
 
		image.draw(pos.x - image.getWidth()/4, pos.y - image.getHeight()/4, scale);
	}
 
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		image.rotate(owner.getRotation() - image.getRotation());
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setImage(Image i){
		image=i;
	}
}