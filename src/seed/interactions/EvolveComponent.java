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
				if(((Plant) owner).isReadyToEvolve()){	//quantit� d'eau suffisant pour evoluer
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
							
							//TODO Aller chercher dans la base de donn�e les caract�ristiques de l'�volution � partir du nom
							// Pour �a, il y a juste � faire : 'Configs.getType(typeName).getProperty(evolName + "_DELAY")' par exemple pour avoir la caract�ristique 'delay' du niveau 'evolName' de la plante 'typeName'
							
							//TODO Modifier tout les caract�ristiques de la Plant(owner) suivant l'�volution
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
					
					//TODO Regression sur le meme principe que l'�volution
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
		/* /!\ le tableau d'�volution doit �tre tri� suivant le co�t d'�nergie /!\ */
		ArrayList<Evolution> evolutions = ((Plant)owner).getEvolutions();
		Iterator<Evolution> it = evolutions.iterator();
		Evolution evolution=null;
		while(it.hasNext()){
			Evolution curEvol = (Evolution) it.next();
			if(curEvol.isConstructibleOnField(field)){
				if(energy>curEvol.getEnergyCost())	//on a trouv� une evolution, on en cherche une autre meilleure
					evolution = curEvol;
				else
					return evolution;	//l'�volution suivant co�t plus que ce que l'on poss�de
			}
		}
		return evolution;
	}
}