package seed.interfaces;

import seed.engine.Entity;

public class Ressource extends Entity {
	int air = 0;
	int pollution = 0;
	
	private static final Ressource instance = new Ressource("ressource");
	
	private Ressource(String id) {
		super(id);
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
	
	public void incAir(int incrementation) {
		this.air += air;
	}
	
	public void decAir(int decrementation) {
		this.air -= air;
	}

	public int getPollution() {
		return pollution;
	}

	public void setPollution(int pollution) {
		this.pollution = pollution;
	}
}
