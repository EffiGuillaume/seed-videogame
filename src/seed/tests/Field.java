package seed.tests;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;

public class Field  extends Entity{
	int screenWidth = 800;	//valeur par defaut 800
	int screenHeight = 600;	//valeur par defaut 600
	int blockRowNumber;
	int blockColumnNumber;
	
	ImageEntity background;
	Block[][] grid;
	boolean show_grid=false;
	
	public Field(String id){
		super(id);
		blockRowNumber = screenWidth/Block.BLOCK_SIZE;
		blockColumnNumber = screenHeight/Block.BLOCK_SIZE;
	}
	
	public Field(String id,int screen_width,int screen_height){
		super(id);
		screenWidth = screen_width;
		screenHeight = screen_height;
		blockRowNumber = screenWidth/Block.BLOCK_SIZE;
		blockColumnNumber = screenHeight/Block.BLOCK_SIZE;
	}
	
	public void init(GameContainer gc) throws SlickException {
		background = new ImageEntity("background",new Image("res/TD.jpg"));
		
		grid = new Block[blockRowNumber][blockColumnNumber];
		for(int i=0;i<blockRowNumber;i++){
			for(int j=0;j<blockColumnNumber;j++){
				grid[i][j] = new Block("Block["+i+"]["+j+"]",new Image("res/desert.png"));
				Vector2f position = new Vector2f(i*Block.BLOCK_SIZE, j*Block.BLOCK_SIZE);
				grid[i][j].setPosition(position);
			}
		}
	}
	
	public void setGridVisibility(boolean show){
		show_grid = show;
	}
	
	public boolean isGridVisible(){
		return show_grid;
	}
	
	public void changeBlockTexture(int x, int y, Image new_texture){
		if(x <= blockColumnNumber && y <= blockRowNumber && x > 0 && y > 0)
			grid[x-1][y-1].setTexture(new_texture);
	}
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr){
		background.render(gc, null, gr);
		for(int i=0;i<blockRowNumber;i++){
			for(int j=0;j<blockColumnNumber;j++){
				grid[i][j].setBorderVisibility(show_grid);
				grid[i][j].render(gc, sb, gr);
			}
		}
	}
}
