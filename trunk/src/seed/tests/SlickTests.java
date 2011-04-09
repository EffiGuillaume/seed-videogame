package seed.tests;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class SlickTests extends BasicGame {
	int nb_water = 10;
	Water[] water_array = new Water[nb_water];
	Image floor = null;
	float water_x = 40;
	float water_y = -20;
	float water_scale = 1.0f;
	int delay = 300; // delay before the next drop of water
	int new_water = 0;
	int nb_water_placed = 0;
	int to_reach = 0;
	int alpha = 0;
	Graphics cercle = null;
	boolean toplace = false;
	int cercle_x = 0;
	int cercle_y = 0;
	
	//plant
	Plant plant = null;
	boolean plant_placed = false;
	boolean can_be_placed = true;
	
	float[] waypoint_x = {40, 140, 140, 220, 220, 80, 80, 340, 340, 420, 420};
	float[] waypoint_y = {140, 140, 60, 60, 240, 240, 320, 320, 100, 50, -20};

	public SlickTests(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public SlickTests() {
		super("TD tests");
	}

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SlickTests());
		
		app.setDisplayMode(800, 600, false);
		app.start();

	}

	public void init(GameContainer arg0) throws SlickException {
		floor = new Image("res/TD.jpg");
		plant = new Plant();
		//water = new Image("res/water.png");
		/*for(int i=0; i < nb_water; i++){
			water_array[i] = new Water();
		}*/
		cercle = new Graphics(100,100);
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		float dist_x, dist_y,water_x,water_y,water_speed;
		int to_reach;
		
		//cr�ation d'eau
		if(nb_water_placed < nb_water)
			new_water++;
		if(new_water==delay){
			water_array[nb_water_placed] = new Water(40,-20);
			nb_water_placed++;
			new_water = 0;
		}
		
		//d�placement de l'eau
		for(int i=0; i < nb_water_placed; i++){
			to_reach = water_array[i].getToReach();
			water_x = water_array[i].getX();
			water_y = water_array[i].getY();
			water_speed = water_array[i].getSpeed();
			dist_x = waypoint_x[to_reach] - water_x;
			dist_y = waypoint_y[to_reach] - water_y;
			
			if ((Math.abs(dist_x)+Math.abs(dist_y))<1) {
				water_array[i].setReach(to_reach+1);
			}
			double angle = Math.atan2(dist_y, dist_x);
			water_array[i].setX((float) (water_x + water_speed * delta * Math.cos(angle)));
			water_array[i].setY((float) (water_y + water_speed * delta * Math.sin(angle)));
			water_array[i].getPicture().setRotation((float)angle/(float)Math.PI*180-90);
		}
		
		//Plante
		Input input = gc.getInput();
		if(!plant_placed){
			plant.setX(input.getMouseX());
			plant.setY(input.getMouseY());
		}

		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			if(can_be_placed)
				plant_placed=true;
			plant.setRangeVisibility(false);
		}

		
		if(plant_placed == true){
				toplace = true;
				cercle_x = input.getMouseX();
				cercle_y = input.getMouseY();
			//else toplace = false;
		}
		else toplace = false;
	}

	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		floor.draw(0,0);
		plant.draw();
		//water.draw(water_x, water_y, water_scale);
		for(int i=0;i<nb_water_placed;i++){
			water_array[i].draw();
		}
		
		if(toplace){
			cercle.setColor(Color.red);
			cercle.drawOval(cercle_x-25, cercle_y-25, 50, 50);
		}
		
		
	}

}
