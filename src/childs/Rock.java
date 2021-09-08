package childs;

import java.awt.Graphics;

import main.Game;
import managers.AssetsManager;
import orphans.Item;
import parents.StaticEntity;
import parents.Tile;

public class Rock extends StaticEntity {

	public Rock(Game game, float x, float y) {
		super(game, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, 1);
		
		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		game.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(AssetsManager.rock, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
	}

}
