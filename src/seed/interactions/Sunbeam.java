package seed.interactions;
 
import seed.engine.Entity;

public class Sunbeam extends Entity {
	
	private float scope;

	public Sunbeam(String id, float scope) {
		super(id);
		this.scope = scope;
		
		addComponent(new SunLitRenderComponent(id+"_Render"));
	}

	public void setScope(float scope) {
		this.scope = scope;
	}

	public float getScope() {
		return scope;
	}

}