package states;

import java.awt.Graphics;

import childs.UIImageButton;
import main.Game;
import managers.AssetsManager;
import managers.UIManager;
import parents.State;
import utils.ClickListener;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Game game) {
		super(game);
		
		uiManager = new UIManager(game);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, AssetsManager.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				State.setState(game.getGame().GAME_STATE);
			}
		}));
		
		game.getMouseManager().setUIManager(uiManager);
	}

	@Override
	public void tick() {
		uiManager.tick();
		
		if(game.getMouseManager().getUIManager() == null) {
			game.getMouseManager().setUIManager(uiManager);			
		}
		
		// Temporarily: just go directly to the GameState, skip the menu state!
//		game.getMouseManager().setUIManager(null);
//		State.setState(game.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
