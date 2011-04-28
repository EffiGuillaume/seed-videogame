package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.field.Block;
import seed.field.Field;

public class RailMovementComponent extends Component {
	
	private int nextWaypoint = 0;

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Absorbable)
			{
				int speed;
				Vector2f toReach = ((Absorbable) owner).getToReach();
				double water_x, water_y;
				double dist_x, dist_y;
				water_x = owner.getPosition().getX();
				water_y = owner.getPosition().getY();
				speed = ((Absorbable) owner).getSpeed();
				dist_x = toReach.getX() - water_x;
				dist_y = toReach.getY() - water_y;
				
				if ((Math.abs(dist_x)+Math.abs(dist_y))<1) {
					if(nextWaypoint >= Field.getInstance().getPath().size())
					{
						nextWaypoint = 0;
						((Absorbable)owner).setToReach(new Vector2f(0, 0));
						water_x = 0;
						water_y = 0;
					}
					else 
					{
						Vector2f nextPosition = new Vector2f(Field.getInstance().getPath().get(nextWaypoint));
						nextPosition.set(nextPosition.getX() * Block.BLOCK_SIZE - Block.BLOCK_SIZE, nextPosition.getY() * Block.BLOCK_SIZE - Block.BLOCK_SIZE);
						((Absorbable)owner).setToReach(nextPosition);
						nextWaypoint++;
					}
				}
				double angle = Math.atan2(dist_y, dist_x);
				water_x = water_x + speed * 0.001 * delta * Math.cos(angle);
				water_y = water_y + speed * 0.001 * delta * Math.sin(angle);
				
				owner.setPosition(new Vector2f((float)water_x, (float)water_y));
				
				owner.setRotation((float)angle/(float)Math.PI*180-90);
			}
			else throw new Exception("Le RailMovementComponent ne s'applique qu'à l'Entity Absorbable");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}