package seed.units;

import seed.engine.Entity;

/**
 * Classe Sunbeam
 * @author guillaume
 * Il s'agit d'un singleton (il n'y a qu'une seule instance de l'ensoleillement, et elle doit être accessible de partout !)
 *
 */
public class Sunbeam extends Entity {
	
	private static final Sunbeam instance = new Sunbeam("sunbeam");
	
	private float scope;

	private Sunbeam(String id) {
		super(id);
		this.scope = 50;
		
		addComponent(new SunLitRenderComponent(id+"_Render"));
	}
	
	public final static Sunbeam getInstance() {
		return instance;
	}

	public void setScope(float scope) {
		this.scope = scope;
	}

	public float getScope() {
		return scope;
	}

}