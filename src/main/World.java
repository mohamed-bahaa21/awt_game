package main;

import java.awt.Graphics;

import utils.Utils;

public class World {
	
	private Game game;
	
	private String file;
	private String[] tokens;
	
	private int width, height;
	private int[][] tiles;
	private int spawnX, spawnY;

	public World(Game game, String path) {
		this.game = game;
		
		loadWorld(path);
	}
	
	private void loadWorld(String path){
		
		file = Utils.loadFileAsString(path);
		tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		tiles = new int[width][height];
		
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	}
}
