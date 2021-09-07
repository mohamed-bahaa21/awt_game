package parents;

import java.awt.Graphics;

import main.Game;

public abstract class State {

	protected Game game;
	private static State STATE = null;
	
	public State(Game game){
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
//	------------------- Getters & Setters ------------------------------------------------------
	
	public static State getState(){
		return STATE;
	}
	
	public static void setState(State state){
		STATE = state;
	}
}
