package seed.interactions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.interfaces.SideBoard;
 
public class CursorInteractionComponent extends Component {

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Input input = gc.getInput();
		
		if(SideBoard.inside(input.getMouseX(), input.getMouseY()))
			((Cursor)owner).setState(CursorState.NOT_VISIBLE);
		else{
			((Cursor)owner).setState(CursorState.NONE);
		}
		
		owner.setPosition(new Vector2f(input.getMouseX(), input.getMouseY()));
		

	}

}