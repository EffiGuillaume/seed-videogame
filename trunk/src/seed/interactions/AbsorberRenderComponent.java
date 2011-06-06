package seed.interactions;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
import seed.field.Block;

public class AbsorberRenderComponent extends RenderComponent {

	SpriteSheet image;
	Graphics circle;
	Animation anim;

	public AbsorberRenderComponent(String id, Image image) {
		super(id);

		this.image = new SpriteSheet(image, image.getWidth(), image.getWidth());
		this.circle = new Graphics();
		this.anim = new Animation(this.image, 100);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {		
		try
		{
			Vector2f pos = owner.getPosition();
			Vector2f center = ((Absorber)owner).getCenter();

			if(owner instanceof Absorber)
			{
				float range = ((Absorber) owner).getRange();
				circle.setColor(Color.blue);
				if(!((Absorber) owner).isPlaced())
				{
					if(Cursor.getInstance().getState() != CursorState.NOT_VISIBLE){
						anim.draw(pos.x - image.getWidth()/2 + Block.BLOCK_SIZE/2, pos.y - image.getWidth()/2 + Block.BLOCK_SIZE/2);
						circle.drawOval(center.getX() - range, center.getY() - range, range*2, range*2);
					}
				}
				else
				{
					image.getSubImage(0, image.getWidth()*(((Absorber)owner).getImageReference()-1), image.getWidth(), image.getWidth()).draw(pos.x - image.getWidth()/2 + Block.BLOCK_SIZE/2, pos.y - image.getWidth()/2 + Block.BLOCK_SIZE/2);
					if(Cursor.getInstance().getPosition().distance(((Absorber)owner).getCenter()) < Block.BLOCK_SIZE)
					{
						circle.drawOval(center.getX() - range, center.getY() - range, range*2, range*2);
						Graphics rectangle = new Graphics(); 
						rectangle.setColor(Color.blue);
						rectangle.fillRect(center.getX()+5, center.getY(), 10, -((Absorber)owner).getStorage());
//						gr.drawString(String.valueOf(((Absorber)owner).getStorage()), center.getX()+15, center.getY());
					}
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