package seed.engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Guillaume
 * La classe Component suit le pattern du Entity Based Game que l'on peut trouver sur le wiki de Slick
 * @link http://slick.cokeandcode.com/wiki/doku.php?id=entity_tutorial
 * Il consiste à considérer tous les éléments du jeu comme des entités ayant une méthode render() et une méthode update()
 * qui appellent ces mêmes méthodes dans une liste de Components préalablement associés à la classe.
 * 
 * Le Component est une unité de fonctionnalité de l'entité qui peut ou non interagir avec d'autres Components. 
 * De préférence un Component travaille de manière indépendante.
 *
 */
public abstract class Component {

	protected String id;
	protected Entity owner;

	public String getId()
	{
		return id;
	}

	public void setOwnerEntity(Entity owner)
	{
		this.owner = owner;
	}

	public abstract void update(GameContainer gc, StateBasedGame sb, int delta);

}
