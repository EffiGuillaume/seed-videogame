package seed.tests;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.RenderComponent;
 
public class BlockRenderComponent extends RenderComponent {
	
	Image verticalBorder;
	Image horizontalBorder;
 
	public BlockRenderComponent(String id, Image vertical_border, Image horizontal_border)
	{
		super(id);
		this.verticalBorder = vertical_border;
		this.horizontalBorder = horizontal_border;
	}
 
	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
		verticalBorder.draw(pos.getX(),pos.getY(),scale);
		verticalBorder.draw(pos.getX()+Block.BLOCK_SIZE,pos.getY(),scale);
		horizontalBorder.draw(pos.getX(),pos.getY(),scale);
		horizontalBorder.draw(pos.getX(),pos.getY()+Block.BLOCK_SIZE,scale);
	}
 
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		verticalBorder.rotate(owner.getRotation() - verticalBorder.getRotation());
		horizontalBorder.rotate(owner.getRotation() - horizontalBorder.getRotation());
	}
 
}
