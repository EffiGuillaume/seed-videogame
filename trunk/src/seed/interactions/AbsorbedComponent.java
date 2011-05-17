package seed.interactions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.units.Wave;

public class AbsorbedComponent extends Component {

	private Absorber absorber;
	private Wave wave;
	private int position;
	private boolean absorbed = false;

	public AbsorbedComponent(String string, Absorber absorber, Wave wave, int absorbablePosition) {
		this.id = string;
		this.absorber = absorber;
		this.wave = wave;
		this.position = absorbablePosition;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(!absorbed)
			{
				if(owner != null){
					if(owner.getPosition().distance(absorber.getPosition()) < 2)
					{
						absorbed = true;
						absorber.setStorage(absorber.getStorage()+1);
						wave.content.remove(position);
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