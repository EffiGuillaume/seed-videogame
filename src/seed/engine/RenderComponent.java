package seed.engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
 
/**
 * @author Guillaume
 * Simple Component qui permet d'implémenter la méthode render().
 * voir : {@link http://slick.cokeandcode.com/wiki/doku.php?id=entity_tutorial}
 *
 */
public abstract class RenderComponent extends Component {

	public RenderComponent(String id)
	{
		this.id = id;
	}

	public abstract void render(GameContainer gc, StateBasedGame sb, Graphics gr);

}
