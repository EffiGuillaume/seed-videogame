package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;

public class WaterAbsorbedComponent extends Component {
	
	private Vector2f targetPosition;
	private int waterPosition;
	private boolean absorbed = false;

	public WaterAbsorbedComponent(String string, Vector2f position, int waterPosition) {
		this.id = string;
		this.targetPosition = position;
		this.waterPosition = waterPosition;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(!absorbed)
			{
				if(((Wave)owner).water.get(waterPosition).getPosition().distance(targetPosition) < 2)
				{
					((Wave)owner).water.remove(waterPosition);
					absorbed = true;
					owner = new Wave("Watertest", 8, 500, 100, 1, "res/water.png");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}