package childs;

import java.awt.Graphics;

import main.Game;
import managers.AssetsManager;
import orphans.Item;
import parents.StaticEntity;
import parents.Tile;

public class Tree extends StaticEntity {

	public Tree(Game game, float x, float y) {
		super(game, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2, 1);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		game.getWorld().getItemManager().addItem(
				Item.woodItem.createNew(
						(int) x, (int) y
						)
				);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(
				AssetsManager.tree, 
				(int) (x - game.getGameCamera().getxOffset()), 
				(int) (y - game.getGameCamera().getyOffset()), 
				width, 
				height, 
				null
				);
	}

}
