package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;

public class WaterAbsorbedComponent extends Component {
	
	private Vector2f targetPosition;
	private int waterPosition;

	public WaterAbsorbedComponent(String string, Vector2f position, int waterPosition) {
		this.id = string;
		this.targetPosition = position;
		this.waterPosition = waterPosition;
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			//TODO ici il y a une grosse erreur de sortie de port�e
			if(((Wave)owner).water.get(waterPosition).getPosition().distance(targetPosition) < 2)
				((Wave)owner).water.remove(waterPosition);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
