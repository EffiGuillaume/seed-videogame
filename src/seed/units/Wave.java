package seed.units;
 
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;
import seed.interactions.Absorbable;
import seed.interactions.AbsorptionComponent;
import seed.interfaces.GameBoard;

/**
 * Classe Wave
 * @author guillaume
 * Il s'agit d'un conteneur d'objets absorbables, généralement des gouttes d'eau. 
 * C'est pourquoi il y a une boucle qui parcourt les éléments du conteneur pour invoquer le update et le render de chaque entité.
 *
 */
public class Wave extends Entity {

	public ArrayList<Absorbable> content;
	
	public static int nbOfAbsorbable;
	public static int level;

	public Wave(String id, int level, int numberOfAbsorbable, int delay, int speed, int absorbableQuantity, String imageRef) {
		super(id);
		
		this.content = new ArrayList<Absorbable>();
		Wave.nbOfAbsorbable = numberOfAbsorbable;
		Wave.level = level;
		addComponent(new WaveComponent(id+"_Component", numberOfAbsorbable, delay, speed, absorbableQuantity, imageRef));
		
		//Utilisation du pattern Listener : on enregistre l'instance de Wave auprès de AbsorptionComponent afin que ce dernier ait une référence sur l'instance
		AbsorptionComponent.addListener(this);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		super.update(gc, sb, delta);
		
		for(int i = 0; i < content.size(); i++)
		{
			if(content.get(i) != null)
				content.get(i).update(gc, sb, delta);
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		super.render(gc, sb, gr);
		
		for(int i = 0; i < content.size(); i++)
		{
			content.get(i).render(gc, sb, gr);
		}
	}

	public static void newWave() {
		System.out.println("NEW WAVE");
		GameBoard.getInstance().setWaves(new Wave((level+1)+"Wave", level+1, level*20, 500, 100, 1, "res/WaterSprite.png"));
	}
}