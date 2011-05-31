package seed.interactions;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Component;
import seed.field.Block;
import seed.field.Field;
import seed.interfaces.GameBoard;
import seed.interfaces.Ressource;
import seed.units.Plant;

public class PlacementComponent extends Component {

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		try
		{
			if(owner instanceof Absorber)
			{
				if(!((Absorber) owner).isPlaced())
				{
					Input input = gc.getInput();
					int plant_x, plant_y;
					plant_x = input.getMouseX()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
					plant_y = input.getMouseY()/Block.BLOCK_SIZE * Block.BLOCK_SIZE;
					owner.setPosition(new Vector2f(plant_x, plant_y));
					
					if(Cursor.getInstance().isPressed()){
						if(GameBoard.inside(plant_x, plant_y)){
							if(Field.getInstance().isBlockFree(plant_x,plant_y)){
								if(Ressource.getInstance().getAir() >= ((Plant)owner).getCost()){
									GameBoard.getInstance().addPlant(GameBoard.getInstance().getToConstruct());
									GameBoard.getInstance().setToConstruct(null);
									((Absorber)owner).setPlaced(true);
									Field.getInstance().setBlockOccupant(plant_x, plant_y, owner);
									Ressource.getInstance().transformAirIntoPolu(((Plant)owner).getCost());
								}
							}
						}
					}
				}
			}
			else
			{
				throw new Exception("PlacementComponent ne s'applique qu'à l'Entity Absorber");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}