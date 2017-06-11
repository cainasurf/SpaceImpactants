package States;
import java.awt.Graphics;

import Main.Handler;

public abstract class State {
	
	//Game State MANAGER
	private static State currentState = null;
	
	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		State.currentState = currentState;
	}

	//ABSTRACT STUFF
	protected Handler game;
	
	public State(Handler game){
		this.game = game;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
