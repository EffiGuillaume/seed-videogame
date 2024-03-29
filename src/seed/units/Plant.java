package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.interactions.Absorber;
import seed.interactions.EvolveComponent;
import seed.interfaces.ProduceAirComponent;

public class Plant extends Absorber {
	
	protected int energy;
	protected int energyDelay;
	
	//champs d'une plante
	protected int cost;
	protected int waterEvolQty;
	/* /!\ le tableau d'�volution doit �tre tri� suivant le co�t d'�nergie /!\ */
	//protected ArrayList<Evolution> evolutions = new ArrayList<Evolution>();
	protected int airProd;
	protected int waterRegressQty;
	protected int energyRegressQty;
	protected ArrayList<String> evolutionHistory = new ArrayList<String>();

	protected String evolution;

	public Plant(String id) throws SlickException {
		super(id);
		this.energy = 0;
		this.energyDelay = 100;
		this.cost = 0;
		this.waterEvolQty = 100;
		this.airProd = 0;
		this.waterRegressQty = 100;
		this.energyRegressQty = 100;
		
		addComponent(new SunLitComponent());
		addComponent(new EvolveComponent());
		addComponent(new ProduceAirComponent());
		addComponent(new PlantRenderComponent(id+"_Render", new Image("res/point.png")));
	}
	
	public Plant(String id, 
			int delay, 
			float range, 
			int energyDelay, 
			int cost, 
			int waterEvolQty, 
			int airProd, 
			int waterRegressQty, 
			int energyRegressQty,
			int imageReference,
			Image image) {
		super(id, delay, range, imageReference, image);
		this.energy = 0;
		this.energyDelay = energyDelay;
		this.cost = cost;
		this.waterEvolQty = waterEvolQty;
		this.airProd = airProd;
		this.waterRegressQty = waterRegressQty;
		this.energyRegressQty = energyRegressQty;

		addComponent(new SunLitComponent());
		addComponent(new EvolveComponent());
		addComponent(new PlantRenderComponent(id+"_Render", image));
	}
	
	public String getEvolution() {
		return evolution;
	}

	public void setEvolution(String evolution) {
		this.evolution = evolution;
	}

	public int getEnergyDelay() {
		return energyDelay;
	}

	public void setEnergyDelay(int energyDelay) {
		this.energyDelay = energyDelay;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getWaterEvolQty() {
		return waterEvolQty;
	}

	public void setWaterEvolQty(int waterEvolQty) {
		this.waterEvolQty = waterEvolQty;
	}

	public int getAirProd() {
		return airProd;
	}

	public void setAirProd(int airProd) {
		this.airProd = airProd;
	}

	public int getWaterRegressQty() {
		return waterRegressQty;
	}

	public void setWaterRegressQty(int waterRegressQty) {
		this.waterRegressQty = waterRegressQty;
	}

	public int getEnergyRegressQty() {
		return energyRegressQty;
	}

	public void setEnergyRegressQty(int energyRegressQty) {
		this.energyRegressQty = energyRegressQty;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getEnergy() {
		return energy;
	}
	
	public boolean isReadyToEvolve() {
		return (this.storage >= this.waterEvolQty);
	}
	
	public String getLastEvolution() {
		if(evolutionHistory.size() > 0){
			String lastEvol = evolutionHistory.get(evolutionHistory.size()-1);
			evolutionHistory.remove(evolutionHistory.size()-1);
			return lastEvol;
		}
		return null;
	}
	
	public void addEvolutionHistory(String evolution) {
		evolutionHistory.add(evolution);
	}

}
