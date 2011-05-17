package seed;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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

	public InGameState(int stateID ) 
	{
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame arg1)
	throws SlickException {
		Field field = new Field("Field", SeedMainv09.GAMEBOARD_WIDTH, SeedMainv09.GAMEBOARD_HEIGHT);
		field.init(gc);
		Configs.init();
		GameBoard.getInstance().init(gc, field);
		SideBoard.getInstance().init(gc,SeedMainv09.SIDEBOARD_WIDTH,SeedMainv09.SIDEBOARD_HEIGHT);
		
		//---Mise en place de l'ensoleillement
		Sunbeam.getInstance().setScope(150);

		//---mise en place des ressources
		Ressource.getInstance().setPollution(10000); // pollution de déŽpart
		Ressource.getInstance().setAir(350); // air de dŽépart

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
	throws SlickException {
		GameBoard.getInstance().render(gc, sb, gr);
		Ressource.getInstance().render(gc, sb, gr);
		SideBoard.getInstance().render(gc, sb, gr);
		Sunbeam.getInstance().render(gc, sb, gr);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
	throws SlickException {
		Cursor.getInstance().update(gc, sb, delta);
		Ressource.getInstance().update(gc, sb, delta);
		GameBoard.getInstance().update(gc, sb, delta);
		Sunbeam.getInstance().update(gc, sb, delta);
		SideBoard.getInstance().update(gc, sb, delta);
	}

	@Override
	public int getID() {
		return stateID;
	}

}
