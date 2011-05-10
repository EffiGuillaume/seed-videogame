package seed.units;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import seed.interactions.Absorber;
import seed.interactions.Evolution;
import seed.interactions.EvolveComponent;
import seed.interfaces.ProduceAirComponent;

public class Plant extends Absorber {
	
	protected int energy;
	protected int energyDelay;
	
	//champs d'une plante
	protected int cost;
	protected int waterEvolQty;
	/* /!\ le tableau d'évolution doit être trié suivant le coût d'énergie /!\ */
	protected ArrayList<Evolution> evolutions = new ArrayList<Evolution>();
	protected int airProd;
	protected int waterRegressQty;
	protected int energyRegressQty;

	public Plant(String id) throws SlickException {
		super(id);
		this.energy = 0;
		this.energyDelay = 100;
		this.cost = 0;
		this.waterEvolQty = 100;
		this.airProd = 0;
		this.waterRegressQty = 100;
		this.energyRegressQty = 100;
		this.evolutions = new ArrayList<Evolution>();
		
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
			ArrayList<Evolution> evolutions, 
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
		this.evolutions = evolutions;

		addComponent(new SunLitComponent());
		addComponent(new EvolveComponent());
		addComponent(new PlantRenderComponent(id+"_Render", image));
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

	public ArrayList<Evolution> getEvolutions() {
		return evolutions;
	}

	public void setEvolutions(ArrayList<Evolution> evolutions) {
		this.evolutions = evolutions;
	}
	
	public boolean isReadyToEvolve() {
		return (this.storage >= this.waterEvolQty);
	}

}
