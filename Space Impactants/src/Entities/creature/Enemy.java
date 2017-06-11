package Entities.creature;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Assets;
import Main.Handler;

public class Enemy extends Creature {


	//private Game game;

	public Enemy(Handler game, int x, int y) {
		super(game,x, y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//this.game = game;
	}

	@Override
	public void update() {
		calculaVelocidade();
		move();
		
		bounds.x = x;
		bounds.y = y;
	}
	
	private void calculaVelocidade(){
		dx = (int) (-speed);// * Game.level);
	}
	
	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.enemy, (int) x, (int) y, width, height, null);
		
		g.setColor(Color.red);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
