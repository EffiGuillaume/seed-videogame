package seed.field;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;
/**
 * Classe Cursor
 * @author Thierry
 * Il s'agit d'un singleton (il n'y a qu'une seule instance du terrain, et elle doit Ítre accessible de partout !)
 *
 */
public class Field  extends Entity{
	int screenWidth = 800;	//valeur par defaut 800
	int screenHeight = 600;	//valeur par defaut 600
	int blockRowNumber;
	int blockColumnNumber;
	
	ImageEntity background;
	Block[][] grid;
	boolean show_grid=false;
	
	ArrayList<Vector2f> path;
	
	private static Field field  = null;

	public Field(String id){
		super(id);
		blockRowNumber = screenWidth/Block.BLOCK_SIZE;
		blockColumnNumber = screenHeight/Block.BLOCK_SIZE;
		
		field = this;
	}
	
	public Field(String id,int screen_width,int screen_height){
		super(id);
		screenWidth = screen_width;
		screenHeight = screen_height;
		blockRowNumber = screenWidth/Block.BLOCK_SIZE;
		blockColumnNumber = screenHeight/Block.BLOCK_SIZE;
		
		field = this;
	}
	
	public void init(GameContainer gc) throws SlickException {
		background = new ImageEntity("background",new Image("res/TD.jpg"));
		
		grid = new Block[blockRowNumber][blockColumnNumber];
		for(int i=0;i<blockRowNumber;i++){
			for(int j=0;j<blockColumnNumber;j++){
				grid[i][j] = new Block("Block["+i+"]["+j+"]",new Image("res/desert.png"));
				Vector2f position = new Vector2f(i*Block.BLOCK_SIZE, j*Block.BLOCK_SIZE);
				grid[i][j].setPosition(position);
				grid[i][j].addType(BlockType.DESERT);
			}
		}
		
	}
	
	public void createPath(ArrayList<Vector2f> p) throws SlickException {
		path = p;
		
		Iterator<Vector2f> it = path.iterator();
		Vector2f prev_coord = null;
		float dist_x, dist_y;
		while(it.hasNext()){
			Vector2f cur_coord = (Vector2f) it.next();
			if(prev_coord != null){
				dist_x =  cur_coord.getX() - prev_coord.getX();
				dist_y =  cur_coord.getY() - prev_coord.getY();
				while(!((Math.abs(dist_x)+Math.abs(dist_y))<1)){
					this.changeBlockTexture((int)prev_coord.getX(),(int)prev_coord.getY(), new Image("res/path.png"));
					this.addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(), BlockType.CHEMIN);
					this.addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(), BlockType.NON_CONSTRUCTIBLE);
					double angle = Math.atan2(dist_y, dist_x);
					prev_coord.set((float) (prev_coord.getX() + Math.cos(angle)), (float) (prev_coord.getY() + Math.sin(angle)));
					dist_x =  cur_coord.getX() - prev_coord.getX();
					dist_y =  cur_coord.getY() - prev_coord.getY();
				}
				this.changeBlockTexture((int)prev_coord.getX(),(int)prev_coord.getY(), new Image("res/path.png"));
				this.addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(), BlockType.CHEMIN);
				this.addBlockType((int)prev_coord.getX(),(int)prev_coord.getY(), BlockType.NON_CONSTRUCTIBLE);
			}
			prev_coord = cur_coord;
		}
		
	}
	
	public void setGridVisibility(boolean show){
		show_grid = show;
	}
	
	public boolean isGridVisible(){
		return show_grid;
	}
	
	public void changeBlockTexture(int x, int y, Image new_texture){
		if(x <= blockRowNumber && y <= blockColumnNumber && x > 0 && y > 0)
			grid[x-1][y-1].setTexture(new_texture);
	}
	
	public void addBlockType(int x, int y, BlockType new_type){
		if(x <= blockRowNumber && y <= blockColumnNumber && x > 0 && y > 0)
			grid[x-1][y-1].addType(new_type);
	}
	
	public void removeBlockType(int x, int y, BlockType type){
		if(x <= blockRowNumber && y <= blockColumnNumber && x > 0 && y > 0)
			grid[x-1][y-1].removeType(type);
	}
	
	public Block getBlock(float x, float y) throws Exception{
		int grid_x = (int)x/Block.BLOCK_SIZE;
		int grid_y = (int)y/Block.BLOCK_SIZE;
		if(!(grid_x <= blockRowNumber && grid_y <= blockColumnNumber && grid_x > 0 && grid_y > 0))
			throw new Exception("Error : coordonnée invalide");
		return grid[grid_x][grid_y];
			                    
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
	
	public int getNumRowBlock(){
		return blockRowNumber;
	}
	
	public int getNumColumnBlock(){
		return blockColumnNumber;
	}
	
	
	public ArrayList<Vector2f> getPath() {
		return path;
	}


	public static Field getInstance() {
		return field;
	}
	
	public boolean isBlockFree(float x, float y) throws Exception{
		int grid_x = (int)x/Block.BLOCK_SIZE;
		int grid_y = (int)y/Block.BLOCK_SIZE;
		if(!(grid_x <= blockRowNumber && grid_y <= blockColumnNumber && grid_x > 0 && grid_y > 0))
			throw new Exception("Error : coordonnée invalide");
		return grid[grid_x][grid_y].isFree();
	}
	
	public void setBlockOccupant(float x, float y, Entity e) throws Exception{
		int grid_x = (int)x/Block.BLOCK_SIZE;
		int grid_y = (int)y/Block.BLOCK_SIZE;
		if(!(grid_x <= blockRowNumber && grid_y <= blockColumnNumber && grid_x > 0 && grid_y > 0))
			throw new Exception("Error : coordonnée invalide");
		grid[grid_x][grid_y].setOccupant(e);
	}
}