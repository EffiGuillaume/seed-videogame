package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
import seed.field.Block;

public class PlantRenderComponent extends RenderComponent {

	Image image;
	Graphics circle;

	public PlantRenderComponent(String id, Image image) {
		super(id);
		this.image = image;
		this.circle = new Graphics();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f pos = owner.getPosition();
		Vector2f center = ((Plant)owner).getCenter();
		float scale = owner.getScale();
 
		image.draw(pos.x, pos.y, scale);
		
		try
		{
			if(owner instanceof Plant)
			{
				float range = ((Plant) owner).getRange();
				circle.setColor(Color.red);
				
				if((!((Plant) owner).isPlaced()) || Cursor.getInstance().getPosition().distance(((Plant)owner).getCenter()) < Block.BLOCK_SIZE)
				{
					circle.drawOval(center.getX() - range, center.getY() - range, range*2, range*2);
				}
					
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		image.rotate(owner.getRotation() - image.getRotation());

	}

}