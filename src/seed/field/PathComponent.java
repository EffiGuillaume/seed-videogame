package seed.field;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;

public class PathComponent extends Component{
	
	ArrayList<Vector2f> path = null;
	
	public PathComponent(String id, ArrayList<Vector2f> p){
		this.id = id;
		path = p;
	}
	
	public void init() throws SlickException{
		Iterator<Vector2f> it = path.iterator();
		Vector2f prev_coord = null;
		float dist_x, dist_y;
		while(it.hasNext()){
			Vector2f cur_coord = (Vector2f) it.next();
			if(prev_coord != null){
				dist_x =  cur_coord.getX() - prev_coord.getX();
				dist_y =  cur_coord.getY() - prev_coord.getY();
				while(!((Math.abs(dist_x)+Math.abs(dist_y))<1)){
					((Field)owner).changeBlockTexture((int)prev_coord.getX(),(int)prev_coord.getY(), new Image("res/path.png"));
					((Field)owner).addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(),new BlockType(BlockType.Types.CHEMIN));
					((Field)owner).addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(),new BlockType(BlockType.Types.NON_CONSTRUCTIBLE));
					double angle = Math.atan2(dist_y, dist_x);
					prev_coord.set((float) (prev_coord.getX() + Math.cos(angle)), (float) (prev_coord.getY() + Math.sin(angle)));
					dist_x =  cur_coord.getX() - prev_coord.getX();
					dist_y =  cur_coord.getY() - prev_coord.getY();
				}
				((Field)owner).changeBlockTexture((int)prev_coord.getX(),(int)prev_coord.getY(), new Image("res/path.png"));
				((Field)owner).addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(),new BlockType(BlockType.Types.CHEMIN));
				((Field)owner).addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(),new BlockType(BlockType.Types.NON_CONSTRUCTIBLE));
			}
			prev_coord = cur_coord;
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta){
	}
}