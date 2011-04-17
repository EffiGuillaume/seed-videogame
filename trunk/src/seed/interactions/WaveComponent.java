package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;

public class WaveComponent extends Component {
	int numberOfWater;
	int delay;
	int speed;
	int quantity;
	String imageRef;
	
	private int numberOfWaterCreated;
	private int timer;

	public WaveComponent(String string, int numberOfWater, int delay, int speed, int waterQuantity, String imageRef) {
		this.id = string;
		this.numberOfWater = numberOfWater;
		this.delay = delay;
		this.speed = speed;
		this.quantity = waterQuantity;
		this.imageRef = imageRef;
		
		this.numberOfWaterCreated = 0;
		this.timer = 0;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Wave)
			{
				if(numberOfWaterCreated < numberOfWater)
				{
					timer++;
				}
				if(timer>=delay)
				{
					((Wave)owner).water.add(new Water("Water"+numberOfWaterCreated, speed, quantity, new Image(imageRef)));
					
					numberOfWaterCreated++;
					timer = 0;
				}
			}
			else throw new Exception("Le WaveComponent ne s'applique qu'à l'Entity Wave");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
