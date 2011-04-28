package seed.units;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.interactions.Absorbable;

public class WaveComponent extends Component {
	int numberOfAbsorbable;
	int delay;
	int speed;
	int quantity;
	String imageRef;
	
	private int numberOfAbsorbableCreated;
	private int timer;

	public WaveComponent(String string, int numberOfAbsorbable, int delay, int speed, int absorbableQuantity, String imageRef) {
		this.id = string;
		this.numberOfAbsorbable = numberOfAbsorbable;
		this.delay = delay;
		this.speed = speed;
		this.quantity = absorbableQuantity;
		this.imageRef = imageRef;
		
		this.numberOfAbsorbableCreated = 0;
		this.timer = 0;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Wave)
			{
				if(numberOfAbsorbableCreated < numberOfAbsorbable)
				{
					timer += delta;
				}
				if(timer >= delay)
				{
					((Wave)owner).content.add(new Absorbable("Water"+numberOfAbsorbableCreated, speed, quantity, new Image(imageRef)));
					
					numberOfAbsorbableCreated++;
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