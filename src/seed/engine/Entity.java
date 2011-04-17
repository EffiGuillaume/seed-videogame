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
 * Il consiste à considérer tous les éléments du jeu comme des entités ayant une méthode render() et une méthode update()
 * qui appellent ces mêmes méthodes dans une liste de Components préalablement associés à la classe.
 * 
 * Tout d'abord, une entité doit connaître sa position, la rotation et son échelle dans le monde. 
 * Deuxièmement, il y aura une liste des Components qui permettront de créer les fonctionnalité de l'entité. 
 * Troisièmement, les entités disposent de deux Components spécifiques dans le but d'accélérer l'exécution, 
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
