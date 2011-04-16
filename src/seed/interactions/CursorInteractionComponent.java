package seed.interactions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;

public class CursorInteractionComponent extends Component {

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Input input = gc.getInput();
		
		owner.setPosition(new Vector2f(input.getMouseX(), input.getMouseY()));

	}

}
