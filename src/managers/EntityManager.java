package managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import childs.Player;
import main.Game;
import parents.Entity;

public class EntityManager {
	
	private Game game;
	private Player player;
	private ArrayList<Entity> entities;
	
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Game game, Player player){
		this.game = game;
		this.player = player;
		
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick(){
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive()) {
				it.remove();
			}
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		player.postRender(g);
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
//	------------------ GETTERS & SETTERS ---------------------------------------------------------

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
//		System.out.println("#19 EntityManager getPlayer");
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
