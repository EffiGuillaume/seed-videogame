package seed.units;

import org.newdawn.slick.Image;

import seed.interactions.Absorber;

public class Plant extends Absorber {
	
	protected int energy;
	protected int energyDelay;
	
	//champs d'une plante
	protected int cost;
	protected int waterEvolQty;
	//TODO protected ArrayList<Evolution> evolutions;
	protected int airProd;
	protected int waterRegressQty;
	protected int energyRegressQty;
	
	public Plant(String id, int delay, float range, Image image) {
		super(id, delay, range, image);
		this.setEnergy(0);
		
		addComponent(new SunLitComponent());
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

}
