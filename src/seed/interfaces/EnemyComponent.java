package seed.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import seed.engine.Component;

public class EnemyComponent extends Component {
	private int timerDelay = 0;
	private int timerEvolution = 0;
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Enemy)
			{
				if(timerEvolution < ((Enemy) owner).getEvolutionDelay())
				{
					timerEvolution += delta;
					if(timerDelay < ((Enemy) owner).getPollutionProdDelay())
					{
						timerDelay += delta;
					}
					else
					{
						Ressource.getInstance().transformAirIntoPolu(((Enemy) owner).getPollutionProdQty());
						timerDelay = 0;
					}
				}
				else {
					((Enemy) owner).evolve();
					timerEvolution = 0;
				}
			}
			else
			{
				throw new Exception("EnemyComponent ne s'applique qu'à l'Entity Enemy");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
