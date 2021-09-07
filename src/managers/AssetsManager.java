package managers;

import java.awt.image.BufferedImage;

import parents.SpriteSheet;
import utils.Utils;

public class AssetsManager {
	
	private static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	public static BufferedImage grass;
	public static SpriteSheet grassSheet;
	
	public static void init() {
		
		grassSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TX_Tileset_Grass.png"));
		grass = grassSheet.crop(32*4, 32, TILE_WIDTH, TILE_HEIGHT);
		
		
	}
}
