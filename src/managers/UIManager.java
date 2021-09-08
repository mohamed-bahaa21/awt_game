package managers;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import main.Game;
import parents.UIComponent;

public class UIManager {

	protected Game game;
	private ArrayList<UIComponent> objects;
	
	public UIManager(Game game){
		this.game = game;
		objects = new ArrayList<UIComponent>();
	}
	
	public void tick(){
//		System.out.println("# UIManager tick");
		for(UIComponent o : objects)
			o.tick();
	}
	
	public void render(Graphics g){
		for(UIComponent o : objects)
			o.render(g);
	}
	
	public void addObject(UIComponent o){
		objects.add(o);
	}
	
	public void removeObject(UIComponent o){
		objects.remove(o);
	}
	
	public void onMouseMove(MouseEvent e){
		for(UIComponent o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e){
		for(UIComponent o : objects)
			o.onMouseRelease(e);
	}
	
//	-------------- Getters & Setters ------------------------------------------------------------

	public Game getgame() {
		return game;
	}

	public void setgame(Game game) {
		this.game = game;
	}

	public ArrayList<UIComponent> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIComponent> objects) {
		this.objects = objects;
	}
	
}
