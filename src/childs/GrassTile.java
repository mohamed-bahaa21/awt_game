package childs;

import java.awt.image.BufferedImage;

import managers.AssetsManager;
import parents.Tile;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(AssetsManager.grass, id);
	}

}
