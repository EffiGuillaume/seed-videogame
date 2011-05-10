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
								System.out.println("Surprod !!");
							}
						}
						else {	//evolution
							String evolName = evolution.getEvol();
							String typeName = evolution.getType();
							System.out.println("Evolution !!! " + evolName);
							
							//TODO Aller chercher dans la base de donnée les caractéristiques de l'évolution à partir du nom
							// Pour ça, il y a juste à faire : 'Configs.getType(typeName).getProperty(evolName + "_DELAY")' par exemple pour avoir la caractéristique 'delay' du niveau 'evolName' de la plante 'typeName'
							
							//TODO Modifier tout les caractéristiques de la Plant(owner) suivant l'évolution
								// exemple : 
								((Plant)owner).setDelay(Integer.parseInt(Configs.getType(typeName).getProperty(evolName + "_DELAY")));
								((Plant)owner).setRange(Integer.parseInt(Configs.getType(typeName).getProperty(evolName + "_RANGE")));
								//fin exemple
							
							surProdActivate = false;
							((Plant)owner).setStorage(0);
							((Plant)owner).setEnergy(0);
						}
				}
				if(energyQty <= regressionPoint){
					System.out.println("Rregression!!");
					
					//TODO Regression sur le meme principe que l'évolution
					surProdActivate = false;
					((Plant)owner).setStorage(0);
					((Plant)owner).setEnergy(0);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public Evolution getEvolution(int energy, ArrayList<BlockType> field){
		/* /!\ le tableau d'évolution doit être trié suivant le coût d'énergie /!\ */
		ArrayList<Evolution> evolutions = ((Plant)owner).getEvolutions();
		Iterator<Evolution> it = evolutions.iterator();
		Evolution evolution=null;
		while(it.hasNext()){
			Evolution curEvol = (Evolution) it.next();
			if(curEvol.isConstructibleOnField(field)){
				if(energy>curEvol.getEnergyCost())	//on a trouvé une evolution, on en cherche une autre meilleure
					evolution = curEvol;
				else
					return evolution;	//l'évolution suivant coût plus que ce que l'on possède
			}
		}
		return evolution;
	}
}