package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
import seed.tests.Block;

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
		float scale = owner.getScale();
 
		image.draw(pos.x, pos.y, scale);
		
		try
		{
			if(owner instanceof Plant)
			{
				float range = ((Plant) owner).getRange();
				circle.setColor(Color.red);
				
				if(!((Plant) owner).isPlaced())
				{
					circle.drawOval((pos.x + Block.BLOCK_SIZE/2) - range/2, (pos.y + Block.BLOCK_SIZE/2) - range/2, range, range);
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
