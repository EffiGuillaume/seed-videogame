package seed.interfaces;

import org.newdawn.slick.Color;
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
			Graphics rectangle = new Graphics(); 
			if(owner instanceof Ressource)
			{
				gr.drawString("Air : "+String.valueOf(((Ressource) owner).getAir()), 710, 0);
				gr.drawString("Pol : "/*+String.valueOf(((Ressource) owner).getPollution())*/, 710, 20);
				if(((Ressource) owner).getPollution() > 10050)
					rectangle.setColor(Color.red);
				else if(((Ressource) owner).getPollution() < 300)
					rectangle.setColor(Color.blue);
				else rectangle.setColor(Color.orange);
				rectangle.fillRect(760, 25, 70, 10);
				rectangle.setColor(Color.gray);
				rectangle.fillRect(761, 26, ((float)((Ressource) owner).getPollution())*75f/12000f, 8);
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
