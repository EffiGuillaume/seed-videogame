package seed.tests;
 
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.interactions.Cursor;
import seed.interactions.CursorState;
import seed.interactions.Plant;
import seed.interactions.Sunbeam;
import seed.interactions.Wave;

public class TDtest extends BasicGame {
	int SCREEN_WIDTH = 800;
	int SCREEN_HEIGHT = 600;
	Field field = new Field("Field",SCREEN_WIDTH,SCREEN_HEIGHT);
	Vector2f position = new Vector2f(0,0);
	
	Sunbeam sun = new Sunbeam("Sunbeam", 100);
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
		
		app.setDisplayMode(800, 600, false);
		app.start();
	}

	public void init(GameContainer gc) throws SlickException {
		field.init(gc);
		
		/* test rayon du soleil*/
		Cursor.getInstance().setState(CursorState.SUN);
		
		/* test plante */
		plant = new Plant("Plantest", 300, 200, new Image("res/point.png"));
		
		/* test Water */
		water = new Wave("Watertest", 8, 500, 10, 1, "res/water.png");
	}

	public void update(GameContainer gc, int delta) throws SlickException  {
		Cursor.getInstance().update(gc, null, delta);
//		Input input = gc.getInput();
//		 if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
//			 field.setGridVisibility(!field.isGridVisible());
//	     }
//		 
//		 plant_x = input.getMouseX()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
//		 plant_y = input.getMouseY()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
		 
		 plant.update(gc, null, delta);
		 
		 sun.update(gc, null, delta);
		 water.update(gc, null, delta);
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException {
		field.render(gc,null, gr);
		plant.render(gc, null, gr);
		sun.render(gc, null, gr);
		water.render(gc, null, gr);
	}

}
