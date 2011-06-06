package seed;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import seed.field.Field;
import seed.interfaces.GameBoard;
import seed.interfaces.Ressource;
import seed.interfaces.SideBoard;
import seed.units.Sunbeam;
import seed.units.Wave;

public class GameOver extends BasicGameState {
	
	int stateID = -1;
	
	Image playButton;
	Image gameover;
	Image credits;
	
	float playScale = 0.5f;
	float playX = 300;
	float playY = 400;
	
	public GameOver(int stateID ) 
	{
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		playButton = new Image("res/retry.png");
		gameover = new Image("res/gameover.png");
		credits = new Image("res/credits.png");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
			throws SlickException {
		GameBoard.getInstance().render(gc, sb, gr);
		SideBoard.getInstance().render(gc, sb, gr);
		Ressource.getInstance().render(gc, sb, gr);
		Sunbeam.getInstance().render(gc, sb, gr);
		gameover.draw(100,25);
		playButton.draw(playX,playY, playScale);
		credits.draw(2, 300);

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
			if(playX < 309)
				playX += 3;
			if(playY < 409)
				playY += 3;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				SideBoard.getInstance().destroySideBoard();
				Wave.level = 1;
				Wave.nbOfAbsorbable = 10;
				InGameState.music = new Music("res/music.ogg", true);
				InGameState.music.play(1,0.5f);
				Field field = new Field("Field", SeedMainv09.GAMEBOARD_WIDTH, SeedMainv09.GAMEBOARD_HEIGHT);
				field.init(gc);
				GameBoard.getInstance().init(gc, field);
				SideBoard.getInstance().init(gc,SeedMainv09.SIDEBOARD_WIDTH,SeedMainv09.SIDEBOARD_HEIGHT);

				//---Mise en place de l'ensoleillement
				Sunbeam.getInstance().setScope(150);

				//---mise en place des ressources
				Ressource.getInstance().setPollution(10000); // pollution de déŽpart
				Ressource.getInstance().setAir(350); // air de dŽépart
				
				
				sb.enterState(SeedMainv09.INGAME);
			}
		}else{
			if(playScale < 0.50f)
				playScale += 0.01f;
			if(playX > 300)
				playX -= 3;
			if(playY > 400)
				playY -= 3;
		}

	}

	@Override
	public int getID() {
		return stateID;
	}

}
