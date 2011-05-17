package seed.interactions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.units.Wave;

public class AbsorbedComponent extends Component {

	private Absorber absorber;
	private int absorbablePosition;
	private boolean absorbed = false;

	public AbsorbedComponent(String string, Absorber absorber, int absorbablePosition) {
		this.id = string;
		this.absorber = absorber;
		this.absorbablePosition = absorbablePosition;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(!absorbed)
			{
				if(((Wave)owner).content.get(absorbablePosition) != null){
					if(((Wave)owner).content.get(absorbablePosition).getPosition().distance(absorber.getPosition()) < 2)
					{
						absorbed = true;
						absorber.setStorage(absorber.getStorage()+1);
						((Wave)owner).content.remove(absorbablePosition);
						Wave.nbOfAbsorbable--;

						if(Wave.nbOfAbsorbable == 0)
							Wave.newWave();
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}