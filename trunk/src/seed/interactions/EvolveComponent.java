package seed.interactions;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import seed.config.Configs;
import seed.engine.Component;
import seed.field.BlockType;
import seed.field.Field;
import seed.interactions.Evolution;
import seed.interfaces.GameBoard;
import seed.units.Plant;

public class EvolveComponent extends Component{
	double surprodMultiplier = 1.5;
	boolean surProdActivate = false;
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		if(((Plant)owner).isPlaced()){
			int regressionPoint = ((Plant)owner).getEnergyRegressQty();
			int energyQty = ((Plant)owner).getEnergy();
			float plant_x = owner.getPosition().getX();
			float plant_y = owner.getPosition().getY();
			
			try
			{
				if(((Plant) owner).isReadyToEvolve()){	//quantité d'eau suffisant pour evoluer
						Evolution evolution = getEvolution(energyQty,Field.getInstance().getBlockType(plant_x,plant_y));
						if(evolution == null){ //mode surproduction
							if(!surProdActivate){
								surProdActivate = true;
								((Plant)owner).setAirProd((int)(((Plant)owner).getAirProd() * surprodMultiplier));
								System.out.println(owner.getId() +" passe en surproduction");
							}
						}
						else {	//evolution
							String evolName = evolution.getEvol();
							String typeName = evolution.getType();
							((Plant)owner).addEvolutionHistory(((Plant)owner).getEvolution());
							Configs.LoadPlantConfig(typeName+"_"+evolName,(Plant)owner);
							System.out.println(owner.getId() +" evolue en "+ ((Plant)owner).getEvolution());
							surProdActivate = false;
							((Plant)owner).setStorage(0);
							((Plant)owner).setEnergy(0);
						}
				}
				if(energyQty <= regressionPoint){
					String regression = ((Plant)owner).getLastEvolution();
					if(regression != null) {
						Configs.LoadPlantConfig(regression,(Plant)owner);
						surProdActivate = false;
						((Plant)owner).setStorage(0);
						((Plant)owner).setEnergy(0);
						System.out.println(owner.getId() +" regresse en "+((Plant)owner).getEvolution());
					}
					else {
						GameBoard.getInstance().removePlant(((Plant)owner));
						System.out.println(owner.getId() +" est mort ");
					}
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public Evolution getEvolution(int energy, ArrayList<BlockType> field){
		 
		// /!\ le tableau d'évolution doit être trié suivant le coût d'énergie /!\
		ArrayList<Evolution> evolutions = Configs.getEvolution(((Plant)owner).getEvolution());
		Evolution evolution=null;
		if(evolutions!=null){
			Iterator<Evolution> it = evolutions.iterator();
			while(it.hasNext()){
				Evolution curEvol = (Evolution) it.next();
				if(curEvol.isConstructibleOnField(field)){
					if(energy>=curEvol.getEnergyCost())	//on a trouvé une evolution, on en cherche une autre meilleure
						evolution = curEvol;
					else
						return evolution;	//l'évolution suivant coût plus que ce que l'on possède
				}
			}
		}
		return evolution;
	}
}