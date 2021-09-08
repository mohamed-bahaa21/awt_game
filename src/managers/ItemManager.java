package managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import childs.Player;
import childs.Tree;
import main.Game;
import orphans.Item;

public class ItemManager {
	
	private Game game;
	private ArrayList<Item> items;
	private EntityManager entityManager;
	
	public ItemManager(Game game){
		this.game = game;
		items = new ArrayList<Item>();
	}
	
	public void tick(){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item i = it.next();
			i.tick();
			if(i.isPickedUp()) {
				it.remove();				
			}
				
		}
	}
	
	public void render(Graphics g){
		for(Item i : items)
			i.render(g);
	}
	
	public void addItem(Item i){
		i.setGame(game);
		items.add(i);
	}
	
//	 =========== Getters and Setters =======================================

	public Game getgame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
