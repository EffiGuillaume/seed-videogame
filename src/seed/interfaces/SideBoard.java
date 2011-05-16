package seed.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;
import seed.interactions.Cursor;
import seed.interfaces.Enemy;
import seed.interfaces.GameBoard;
import seed.units.Flower;
import seed.units.Herb;
import seed.units.Tree;

public class SideBoard extends Entity  {
	static int width = 150;
	static int height = 600;
	Enemy enemy = null;

	Image treeButton;
	Image mushroomButton;
	Image herbButton;
	Image flowerButton;

	float treeScale =  0.75f;
	float mushroomScale =  0.75f;
	float herbScale =  0.75f;
	float flowerScale =  0.75f;
	float scaleStep = 0.01f;

	private static final SideBoard instance = new SideBoard("sideBoard");

	public SideBoard(String id) {
		super(id);
	}

	public final static SideBoard getInstance() {
		return instance;
	}

	public void init(GameContainer gc, int width, int height) throws SlickException{
		/* test enemie */
		enemy = new Enemy("Enemie");
		SideBoard.width = width;
		SideBoard.height = height;
		this.treeButton = new Image("res/TreeButton.png");
		this.mushroomButton = new Image("res/MushroomButton.png");
		this.herbButton = new Image("res/HerbButton.png");
		this.flowerButton = new Image("res/FlowerButton.png");
	}

	public void init(GameContainer gc) throws SlickException{
		/* test enemie */
		enemy = new Enemy("Enemie");
		this.treeButton = new Image("res/TreeButton.png");
		this.mushroomButton = new Image("res/MushroomButton.png");
		this.herbButton = new Image("res/HerbButton.png");
		this.flowerButton = new Image("res/FlowerButton.png");
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta)  {
		enemy.update(gc, null, delta);

		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();

		boolean insideTree = false;
		boolean insideMushroom = false;
		boolean insideHerb = false;
		boolean insideFlower = false;
		try {
			
			if( ( mouseX >= GameBoard.getWidth()+width/5 && mouseX <= GameBoard.getWidth()+width/5 + treeButton.getWidth()*treeScale ) &&
					( mouseY >= 3*height/7 && mouseY <= 3*height/7 + treeButton.getHeight()*treeScale )){
				insideTree = true;
			}else if( ( mouseX >= GameBoard.getWidth()+width/5 && mouseX <= GameBoard.getWidth()+width/5+ mushroomButton.getWidth()*mushroomScale) &&
					( mouseY >= 4*height/7 && mouseY <= 4*height/7 + mushroomButton.getHeight()*mushroomScale) ){
				insideMushroom = true;
			}else if( ( mouseX >= GameBoard.getWidth()+width/5 && mouseX <= GameBoard.getWidth()+width/5+ mushroomButton.getWidth()*herbScale) &&
					( mouseY >= height/7 && mouseY <= height/7 + herbButton.getHeight()*herbScale) ){
				insideHerb = true;
			}else if( ( mouseX >= GameBoard.getWidth()+width/5 && mouseX <= GameBoard.getWidth()+width/5+ flowerButton.getWidth()*flowerScale) &&
					( mouseY >= 2*height/7 && mouseY <= 2*height/7 + flowerButton.getHeight()*flowerScale) ){
				insideFlower = true;
			}
	
			if(insideTree){
				if(treeScale < 0.78f)
					treeScale += scaleStep * delta;
	
				if ( input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ){
					
					GameBoard.removePlant(Cursor.getInstance().getOccupant());
					Tree new_tree = new Tree("");
					GameBoard.addPlant(new_tree);
					
				}
			}else{
				if(treeScale > 0.75f)
					treeScale -= scaleStep * delta;
			}
	
			if(insideMushroom){
				if(mushroomScale < 0.78f)
					mushroomScale += scaleStep * delta;
	
				if ( input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ){
					GameBoard.removePlant(Cursor.getInstance().getOccupant());
					//Mushroom new_mushroom = new Mushroom("");
					//GameBoard.addPlant(new_mushroom);
				}
			}else{
				if(mushroomScale > 0.75f)
					mushroomScale -= scaleStep * delta;
			}
	
			if(insideHerb){
				if(herbScale < 0.78f)
					herbScale += scaleStep * delta;
	
				if ( input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ){
					GameBoard.removePlant(Cursor.getInstance().getOccupant());
					Herb new_herb = new Herb("");
					GameBoard.addPlant( new_herb);
				}
			}else{
				if(herbScale > 0.75f)
					herbScale -= scaleStep * delta;
			}
	
	
			if(insideFlower){
				if(flowerScale < 0.78f)
					flowerScale += scaleStep * delta;
	
				if ( input.isMousePressed(Input.MOUSE_LEFT_BUTTON) ){
					GameBoard.removePlant(Cursor.getInstance().getOccupant());
					Flower new_flower = new Flower("");
					GameBoard.addPlant(new_flower);
				}
			}else{
				if(flowerScale > 0.75f)
					flowerScale -= scaleStep * delta;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics gr){
		herbButton.draw(GameBoard.getWidth()+width/5, height/7, herbScale);
		flowerButton.draw(GameBoard.getWidth()+width/5, 2*height/7, flowerScale);
		treeButton.draw(GameBoard.getWidth()+width/5, 3*height/7, treeScale);
		mushroomButton.draw(GameBoard.getWidth()+width/5, 4*height/7, mushroomScale);

	}

	public static boolean inside(float x, float y){
		if(x>=GameBoard.getWidth() && x<GameBoard.getWidth()+width){
			if(y>=0 && y<height)
				return true;
		}
		return false;
	}
}
