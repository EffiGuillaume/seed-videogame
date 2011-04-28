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
				if(((Wave)owner).content.get(absorbablePosition).getPosition().distance(absorber.getPosition()) < 2)
				{
					absorber.setStorage(absorber.getStorage()+1);
					((Wave)owner).content.remove(absorbablePosition);
					absorbed = true;
					//TODO bricolage bizarre pour éviter le lancement d'une exception de sortie de portée
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