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
		Image texture = ((Block)owner).getTexture();
		float texture_scale = (float)Block.BLOCK_SIZE/texture.getWidth();
		texture.draw(pos.getX(),pos.getY(),texture_scale);
		if(((Block)owner).isBorderVisible()){
			float horizontal_border_scale = (float)(Block.BLOCK_SIZE+verticalBorder.getWidth())/horizontalBorder.getWidth();
			float vertical_border_scale = (float)(Block.BLOCK_SIZE+horizontalBorder.getHeight())/verticalBorder.getHeight();
			
			System.out.println(Block.BLOCK_SIZE);
			System.out.println(horizontalBorder.getWidth());
			
			horizontalBorder.draw(pos.getX(),pos.getY(),horizontal_border_scale);
			horizontalBorder.draw(pos.getX(),pos.getY()+Block.BLOCK_SIZE,horizontal_border_scale);
			verticalBorder.draw(pos.getX(),pos.getY(),vertical_border_scale);
			verticalBorder.draw(pos.getX()+Block.BLOCK_SIZE,pos.getY(),vertical_border_scale);
			
		}
	}
 
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		verticalBorder.rotate(owner.getRotation() - verticalBorder.getRotation());
		horizontalBorder.rotate(owner.getRotation() - horizontalBorder.getRotation());
	}
 
}
