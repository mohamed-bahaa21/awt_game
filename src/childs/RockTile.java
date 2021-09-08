package childs;

import managers.AssetsManager;
import parents.Tile;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(AssetsManager.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
