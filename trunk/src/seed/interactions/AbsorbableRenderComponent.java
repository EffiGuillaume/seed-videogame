package seed.interactions;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
import seed.field.Block;

public class AbsorbableRenderComponent extends RenderComponent{

	SpriteSheet image;
	Animation anim;
	float angle;

	public AbsorbableRenderComponent(String id, Image image) {
		super(id);

		this.image = new SpriteSheet(image, image.getWidth(), image.getWidth());
		this.anim = new Animation(this.image, 100);
		this.angle = 0;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {		
		Vector2f pos = owner.getPosition();
		anim.getCurrentFrame().setRotation(angle);
		anim.draw(pos.x - image.getWidth()/2 + Block.BLOCK_SIZE/2, pos.y - image.getWidth()/2 + Block.BLOCK_SIZE/2);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		angle = owner.getRotation() - image.getRotation();

	}
}
