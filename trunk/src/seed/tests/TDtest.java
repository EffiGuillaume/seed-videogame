package seed.tests;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class TDtest extends BasicGame {
	int SCREEN_WIDTH = 800;
	int SCREEN_HEIGHT = 600;
	Field field = new Field("Field",SCREEN_WIDTH,SCREEN_HEIGHT);
	Vector2f position = new Vector2f(0,0);
	
	Image plant;
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
		plant = new Image("res/point.png");
		field.changeBlockTexture(10,5,new Image("res/texture.png"));
	}

	public void update(GameContainer gc, int delta) throws SlickException  {
		Input input = gc.getInput();
		 if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			 field.setGridVisibility(!field.isGridVisible());
	     }
		 
		 plant_x = input.getMouseX()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
		 plant_y = input.getMouseY()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException {
		field.render(gc,null, gr);
		plant.draw(plant_x,plant_y);
	}

}
