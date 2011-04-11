package seed.tests;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Field {
	int screenWidth = 800;	//valeur par defaut 800
	int screenHeight = 600;	//valeur par defaut 600
	int blockRowNumber;
	int blockColumnNumber;
	
	ImageEntity background;
	Block[][] grid;
	boolean show_grid=false;
	
	public Field(){
		blockRowNumber = screenWidth/Block.BLOCK_SIZE;
		blockColumnNumber = screenHeight/Block.BLOCK_SIZE;
	}
	
	public Field(int screen_width,int screen_height){
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
				grid[i][j] = new Block("Block["+i+"]["+j+"]");
				Vector2f position = new Vector2f(i*Block.BLOCK_SIZE, j*Block.BLOCK_SIZE);
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
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr){
		background.render(gc, null, gr);
		if(show_grid){
			for(int i=0;i<blockRowNumber;i++){
				for(int j=0;j<blockColumnNumber;j++){
					grid[i][j].render(gc, sb, gr);
				}
			}
		}
	}
}
