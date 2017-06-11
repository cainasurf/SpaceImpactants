package Entities.creature;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Assets;
import Main.Handler;

public class Player extends Creature {
	
	private Handler game;
	
	public Player(Handler game, int x, int y) {
		super(game,x, y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.game = game;
		
	}

	@Override
	public void update() {
		getInput();
		move();
		bounds.x = x;
		bounds.y = y;
		
	}
	
	private void getInput(){
		
		dx = 0;
		dy = 0;
		
		if(game.getKeyManager().up)
			dy = (int) -speed;
			
		if(game.getKeyManager().down)
			dy = (int) speed;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
		
		g.setColor(Color.green);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
}
