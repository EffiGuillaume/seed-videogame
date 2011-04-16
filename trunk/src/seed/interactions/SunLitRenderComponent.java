package seed.interactions;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;

public class SunLitRenderComponent extends RenderComponent {

	public SunLitRenderComponent(String id) {
		super(id);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f position = owner.getPosition();
		float scope;
		
		if(Cursor.getInstance().getState() == CursorState.SUN) // on n'éclaire que si le curseur est dans l'état SUN
		{
			try
			{
				if(owner instanceof Sunbeam)
					scope = ((Sunbeam)owner).getScope();
				else throw new Exception("SunLitComponent ne peut être associé qu'à une Entity Sunbeam");
				Graphics circle = new Graphics();
				circle.setColor(new Color(255,255,0,50));
				circle.fillOval(position.x - scope/2, position.y - scope/2, scope, scope);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		owner.setPosition(Cursor.getInstance().getPosition());

	}

}
