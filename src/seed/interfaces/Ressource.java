package seed.interfaces;

import seed.engine.Entity;

public class Ressource extends Entity {
	int air = 0;
	int pollution = 0;
	
	private static final Ressource instance = new Ressource("ressource");
	
	private Ressource(String id) {
		super(id);
		addComponent(new RessourceRenderComponent("Ressource_Render"));
	}
	
	public final static Ressource getInstance() {
		return instance;
	}

	public int getAir() {
		return air;
	}

	public void setAir(int air) {
		this.air = air;
	}
	
	public void transformPoluIntoAir(int quantity) {
		this.air += quantity;
		this.pollution -= quantity;
		if(this.pollution < 0)
			this.pollution = 0;
	}
	
	public void transformAirIntoPolu(int quantity) {
		this.air -= quantity;
		this.pollution += quantity;
		if(this.air < 0)
			this.air = 0;
	}
	
	public void decAir(int decrementation) {
		this.air -= decrementation;
		if(this.air < 0)
			this.air = 0;
	}

	public int getPollution() {
		return pollution;
	}

	public void setPollution(int pollution) {
		this.pollution = pollution;
	}
}
