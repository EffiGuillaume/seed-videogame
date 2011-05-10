package seed.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
import seed.interfaces.Ressource;

public class RessourceRenderComponent extends RenderComponent {

	
	public RessourceRenderComponent(String id) {
		super(id);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		try
		{
			if(owner instanceof Ressource)
			{
				gr.drawString(String.valueOf(((Ressource) owner).getAir()), 750, 0);
				gr.drawString(String.valueOf(((Ressource) owner).getPollution()), 750, 20);
			}
			else 
				throw new Exception("RessourceRenderComponent ne s'applique qu'à l'Entity Ressource");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
	}
}
