package seed.tests;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class TDtest extends BasicGame {
	FieldBlock field = new FieldBlock();
	Vector2f position = new Vector2f(0,0);
	
	
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
	}

	public void update(GameContainer gc, int delta) throws SlickException  {
		Input input = gc.getInput();
		 if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			 field.setShowGrid(!field.getShowGrid());
	     }
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException {
		
		field.render(gc, gr);
	}

}
