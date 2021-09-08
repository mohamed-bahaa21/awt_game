package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import managers.AssetsManager;
import managers.KeyManager;
import managers.MouseManager;
import orphans.GameCamera;
import parents.State;
import states.GameState;
import states.MenuState;

public class Game implements Runnable {
	
	private Display display;
	private String title;
	private static int width;
	private static int height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	public State GAME_STATE;
	public State MENU_STATE;
	
	private World world;
	
	private GameCamera gameCamera;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
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
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
//	=========================================================================
	public void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		AssetsManager.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		
		GAME_STATE = new GameState(this);
		MENU_STATE = new MenuState(this);
		State.setState(MENU_STATE);
	}

//	=========================================================================
	public void tick() {
		keyManager.tick();
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
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public Game getGame() {
		return this;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}