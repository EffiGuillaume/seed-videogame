package seed.units;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.field.Block;
import seed.interactions.Absorber;
import seed.interactions.AbsorberRenderComponent;
import seed.interactions.Cursor;
import seed.interactions.CursorState;

public class PlantRenderComponent extends AbsorberRenderComponent {

	public PlantRenderComponent(String id, Image image) {
		super(id, image);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		super.render(gc, sb, gr);

		try
		{
			Vector2f center = ((Absorber)owner).getCenter();

			if(owner instanceof Plant)
			{
				if((!((Plant) owner).isPlaced()) || Cursor.getInstance().getPosition().distance(((Plant)owner).getCenter()) < Block.BLOCK_SIZE)
				{
					if(Cursor.getInstance().getState() != CursorState.NOT_VISIBLE){
						Graphics rectangle = new Graphics(); 
						if(((Plant)owner).getEnergy() > 0)
							rectangle.setColor(Color.yellow);
						else rectangle.setColor(Color.red);
						rectangle.fillRect(center.getX()+15, center.getY(), 10, -((Plant)owner).getEnergy());
//						gr.setColor(Color.yellow);
//						gr.drawString(String.valueOf(((Plant)owner).getEnergy()), center.getX()+15, center.getY()-15);
//						gr.setColor(Color.white);
					}
				}

			} else
				throw new Exception("PlantRenderComponent ne s'applique qu'à l'Entity Plant");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		super.update(gc, sb, delta);
	}

}
