package seed.units;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.interactions.Cursor;
import seed.interactions.CursorState;

public class SunLitComponent extends Component {
	
	private int timer = 0;

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Plant)
			{
				if(((Plant) owner).isPlaced())
				{
					if(Cursor.getInstance().getState() == CursorState.SUN) // on n'éclaire que si le curseur est dans l'état SUN
					{
						if(((Plant)owner).getCenter().distance(Sunbeam.getInstance().getPosition()) < Sunbeam.getInstance().getScope()/2)
						{
							if(timer < ((Plant)owner).getDelay() * 10 )
							{
								timer += delta;
							}
							else
							{
								((Plant)owner).setEnergy(((Plant)owner).getEnergy() + 1);
								
								timer = 0;
							}
						}
					}
				}
			}
			else
			{
				throw new Exception("SunLitComponent ne s'applique qu'à l'Entity Plant");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			timer = 0;
		}

	}

}
