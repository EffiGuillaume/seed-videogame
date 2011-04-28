package seed.interactions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
import seed.field.Block;

public class AbsorberRenderComponent extends RenderComponent {

	Image image;
	Graphics circle;

	public AbsorberRenderComponent(String id, Image image) {
		super(id);
		this.image = image;
		this.circle = new Graphics();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {		
		try
		{
			Vector2f pos = owner.getPosition();
			Vector2f center = ((Absorber)owner).getCenter();
			float scale = owner.getScale();
	 
			image.draw(pos.x, pos.y, scale);
			
			if(owner instanceof Absorber)
			{
				float range = ((Absorber) owner).getRange();
				circle.setColor(Color.red);
				
				if((!((Absorber) owner).isPlaced()) || Cursor.getInstance().getPosition().distance(((Absorber)owner).getCenter()) < Block.BLOCK_SIZE)
				{
					circle.drawOval(center.getX() - range, center.getY() - range, range*2, range*2);
					gr.drawString(String.valueOf(((Absorber)owner).getStorage()), center.getX(), center.getY());
				}

			} else
				throw new Exception("AbsorberRenderComponent ne s'applique qu'à l'Entity Absorber");
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