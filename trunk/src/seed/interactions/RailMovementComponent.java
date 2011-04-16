package seed.interactions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;

public class RailMovementComponent extends Component {
	
	float[] waypoint_x = {40, 140, 140, 220, 220, 80, 80, 340, 340, 420, 420};
	float[] waypoint_y = {140, 140, 60, 60, 240, 240, 320, 320, 100, 50, -20};
	
	private int nextWaypoint = 0;

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO bricolage en attendant les blocks "Lane", à changer quand ils seront implémentés
		try
		{
			if(owner instanceof Water)
			{
				int speed;
				Vector2f toReach;
				double water_x, water_y;
				double dist_x, dist_y;
				toReach = ((Water) owner).getToReach();
				water_x = owner.getPosition().getX();
				water_y = owner.getPosition().getY();
				speed = ((Water) owner).getSpeed();
				dist_x = toReach.getX() - water_x;
				dist_y = toReach.getY() - water_y;
				
				if ((Math.abs(dist_x)+Math.abs(dist_y))<1) {
					if(nextWaypoint >= waypoint_x.length)
					{
						nextWaypoint = 0;
						((Water)owner).setToReach(new Vector2f(0, 0));
						water_x = 0;
						water_y = 0;
					}
					else 
					{
						((Water)owner).setToReach(new Vector2f(waypoint_x[nextWaypoint], waypoint_y[nextWaypoint]));
						nextWaypoint++;
					}
				}
				double angle = Math.atan2(dist_y, dist_x);
				water_x = water_x + speed * 0.01 * delta * Math.cos(angle);
				water_y = water_y + speed * 0.01 * delta * Math.sin(angle);
				
				owner.setPosition(new Vector2f((float)water_x, (float)water_y));
				
				owner.setRotation((float)angle/(float)Math.PI*180-90);
			}
			else throw new Exception("Le RailMovementComponent ne s'applique qu'à l'Entity Water");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
