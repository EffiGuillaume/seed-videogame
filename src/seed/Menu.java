package seed;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	int stateID = -1;

	public static boolean pause;

	public Menu(int stateID ) 
	{
		this.stateID = stateID;
	}
	
	Image background;
	Image playButton;
	Image sideBoard;
	Image intro;
	
	float playScale = 0.5f;
	float playX = 450;
	float playY = 300;

	@Override
	public void init(GameContainer gc, StateBasedGame arg1)
	throws SlickException {
		background = new Image("res/Accueil.png");
		playButton = new Image("res/play.png");
		sideBoard = new Image("res/Panel.png");
		intro = new Image("res/pitch.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
	throws SlickException {
		background.draw(0,0,0.5f);
		playButton.draw(playX,playY, playScale);
		sideBoard.draw(SeedMainv09.GAMEBOARD_WIDTH,0);
		intro.draw(0,125);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta)
	throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		boolean insidePlay = false;
		
		if( ( mouseX >= playX && mouseX <= playX + playButton.getWidth()*playScale ) &&
				( mouseY >= playY && mouseY <= playY + playButton.getHeight()*playScale ))
			insidePlay = true;
		
		if(insidePlay){
			if(playScale > 0.48f)
				playScale -= 0.01f;
			if(playX < 459)
				playX += 3;
			if(playY < 309)
				playY += 3;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				sb.enterState(SeedMainv09.INGAME);
			}
		}else{
			if(playScale < 0.50f)
				playScale += 0.01f;
			if(playX > 450)
				playX -= 3;
			if(playY > 300)
				playY -= 3;
		}

	}

	@Override
	public int getID() {
		return stateID;
	}

}
