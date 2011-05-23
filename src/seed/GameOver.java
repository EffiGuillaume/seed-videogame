package seed;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import seed.interfaces.GameBoard;
import seed.interfaces.Ressource;
import seed.interfaces.SideBoard;
import seed.units.Sunbeam;

public class GameOver extends BasicGameState {
	
	int stateID = -1;
	
	public GameOver(int stateID ) 
	{
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
			throws SlickException {
		GameBoard.getInstance().render(gc, sb, gr);
		SideBoard.getInstance().render(gc, sb, gr);
		Ressource.getInstance().render(gc, sb, gr);
		Sunbeam.getInstance().render(gc, sb, gr);
		gr.drawString("Désolé, vous avez perdu !", 250, 250);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
