package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import parents.State;
import states.GameState;

public class Game implements Runnable {
	
	private Display display;
	private String title;
	private int width, height;
	
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
		
		GAME_STATE = new GameState(this);
	}

//	=========================================================================
	public void tick() {
		
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
	
}
