package seed.tests;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;
import seed.field.Field;
import seed.interactions.Cursor;
import seed.interactions.CursorState;
import seed.interfaces.Ressource;
import seed.units.Herb;
import seed.units.Plant;
import seed.units.Sunbeam;
import seed.units.Wave;

public class GameBoard extends Entity {
	static int width = 750;
	static int height = 600;

	private static final GameBoard instance = new GameBoard("gameBoard");

	public GameBoard(String id) {
		super(id);

	}

	public final static GameBoard getInstance() {
		return instance;
	}
	
	private Field field;
	
	/* --- Tests --- */
	Plant plant = null;
	Wave water = null;
	
	
	int plant_x, plant_y;

	public void init(GameContainer gc, Field field) throws SlickException{
		this.field = field;
		GameBoard.width = field.getScreenWidth();
		GameBoard.height = field.getScreenHeight();

		/* test chemin */

		//path
		ArrayList<Vector2f> path = new ArrayList<Vector2f>();
		path.add(new Vector2f(1,1));
		path.add(new Vector2f(3,1));
		path.add(new Vector2f(3,5));
		path.add(new Vector2f(5,5));
		path.add(new Vector2f(12,5));
		path.add(new Vector2f(12,10));
		path.add(new Vector2f(6,10));
		path.add(new Vector2f(6,12));
		path.add(new Vector2f(field.getNumRowBlock(),field.getNumColumnBlock()));
		field.createPath(path);

		/* test rayon du soleil*/
		Cursor.getInstance().setState(CursorState.SUN);
		Sunbeam.getInstance().setScope(150);

		/* test plante */
		//		plant = new Plant("Plantest", 300, 200, 300, 100, 5, 100, 0, -5, new ArrayList<Evolution>(), 1, new Image("res/point.png"));
		plant = new Herb("test");

		/* test Water */
		water = new Wave("Watertest", 1, 2, 500, 100, 1, "res/WaterSprite.png");

		/* test Ressource */
		Ressource.getInstance().setPollution(10000); // pollution de d�part
		Ressource.getInstance().setAir(400); // air de d��part

	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta)  {
//		Input input = gc.getInput();
//		 if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
//			 field.setGridVisibility(!field.isGridVisible());
//	     }
//		 
//		 plant_x = input.getMouseX()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
//		 plant_y = input.getMouseY()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
		 
		 plant.update(gc, null, delta);
		 water.update(gc, null, delta);
	}
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		field.render(gc,null, gr);
		water.render(gc, null, gr);
		plant.render(gc, null, gr);
		
		Sunbeam.getInstance().render(gc, null, gr);
		Ressource.getInstance().render(gc, null, gr);
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		GameBoard.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		GameBoard.height = height;
	}
	
	public static boolean inside(float x, float y)
	{
		if(x>=0 && x<width){
			if(y>=0 && y<height)
				return true;
		}
		return false;
	}

}
