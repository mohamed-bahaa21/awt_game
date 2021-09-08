package parents;

import main.Game;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Game game, float x, float y, int width, int height, int health){
		super(game, x, y, width, height, health);
	}

}
