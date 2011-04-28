package seed.units;

import org.newdawn.slick.Image;

import seed.interactions.Absorber;

public class Plant extends Absorber {
	
	private int energy;

	public Plant(String id, int delay, float range, Image image) {
		super(id, delay, range, image);
		this.setEnergy(0);
		
		addComponent(new SunLitComponent());
		addComponent(new PlantRenderComponent(id+"_Render", image));
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getEnergy() {
		return energy;
	}

}
