package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import childs.Player;
import childs.Rock;
import childs.Tree;
import managers.EntityManager;
import managers.ItemManager;
import parents.Tile;
import utils.Utils;

public class World {

	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	
	public World(Game game, String path){
		this.game = game;
		
		entityManager = new EntityManager(game, new Player(game, 100, 100));
		itemManager = new ItemManager(game);
		// Temporary entity code!
		for(int i=0; i<=20; i++) {
			entityManager.addEntity(new Tree(game, 64*18, 64*i));
		}
		entityManager.addEntity(new Tree(game, 64, 64*5));
		entityManager.addEntity(new Tree(game, 64*2, 64*4));
		entityManager.addEntity(new Rock(game, 64*3, 64*3));
		entityManager.addEntity(new Rock(game, 64*7, 64*5));
		entityManager.addEntity(new Rock(game, 64*7, 64*7));
		entityManager.addEntity(new Tree(game, 64*5, 64*8));
		
		loadWorld(path); //#18
		
		entityManager.getPlayer().setX(spawnX); //#19
		entityManager.getPlayer().setY(spawnY);
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[( x + y * width) + 4]);
			}
		}
	}
	
	public void tick(){
//		System.out.println("# World tick");
		entityManager.tick();
		itemManager.tick();
	}
	
	public void render(Graphics g){
		//
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
			}
		}
		// Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
//	------------ Getters & Setters ----------------------------------------------------------------
	
	public Tile getTile(int x, int y) {	
		//outside the map to be rock tile, so player can't go away
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		// tiles
		Tile t = Tile.tiles[tiles[x][y]];

		// if no tiles configured fill it with dirt
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}