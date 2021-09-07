package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import managers.AssetsManager;
import parents.State;
import states.GameState;

public class Game implements Runnable {
	
	private Display display;
	private String title;
	private static int width;
	private static int height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State GAME_STATE;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

//	=========================================================================	
	protected synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
//	=========================================================================
	@Override
	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
		
		stop();
	}
	
//	=========================================================================
	public void init() {
		display = new Display(title, width, height);
		AssetsManager.init();
		
		GAME_STATE = new GameState(this);
		State.setState(GAME_STATE);
	}

//	=========================================================================
	public void tick() {
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
//	=========================================================================
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		// start game graphics

		
		if(State.getState() != null) {
			State.getState().render(g);	
		}
		
		// end game graphics
		
		bs.show();
		g.dispose();
	}
	
//	=========================================================================
	protected synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	-------- GETTERS & SETTERS -------------------------------------------------------------
	
	public static int getWidth(){
		return width;
	}
	
	public static int getHeight(){
		return height;
	}

	public Game getGame() {
		return this;
	}
	
}