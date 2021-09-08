package orphans;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import main.Game;
import managers.AssetsManager;
import utils.Utils;

public class Inventory {

	private Game game;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 64, invY = 48,
			invWidth = 512, invHeight = 384,
			invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2 + 5,
			invListSpacing = 30;
	
	private int invImageX = 452, invImageY = 82,
			invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 484, invCountY = 172;
	
	private int selectedItem = 0;
	
	public Inventory(Game game){
		this.game = game;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void tick(){
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
	}
	
	public void render(Graphics g){
		if(!active)
			return;
		
		g.drawImage(AssetsManager.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		if(len == 0)
			return;
		
		for(int i = -5;i < 6;i++){
			if(selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if(i == 0){
				Utils.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.YELLOW, AssetsManager.font28);
			}else{
				Utils.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.WHITE, AssetsManager.font28);
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Utils.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, AssetsManager.font28);
	}
	
	// Inventory methods
	
	public void addItem(Item item){
		for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
//	 ========== GETTERS SETTERS =========================================

	public Game getgame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean isActive() {
		return active;
	}
	
}
