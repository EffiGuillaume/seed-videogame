package seed.tests;
 
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.config.Configs;
import seed.field.Field;
import seed.interactions.Cursor;
import seed.interactions.CursorState;
import seed.units.Flower;
import seed.units.Herb;
import seed.units.Plant;
import seed.units.Sunbeam;
import seed.units.Wave;

public class TDtest extends BasicGame {
	static int SCREEN_WIDTH = 800;
	static int SCREEN_HEIGHT = 600;
	Field field = new Field("Field",SCREEN_WIDTH,SCREEN_HEIGHT);
	Vector2f position = new Vector2f(0,0);
	
//	Sunbeam.getInstance().set
	Plant plant = null;
	Wave water = null;
	
	int plant_x, plant_y;
	
	
	public TDtest(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public TDtest() {
		super("TD tests");
	}

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new TDtest());
		
		app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
		app.start();
	}

	public void init(GameContainer gc) throws SlickException {
		
		field.init(gc);
		
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
		Configs.init();
		
		/* test plante */
//		plant = new Plant("Plantest", 300, 200, 300, 100, 5, 100, 0, -5, new ArrayList<Evolution>(), 1, new Image("res/point.png"));
		plant = new Herb("test");
		
		/* test Water */
		water = new Wave("Watertest", 8, 500, 100, 1, "res/water.png");
	}

	public void update(GameContainer gc, int delta) throws SlickException  {
		Cursor.getInstance().update(gc, null, delta);
		Sunbeam.getInstance().update(gc, null, delta);
		
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

	public void render(GameContainer gc, Graphics gr) throws SlickException {
		field.render(gc,null, gr);
		water.render(gc, null, gr);
		plant.render(gc, null, gr);
		
		Sunbeam.getInstance().render(gc, null, gr);
	}

}