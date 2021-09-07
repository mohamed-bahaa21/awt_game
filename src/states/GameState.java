package states;

import java.awt.Graphics;

import main.Game;
import main.World;
import parents.State;

public class GameState extends State {
	
	private World world;

	public GameState(Game game) {
		super(game);
		
		world = new World(game, "res/world/map.txt");
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	

}
