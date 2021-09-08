package managers;

import java.awt.Font;
import java.awt.image.BufferedImage;

import parents.SpriteSheet;
import utils.Utils;

public class AssetsManager {
	
	private static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	public static BufferedImage grass;
	public static SpriteSheet grassSheet;
	
	public static Font font28;
	
	public static BufferedImage dirt, stone, tree, rock;
	public static BufferedImage wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	
	public static void init() {
		
		grassSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TX_Tileset_Grass.png"));
		grass = grassSheet.crop(32*4, 32, TILE_WIDTH, TILE_HEIGHT);
		
		font28 = Utils.loadFont("res/fonts/slkscr.ttf", 28);
		
		SpriteSheet sheet = new SpriteSheet(Utils.loadImage("/textures/sheet.png")); //#10
		SpriteSheet playerSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TX_Player.png")); //#10
		SpriteSheet treeSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TXPlant.png"));
		SpriteSheet grassSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TX_Tileset_Grass.png"));
		SpriteSheet stoneSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TX_Props.png"));
		SpriteSheet wallSheet = new SpriteSheet(Utils.loadImage("/texturesv2/TX_Struct.png"));
		
		inventoryScreen = Utils.loadImage("/textures/inventoryScreen.png");
		
		wood = sheet.crop(TILE_WIDTH, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT); //#11
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(TILE_WIDTH * 6, TILE_HEIGHT * 4, TILE_WIDTH * 2, TILE_HEIGHT);
		btn_start[1] = sheet.crop(TILE_WIDTH * 6, TILE_HEIGHT * 5, TILE_WIDTH * 2, TILE_HEIGHT);
		
		player_down = new BufferedImage[1];
		player_up = new BufferedImage[1];
		player_left = new BufferedImage[1];
		player_right = new BufferedImage[1];
		
		player_down[0] = playerSheet.crop(TILE_WIDTH*0, 0, TILE_WIDTH, TILE_HEIGHT*2);
//		player_down[1] = sheet.crop(TILE_WIDTH * 5, 0, TILE_WIDTH, TILE_HEIGHT);
		player_up[0] = playerSheet.crop(TILE_WIDTH*1, 0, TILE_WIDTH, TILE_HEIGHT*2);
//		player_up[1] = sheet.crop(TILE_WIDTH * 7, 0, TILE_WIDTH, TILE_HEIGHT);
		player_right[0] = playerSheet.crop(TILE_WIDTH*2, 0, TILE_WIDTH, TILE_HEIGHT*2);
//		player_right[1] = sheet.crop(TILE_WIDTH * 5, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		player_left[0] = playerSheet.crop(TILE_WIDTH*2, 0, TILE_WIDTH, TILE_HEIGHT*2);
//		player_left[1] = sheet.crop(TILE_WIDTH * 7, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
		
		zombie_down = new BufferedImage[2];
		zombie_up = new BufferedImage[2];
		zombie_left = new BufferedImage[2];
		zombie_right = new BufferedImage[2];
		
		zombie_down[0] = sheet.crop(TILE_WIDTH * 4, TILE_HEIGHT * 2, TILE_WIDTH, TILE_HEIGHT);
		zombie_down[1] = sheet.crop(TILE_WIDTH * 5, TILE_HEIGHT * 2, TILE_WIDTH, TILE_HEIGHT);
		zombie_up[0] = sheet.crop(TILE_WIDTH * 6, TILE_HEIGHT * 2, TILE_WIDTH, TILE_HEIGHT);
		zombie_up[1] = sheet.crop(TILE_WIDTH * 7, TILE_HEIGHT * 2, TILE_WIDTH, TILE_HEIGHT);
		zombie_right[0] = sheet.crop(TILE_WIDTH * 4, TILE_HEIGHT * 3, TILE_WIDTH, TILE_HEIGHT);
		zombie_right[1] = sheet.crop(TILE_WIDTH * 5, TILE_HEIGHT * 3, TILE_WIDTH, TILE_HEIGHT);
		zombie_left[0] = sheet.crop(TILE_WIDTH * 6, TILE_HEIGHT * 3, TILE_WIDTH, TILE_HEIGHT);
		zombie_left[1] = sheet.crop(TILE_WIDTH * 7, TILE_HEIGHT * 3, TILE_WIDTH, TILE_HEIGHT);
		
		dirt = grassSheet.crop(TILE_WIDTH*5, TILE_HEIGHT*3, TILE_WIDTH, TILE_HEIGHT);
		grass = grassSheet.crop(TILE_WIDTH*5, TILE_HEIGHT*4, TILE_WIDTH, TILE_HEIGHT);
		stone = wallSheet.crop(TILE_WIDTH, TILE_HEIGHT, TILE_WIDTH*2, TILE_HEIGHT*2);
		tree = treeSheet.crop(TILE_WIDTH*5, TILE_HEIGHT*0, TILE_WIDTH*3, TILE_HEIGHT*5);
		rock = stoneSheet.crop(0, TILE_HEIGHT*13, TILE_WIDTH*2, TILE_HEIGHT*2);
	}
	
}
