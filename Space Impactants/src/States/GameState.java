package States;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Entities.creature.Creature;
import Entities.creature.Enemy;
import Entities.creature.Player;
import Main.Handler;

public class GameState extends State {
	
	private Player player;
	private ArrayList<Enemy> enemies;
	
	private static int score;
	
	public static int getScore() {
		return score;
	}

	public static int contEnemy = 0;//usado para espacar a criacao de novos enimigos
	
	public GameState(Handler game){
		super(game);
		player = new Player(game, 0, 150);
		
		enemies = new ArrayList<>();
		createEnemy();
		
		score = 0;
	}
	
	/**
	 * creates new enemies in a random Y position
	 * @return
	 */
	private void createEnemy(){
		Random random = new Random();
		
		int novoy = random.nextInt(game.height - Creature.DEFAULT_HEIGHT);
		enemies.add(new Enemy(game, game.width, novoy));
		//GameState.numEnemy++;
	}
	
	/**
	 * deletes enemies after they passed the x=0
	 * @return
	 */
	public void deleteEnemy(){
		if (enemies.get(0).getX() <= player.getX()){
			enemies.remove(0);
			//System.out.println("primeiro deletado");		
		}
		
	}
	
	/**
	 * handles collision of first enemy with player
	 * @return
	 */
	public boolean Collision(){
		for(int i =0;i < (enemies.size() -2);i++){
			Enemy first_enemy = enemies.get(i);
			
			//AJEITAR A DANGER X ZONE PARA O COMPRIMENTO DO ENEMY!!!
			if(first_enemy.getX() <= (player.getX() + Creature.DEFAULT_WIDTH) && first_enemy.getX() > 0) //DANGER X ZONE!
				//System.out.println("Area de perigo! ");
				if((first_enemy.getY() >= player.getY() && first_enemy.getY() < (player.getY() + Creature.DEFAULT_HEIGHT)) || 
						(  ( (first_enemy.getY() + Creature.DEFAULT_HEIGHT) <= (player.getY() + Creature.DEFAULT_HEIGHT) ) &&
								( (first_enemy.getY() + Creature.DEFAULT_HEIGHT) >= (player.getY()) )  )   )
					return true;
		}	
		return false;
	}
	
	@Override
	public void update() {
		
		player.update();
		score++;
		
		if(Collision()){
			System.out.println("Colisão! ");
			showScore();
			game.SwitchCards("final");
		}
		
		//creates enemies spaced, depending on the game level
		GameState.contEnemy++;
		if(GameState.contEnemy == (int) (100/Handler.level)){
			createEnemy();
			//System.out.println(GameState.contEnemy);
			GameState.contEnemy = 0;
			deleteEnemy();
		}
		
		for(int i = 0;i<enemies.size();i++)
			enemies.get(i).update();
		
		//EXITING WITH ESCAPE
		if(game.getKeyManager().esc){
			game.SwitchCards("menu");
			GameState.setCurrentState(game.menuState);
			//System.exit(0);
		}
		//CHEATING
		/*if(game.getKeyManager().levelUP){
			//Game.level+=0.1;
			System.out.println("Nível: "+Handler.level);
		}*/
	}

	@Override
	public void render(Graphics g) {
		
		player.render(g);
		
		for(int i = 0;i<enemies.size();i++)
			enemies.get(i).render(g);
	}
	
public void showScore(){
	   
	    game.getDisplay().dlm.addElement(game.getNomes());
	    game.getDisplay().dlm2.addElement(String.valueOf(score));
	    
	    System.out.println("created showscore()");
	}

}
