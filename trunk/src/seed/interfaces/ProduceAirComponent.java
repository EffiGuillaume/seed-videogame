package seed.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import seed.engine.Component;
import seed.units.Plant;

public class ProduceAirComponent extends Component {
	private int timer = 0;
	private int delay = 5000;	//possibilité de faire un delay d'émission d'air	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Plant)
			{
				if(((Plant) owner).isPlaced())
				{
					if(timer < delay )
					{
						timer += delta;
					}
					else
					{
						Ressource.getInstance().transformPoluIntoAir(((Plant) owner).getAirProd());
					}
				}
			}
			else
			{
				throw new Exception("ProduceAirComponent ne s'applique qu'à l'Entity Plant");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
