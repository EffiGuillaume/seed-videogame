package seed.interactions;
 
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.field.Block;

public class WaterAbsorptionComponent extends Component {
	
	//Utilisation du pattern Listener : on enregistre l'instance d'une Wave auprès de WaterAbsorptionComponent afin que ce dernier ait une référence sur l'instance
	private static ArrayList<Wave> waveListener = new ArrayList<Wave>();
	
	public static void addListener(Wave wave){
		waveListener.add(wave);
	}
	
	private int timer = 0;

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Plant)
			{
				if(((Plant) owner).isPlaced())
				{
					if(timer < ((Plant)owner).getDelay() * 10)
					{
						timer++;
					}
					else
					{
						float plant_x, plant_y;
						plant_x = owner.getPosition().getX() + Block.BLOCK_SIZE/2;
						plant_y = owner.getPosition().getY() + Block.BLOCK_SIZE/2;
	
						for(int i = 0; i < waveListener.size(); i++) //on parcourt l'ensemble des objets Wave qui peut exister sur le terrain pour savoir si une entité Water est dans le rayon d'action de la Plant
						{
							Wave wave = waveListener.get(i);
							for(int j = 0; j < wave.water.size(); j++) //on parcourt la liste des Water qu'il y a dans une Wave
							{
								float water_x = wave.water.get(j).getPosition().getX();
								float water_y = wave.water.get(j).getPosition().getY();
	
								if(Math.sqrt(Math.pow(water_x - plant_x, 2) + Math.pow(water_y - plant_y, 2)) < ((Plant)owner).getRange()) //regarde si la goutte d'eau est à portée et absorbe si c'est le cas
								{
									absorb(wave, j);
									timer = 0;
									return;
								}
							}
						}
					}
				}
			}
			else
			{
				throw new Exception("WaterAbsorptionComponent ne s'applique qu'à l'Entity Plant");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			timer = 0;
		}
		
	}

	private void absorb(Wave wave, int position) {
		
		wave.water.get(position).setToReach(owner.getPosition());
		wave.addComponent(new WaterAbsorbedComponent("waterAbsorbedByPlant"+owner.getId(), owner.getPosition(), position));
		
	}

}