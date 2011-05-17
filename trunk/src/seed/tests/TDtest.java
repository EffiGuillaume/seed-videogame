package seed.tests;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import seed.config.Configs;
import seed.field.Field;
import seed.interactions.Cursor;
import seed.units.Sunbeam;
import seed.interfaces.GameBoard;
import seed.interfaces.Ressource;
import seed.interfaces.SideBoard;

public class TDtest extends BasicGame {
	public static int GAMEBOARD_WIDTH = 700;
	public static int GAMEBOARD_HEIGHT = 600;
	public static int SIDEBOARD_WIDTH = 150;
	public static int SIDEBOARD_HEIGHT = 600;

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

		app.setDisplayMode(GAMEBOARD_WIDTH + SIDEBOARD_WIDTH, GAMEBOARD_HEIGHT, false);
		app.start();
	}

	public void init(GameContainer gc) throws SlickException {
		
		Field field = new Field("Field", GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
		field.init(gc);
		Configs.init();
		GameBoard.getInstance().init(gc, field);
		SideBoard.getInstance().init(gc,SIDEBOARD_WIDTH,SIDEBOARD_HEIGHT);


	}

	public void update(GameContainer gc, int delta) throws SlickException  {
		Cursor.getInstance().update(gc, null, delta);
		Sunbeam.getInstance().update(gc, null, delta);
		GameBoard.getInstance().update(gc, null, delta);
		Ressource.getInstance().update(gc, null, delta);
		SideBoard.getInstance().update(gc, null, delta);
	}

	public void render(GameContainer gc, Graphics gr) throws SlickException {
		GameBoard.getInstance().render(gc, null, gr);
		Ressource.getInstance().render(gc, null, gr);
		SideBoard.getInstance().render(gc, null, gr);
	}

}