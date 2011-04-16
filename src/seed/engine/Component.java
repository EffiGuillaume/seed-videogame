package seed.engine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Guillaume
 * La classe Component suit le pattern du Entity Based Game que l'on peut trouver sur le wiki de Slick
 * @link http://slick.cokeandcode.com/wiki/doku.php?id=entity_tutorial
 * Il consiste � consid�rer tous les �l�ments du jeu comme des entit�s ayant une m�thode render() et une m�thode update()
 * qui appellent ces m�mes m�thodes dans une liste de Components pr�alablement associ�s � la classe.
 * 
 * Le Component est une unit� de fonctionnalit� de l'entit� qui peut ou non interagir avec d'autres Components. 
 * De pr�f�rence un Component travaille de mani�re ind�pendante.
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
