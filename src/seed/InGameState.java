package seed;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import seed.config.Configs;
import seed.field.Field;
import seed.interactions.Cursor;
import seed.interfaces.GameBoard;
import seed.interfaces.Ressource;
import seed.interfaces.SideBoard;
import seed.units.Sunbeam;

public class InGameState extends BasicGameState {

	int stateID = -1;

	public static boolean pause;
	
	public static Music music;

	public InGameState(int stateID ) 
	{
		this.stateID = stateID;
		InGameState.pause = false;
	}

	public void init(GameContainer gc, StateBasedGame arg1)
	throws SlickException {
		gc.setMouseCursor(new Image("res/cursor.png"), 25, 25);
		Field field = new Field("Field", SeedMainv09.GAMEBOARD_WIDTH, SeedMainv09.GAMEBOARD_HEIGHT);
		field.init(gc);
		Configs.init();
		InGameState.music = new Music("res/music.ogg");
		InGameState.music.play(1,0.5f);
		GameBoard.getInstance().init(gc, field);
		SideBoard.getInstance().init(gc,SeedMainv09.SIDEBOARD_WIDTH,SeedMainv09.SIDEBOARD_HEIGHT);

		//---Mise en place de l'ensoleillement
		Sunbeam.getInstance().setScope(150);

		//---mise en place des ressources
		Ressource.getInstance().setPollution(10000); // pollution de déŽpart
		Ressource.getInstance().setAir(350); // air de dŽépart

	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
	throws SlickException {
		GameBoard.getInstance().render(gc, sb, gr);
		SideBoard.getInstance().render(gc, sb, gr);
		Ressource.getInstance().render(gc, sb, gr);
		Sunbeam.getInstance().render(gc, sb, gr);
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta)
	throws SlickException {
		if(pause){
			Cursor.getInstance().update(gc, sb, delta);
			SideBoard.getInstance().update(gc, sb, delta);
		}
		else{
			Cursor.getInstance().update(gc, sb, delta);
			Ressource.getInstance().update(gc, sb, delta);
			GameBoard.getInstance().update(gc, sb, delta);
			Sunbeam.getInstance().update(gc, sb, delta);
			SideBoard.getInstance().update(gc, sb, delta);
			
			if(Ressource.getInstance().getAir() <= 0)
				sb.enterState(SeedMainv09.LOSE);
			if(Ressource.getInstance().getPollution() <= 100)
				sb.enterState(SeedMainv09.WIN);
		}
	}

	@Override
	public int getID() {
		return stateID;
	}

}
