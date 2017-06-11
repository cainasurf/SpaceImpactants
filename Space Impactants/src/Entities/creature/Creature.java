package Entities.creature;

import Entities.Entity;
import Main.Handler;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 3;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_WIDTH = 110,//era 90x90
							DEFAULT_HEIGHT = 70;
	
	protected int health;
	protected float speed;
	protected int dx, dy;
	
	protected Handler game;
	
	public Creature(Handler game, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.game = game;
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}
	
	public void move(){
		x += dx;
		if((y + dy)>0 && (y + dy)<(game.height - this.height))
			y += dy;
		
	}
	
	//*******************************
	//GETTERS AND SETTERS
	
	public int getHealth() {
		return health;
	}

	public float getDx() {
		return dx;
	}


	public void setDx(int dx) {
		this.dx = dx;
	}


	public float getDy() {
		return dy;
	}


	public void setDy(int dy) {
		this.dy = dy;
	}


	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
}
