package seed.engine;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
/**
 * @author Guillaume
 * La classe Entity suit le pattern du Entity Based Game que l'on peut trouver sur le wiki de Slick
 * @link http://slick.cokeandcode.com/wiki/doku.php?id=entity_tutorial
 * Il consiste � consid�rer tous les �l�ments du jeu comme des entit�s ayant une m�thode render() et une m�thode update()
 * qui appellent ces m�mes m�thodes dans une liste de Components pr�alablement associ�s � la classe.
 * 
 * Tout d'abord, une entit� doit conna�tre sa position, la rotation et son �chelle dans le monde. 
 * Deuxi�mement, il y aura une liste des Components qui permettront de cr�er les fonctionnalit� de l'entit�. 
 * Troisi�mement, les entit�s disposent de deux Components sp�cifiques dans le but d'acc�l�rer l'ex�cution, 
 * le Component de rendu (render) et le Component "heurtable" (collidable) (lorsqu'il y en a).
 *
 */
public abstract class Entity {

	String id;

	Vector2f position;
	float scale;
	float rotation;

	RenderComponent renderComponent = null;

	ArrayList<Component> components = null;

	public Entity(String id)
	{
		this.id = id;

		components = new ArrayList<Component>();

		position = new Vector2f(0,0);
		scale = 1;
		rotation = 0;
	}

	public void addComponent(Component component)
	{
		if(RenderComponent.class.isInstance(component))
			renderComponent = (RenderComponent)component;

		component.setOwnerEntity(this);
		components.add(component);
	}

	public Component getComponent(String id)
	{
		for(Component comp : components)
		{
			if ( comp.getId().equalsIgnoreCase(id) )
				return comp;
		}

		return null;
	}

	public Vector2f getPosition()
	{
		return position;
	}

	public float getScale()
	{
		return scale;
	}

	public float getRotation()
	{
		return rotation;
	}

	public String getId()
	{
		return id;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public void setRotation(float rotate) {
		rotation = rotate;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta)
	{
		for(Component component : components)
		{
			component.update(gc, sb, delta);
		}
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
	{
		if(renderComponent != null)
			renderComponent.render(gc, sb, gr);
	}
}
