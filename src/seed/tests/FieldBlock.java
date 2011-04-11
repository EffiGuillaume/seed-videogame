package seed.tests;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class FieldBlock {
	int SQUARE_NUMBER_ROW = 800/Square.getSize();
	int SQUARE_NUMBER_COLUMNE = 600/Square.getSize();
	Image background;
	Square[][] grid = new Square[SQUARE_NUMBER_ROW][SQUARE_NUMBER_ROW];
	boolean show_grid=false;
	
	public void init(GameContainer gc) throws SlickException {
		background = new Image("res/TD.jpg");
		
		for(int i=0;i<SQUARE_NUMBER_ROW;i++){
			for(int j=0;j<SQUARE_NUMBER_COLUMNE;j++){
				grid[i][j] = new Square("square["+i+"]["+j+"]");
				Vector2f position = new Vector2f(i*Square.getSize(), j*Square.getSize());
				grid[i][j].setPosition(position);
			}
		}
	}
	
	public void setShowGrid(boolean show){
		show_grid = show;
	}
	
	public boolean getShowGrid(){
		return show_grid;
	}
	
	public void render(GameContainer gc, Graphics gr){
		background.draw(0,0);
		if(show_grid){
			for(int i=0;i<SQUARE_NUMBER_ROW;i++){
				for(int j=0;j<SQUARE_NUMBER_COLUMNE;j++){
					grid[i][j].render(gc, gr);
				}
			}
		}
	}
}
