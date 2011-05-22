package seed.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import seed.InGameState;
import seed.config.Configs;
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

	Image background;

	Image treeButton;
	Image mushroomButton;
	Image herbButton;
	Image flowerButton;
	Image unConstructible;

	Image pauseButton;

	float treeScale =  0.75f;
	float mushroomScale =  0.75f;
	float herbScale =  0.75f;
	float flowerScale =  0.75f;
	float scaleStep = 0.01f;

	float pauseScale = 0.50f;
	float playScale = 0.50f;
	

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
		this.pauseButton = new Image("res/pauseButton.png");
		this.background = new Image("res/Panel.png");
		this.treeButton = new Image("res/TreeButton.png");
		this.mushroomButton = new Image("res/MushroomButton.png");
		this.herbButton = new Image("res/HerbButton.png");
		this.flowerButton = new Image("res/FlowerButton.png");
		this.unConstructible = new Image("res/unConstructible.png");
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

		boolean insidePause = false;
		boolean insidePlay = false;

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
			}else if( ( mouseX >= GameBoard.getWidth()+40 && mouseX <= GameBoard.getWidth()+40+ pauseButton.getWidth()*pauseScale) &&
					( mouseY >= 6*height/7 && mouseY <= 6*height/7 + pauseButton.getHeight()*pauseScale) ){
				insidePause = true;
			}else if(Cursor.getInstance().isPressed() && SideBoard.inside(mouseX,mouseY)){
				GameBoard.getInstance().setToConstruct(null);
			}

			if(insideTree){
				if(treeScale < 0.78f)
					treeScale += scaleStep;

				if (Cursor.getInstance().isPressed()){
					Tree new_tree = new Tree(GameBoard.getNewPlantId());
					if(Ressource.getInstance().getAir() >= new_tree.getCost())
						GameBoard.getInstance().setToConstruct(new_tree);

				}
			}else{
				if(treeScale > 0.75f)
					treeScale -= scaleStep;
			}

			if(insideMushroom){
				if(mushroomScale < 0.78f)
					mushroomScale += scaleStep;

				if (Cursor.getInstance().isPressed()){
					//					Mushroom new_mushroom = new Mushroom(GameBoard.getNewPlantId());
					//					if(Ressource.getInstance().getAir() >= new_mushroom.getCost())
					//						GameBoard.getInstance().setToConstruct(new_mushroom);
				}
			}else{
				if(mushroomScale > 0.75f)
					mushroomScale -= scaleStep;
			}

			if(insideHerb){
				if(herbScale < 0.78f)
					herbScale += scaleStep;

				if (Cursor.getInstance().isPressed()){
					Herb new_herb = new Herb(GameBoard.getNewPlantId());
					if(Ressource.getInstance().getAir() >= new_herb.getCost())
						GameBoard.getInstance().setToConstruct(new_herb);
				}
			}else{
				if(herbScale > 0.75f)
					herbScale -= scaleStep;
			}


			if(insideFlower){
				if(flowerScale < 0.78f)
					flowerScale += scaleStep;

				if (Cursor.getInstance().isPressed()){
					Flower new_flower = new Flower(GameBoard.getNewPlantId());
					if(Ressource.getInstance().getAir() >= new_flower.getCost())
						GameBoard.getInstance().setToConstruct(new_flower);
				}
			}else{
				if(flowerScale > 0.75f)
					flowerScale -= scaleStep;
			}

			if(insidePause){
				if(pauseScale < 0.55f)
					pauseScale += scaleStep;

				if(!InGameState.pause){
					if (Cursor.getInstance().isPressed()){
						InGameState.pause = true;
						pauseButton = new Image("res/playButton.png");
					}
				}
				else{
					if (Cursor.getInstance().isPressed()){
						InGameState.pause = false;
						pauseButton = new Image("res/pauseButton.png");
					}
				}
			}else{
				if(pauseScale > 0.50f)
					pauseScale -= scaleStep;
			}
			
			if(insidePlay){
				if(playScale < 0.55f)
					playScale += scaleStep;

				if(InGameState.pause){
					if (Cursor.getInstance().isPressed()){
						InGameState.pause = false;
					}
				}
			}else{
				if(playScale > 0.50f)
					playScale -= scaleStep;
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics gr){
		background.draw(GameBoard.getWidth(), 0);
		pauseButton.draw(GameBoard.getWidth()+40, 6*height/7, pauseScale);
		herbButton.draw(GameBoard.getWidth()+width/5, height/7, herbScale);
		gr.drawString(Configs.getPlantConfig("HERB_LVL0").getProperty("COST"),GameBoard.getWidth()+width/5+10, height/7+10);
		if(Ressource.getInstance().getAir() < Integer.parseInt(Configs.getPlantConfig("HERB_LVL0").getProperty("COST")))
			unConstructible.draw(GameBoard.getWidth()+width/5+5, height/7+5, herbScale);

		flowerButton.draw(GameBoard.getWidth()+width/5, 2*height/7, flowerScale);
		gr.drawString(Configs.getPlantConfig("FLOWER_LVL0").getProperty("COST"),GameBoard.getWidth()+width/5+10, 2*height/7+10);
		if(Ressource.getInstance().getAir() < Integer.parseInt(Configs.getPlantConfig("FLOWER_LVL0").getProperty("COST")))
			unConstructible.draw(GameBoard.getWidth()+width/5+5, 2*height/7+5, herbScale);

		treeButton.draw(GameBoard.getWidth()+width/5, 3*height/7, treeScale);
		gr.drawString(Configs.getPlantConfig("TREE_LVL0").getProperty("COST"),GameBoard.getWidth()+width/5+10, 3*height/7+10);
		if(Ressource.getInstance().getAir() < Integer.parseInt(Configs.getPlantConfig("TREE_LVL0").getProperty("COST")))
			unConstructible.draw(GameBoard.getWidth()+width/5+5, 3*height/7+5, herbScale);

		mushroomButton.draw(GameBoard.getWidth()+width/5, 4*height/7, mushroomScale);
		//gr.drawString(Configs.getPlantConfig("MUSHROOM_LVL0").getProperty("COST"),GameBoard.getWidth()+width/5+10, 4*height/7+10);
		//if(Ressource.getInstance().getAir() < Integer.parseInt(Configs.getPlantConfig("MUSHROOM_LVL0").getProperty("COST")))
		//unConstructible.draw(GameBoard.getWidth()+width/5+10, 4*height/7+10, herbScale);
	}

	public static boolean inside(float x, float y){
		if(x>=GameBoard.getWidth() && x<GameBoard.getWidth()+width){
			if(y>=0 && y<height)
				return true;
		}
		return false;
	}
}
