package seed.interfaces;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import seed.engine.Entity;
import seed.field.Field;
import seed.units.Plant;
import seed.units.Sunbeam;
import seed.units.Wave;

public class GameBoard extends Entity {
	static int width = 750;
	static int height = 600;

	private static final GameBoard instance = new GameBoard("gameBoard");

	public GameBoard(String id) {
		super(id);
	}

	public final static GameBoard getInstance() {
		return instance;
	}

	private Field field;
	private Wave waves;	
	private Plant toConstruct;
	private ArrayList<Plant> plants;
	private static int nextId = 0;

	public void init(GameContainer gc, Field field) throws SlickException{
		this.field = field;
		GameBoard.width = field.getScreenWidth();
		GameBoard.height = field.getScreenHeight();
		GameBoard.nextId = 0;

		//!\Attention le chemin est ici fait � la main
		//path
		ArrayList<Vector2f> path = new ArrayList<Vector2f>();
		path.add(new Vector2f(1,1));
		path.add(new Vector2f(3,1));
		path.add(new Vector2f(3,5));
		path.add(new Vector2f(5,5));
		path.add(new Vector2f(12,5));
		path.add(new Vector2f(12,10));
		path.add(new Vector2f(6,10));
		path.add(new Vector2f(6,18));
		path.add(new Vector2f(18,12));
		path.add(new Vector2f(18,5));
		path.add(new Vector2f(23,5));
		path.add(new Vector2f(23,15));
		path.add(new Vector2f(18,15));
		path.add(new Vector2f(18,20));
		path.add(new Vector2f(field.getNumRowBlock(),field.getNumColumnBlock()));
		field.createPath(path);

		//---cr�ation du tableau des plantes
		plants = new ArrayList<Plant>();

		//---cr�ation de la premi�re vague
		//--------->Wave(name,		level,	numberOfAbsorbable,	delayOfApparition,	speed,	waterQuantity,	imageFilePath);
		waves = new Wave("1stWave",	1,		10, 				500, 				75, 	1,				"res/WaterSprite.png");

	}

	public void update(GameContainer gc, StateBasedGame sb, int delta)  {
		waves.update(gc, null, delta); //mise � jour de la vague
		for(int i = 0; i<plants.size(); i++){
			if(plants.get(i) != null)
				plants.get(i).update(gc, null, delta);	//mise � jour des plantes
		}
		if(toConstruct != null)
			toConstruct.update(gc, null, delta);
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		field.render(gc,null, gr);	//render du terrain
		waves.render(gc, null, gr);	//render des vagues
		for(int i = 0; i<plants.size(); i++){
			if(plants.get(i) != null){
				plants.get(i).render(gc, null, gr);	//render � jour des plantes
			}
		}
		if(toConstruct != null)
			toConstruct.render(gc, null, gr);
		Sunbeam.getInstance().render(gc, null, gr);
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		GameBoard.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		GameBoard.height = height;
	}

	public static boolean inside(float x, float y)
	{
		if(x>=0 && x<width){
			if(y>=0 && y<height)
				return true;
		}
		return false;
	}

	public Wave getWaves() {
		return waves;
	}

	public void setWaves(Wave waves) {
		this.waves = waves;
	}
	
	public int getPlantSize() {
		return plants.size();
	}
	
	public void removePlants(int key) {
		plants.remove(key);
	}
	
	public void addPlant(Plant plant) {
		boolean inserted = false;
		for(int i = 0; i<plants.size(); i++)
		{
			if(plants.get(i).getPosition().getY()>plant.getPosition().getY()){
				plants.add(i, plant);
				inserted = true;
				break;
			}
		}
		if(!inserted)
			plants.add(plant);
	}
	
	public void removePlant(Plant plant){
		String id = plant.getId();
		for(int i = 0; i <= plants.size(); i++){
			if(plants.get(i).getId().equalsIgnoreCase(id)){
				plants.remove(i);
				break;
			}
		}
	}
	
	public static String getNewPlantId()
	{
		nextId++;
		return ("Plant"+nextId);
	}

	public void setToConstruct(Plant toConstruct) {
		this.toConstruct = toConstruct;
	}

	public Plant getToConstruct() {
		return toConstruct;
	}

}
