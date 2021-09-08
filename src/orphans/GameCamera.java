package orphans;

import main.Game;
import parents.Entity;
import parents.Tile;

public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > game.getWorld().getWidth() * Tile.TILE_WIDTH - game.getWidth()){
			xOffset = game.getWorld().getWidth() * Tile.TILE_WIDTH - game.getWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > game.getWorld().getHeight() * Tile.TILE_HEIGHT - game.getHeight()){
			yOffset = game.getWorld().getHeight() * Tile.TILE_HEIGHT - game.getHeight();
		}
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
//	------------ Getters & Setters ----------------------------------------------------------------

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
