package seed;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class SeedMainv09 extends StateBasedGame  {
	public static final int MENU = 0;
	public static final int INGAME = 1;
    public static final int WIN = 2;
    public static final int LOSE = 3;
	
	public static int GAMEBOARD_WIDTH = 700;
	public static int GAMEBOARD_HEIGHT = 600;
	public static int SIDEBOARD_WIDTH = 150;
	public static int SIDEBOARD_HEIGHT = 600;

	Vector2f position = new Vector2f(0,0);

	public SeedMainv09(String title) {
		super(title);
		
		this.addState(new Menu(MENU));
		this.addState(new InGameState(INGAME));
        this.addState(new Win(WIN));
        this.addState(new GameOver(LOSE));
        this.enterState(MENU);
	}

	public SeedMainv09() {
		super("Seed v0.9");
	}

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SeedMainv09("Seed v0.9"));
		app.setDisplayMode(GAMEBOARD_WIDTH + SIDEBOARD_WIDTH, GAMEBOARD_HEIGHT, false);
		app.setUpdateOnlyWhenVisible(false);
		
		app.start();
		
	}


	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(INGAME).init(gc, this);
        this.getState(WIN).init(gc, this);
        this.getState(LOSE).init(gc, this);
		
	}

}
