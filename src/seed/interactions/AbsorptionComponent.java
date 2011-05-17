package seed.interactions;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.field.Block;
import seed.units.Wave;

public class AbsorptionComponent extends Component {

	//Utilisation du pattern Listener : on enregistre l'instance d'une Wave auprès de AbsorptionComponent afin que ce dernier ait une référence sur l'instance
	private static ArrayList<Wave> waveListener = new ArrayList<Wave>();

	public static void addListener(Wave wave){
		waveListener.add(wave);
	}

	private int timer = 0;

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Absorber)
			{
				if(((Absorber) owner).isPlaced())
				{
					if(timer < ((Absorber)owner).getDelay() * 10 )
					{
						timer += delta;
					}
					else
					{
						float plant_x, plant_y;
						plant_x = owner.getPosition().getX() + Block.BLOCK_SIZE/2;
						plant_y = owner.getPosition().getY() + Block.BLOCK_SIZE/2;

						for(int i = 0; i < waveListener.size(); i++) //on parcourt l'ensemble des objets Wave qui peut exister sur le terrain pour savoir si une entité Absorbable est dans le rayon d'action de l' Absorber
						{
							Wave wave = waveListener.get(i);
							for(int j = 0; j < wave.content.size(); j++) //on parcourt la liste des Absorbables qu'il y a dans une Wave
							{
								float water_x = wave.content.get(j).getPosition().getX();
								float water_y = wave.content.get(j).getPosition().getY();

								if(Math.sqrt(Math.pow(water_x - plant_x, 2) + Math.pow(water_y - plant_y, 2)) < ((Absorber)owner).getRange()) //regarde si la goutte d'eau est à portée et absorbe si c'est le cas
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
				throw new Exception("WaterAbsorptionComponent ne s'applique qu'à l'Entity Absorber");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			timer = 0;
		}

	}

	private void absorb(Wave wave, int position) 
	{
		System.out.print("t la?");
		if(wave.content.get(position) != null){
			if(!wave.content.get(position).isAbsorbed())
			{
				wave.content.get(position).setAbsorbed(true);
				wave.content.get(position).setToReach(owner.getPosition());
				//			wave.addComponent(new AbsorbedComponent("absorbedByAbsorber"+owner.getId(), (Absorber)owner, position));
			}
			if(wave.content.get(position).getPosition().distance(owner.getPosition()) < 10)
			{
				((Absorber)owner).setStorage(((Absorber)owner).getStorage()+1);
				System.out.println("tabsorbe oui ou merde?");
				wave.content.remove(position);
				Wave.nbOfAbsorbable--;

				if(Wave.nbOfAbsorbable == 0)
					Wave.newWave();
			}

		}
	}

}