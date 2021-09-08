package states;

import java.awt.Graphics;

import main.Game;
import main.World;
import parents.State;

public class GameState extends State {
	
	private World world;
	
	public GameState(Game game){
		super(game);

		world = new World(game, "res/world/map.txt"); //#15
		game.setWorld(world); //#20
	}
	
	@Override
	public void tick() {
		world.tick();
		if(game.getKeyManager().space && getState() != game.MENU_STATE)
			setState(game.MENU_STATE);
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
