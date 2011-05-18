package seed.interactions;

import seed.engine.Entity;
 
/**
 * Classe Cursor
 * @author guillaume
 * Il s'agit d'un singleton (il n'y a qu'une seule instance du curseur, et elle doit être accessible de partout !)
 *
 */
public class Cursor extends Entity {
	
	private static final Cursor instance = new Cursor("cursor");
	
	private CursorState state;
	private boolean pressed = false;

	private Cursor(String id) {
		super(id);
		setState(CursorState.NONE);
		addComponent(new CursorInteractionComponent());
	}
	
	public final static Cursor getInstance() {
		return instance;
	}

	public void setState(CursorState state) {
		this.state = state;
	}

	public CursorState getState() {
		return state;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	public boolean isPressed(){
		return this.pressed;
	}
}