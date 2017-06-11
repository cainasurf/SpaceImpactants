package Main;

	import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Graphics.Assets;
import Main.Input.KeyManager;
import States.FinalState;
//import Main.Input.MouseManager;
import States.GameState;
import States.MenuState;
import States.State;

	/**
	 *
	 * @author Guaiamum
	 */
	public class Handler implements Runnable{
	    private Display display;
	    public int width, height;
	    public String title;
	    
	    private boolean running = false;
	    private Thread thread;
	    
	    private BufferStrategy bs;
	    private Graphics g;
	    
	    //States
	    public State  menuState, gameState, finalState;
	    
	    //Input
	    private KeyManager keyManager;
	    //private MouseManager mouseManager;
	    
	    //Logic
	    public static double level;
	    private String nomes;
	    

		public Handler(String title, int width, int height) {
	        this.title = title;
	        this.width = width;
	        this.height = height;
	        
	        Handler.level = 1;
	       // nomes = new ArrayList<>();
	        
	        keyManager = new KeyManager();
	        //mouseManager = new MouseManager();
	    }
	    
	    private void init(){
	                
	        display = new Display(title, width, height,this);

	        /*display.getFrame().addMouseListener(mouseManager);
	        display.getFrame().addMouseMotionListener(mouseManager);
	        display.getCanvas().addMouseListener(mouseManager);
	        display.getCanvas().addMouseMotionListener(mouseManager);*/
	        Assets.init();
	        
	        //gameState = new GameState(this);
	        menuState = new MenuState(this);
	        finalState = new FinalState(this);
	        
	        State.setCurrentState(menuState);
	        display.getFrame().addKeyListener(keyManager);
	    }
	    
	    public void SwitchCards(String card){
	    	
			CardLayout cl = (CardLayout)(display.principal.getLayout());
			cl.show(display.getPrincipal(), card);
			
			if(card.equals("game")){
				gameState = new GameState(this);
				State.setCurrentState(gameState);
			}
			if(card.equals("final")){
				State.setCurrentState(finalState);
				
			}	
	        
		}
		
	    public void setNome(){
			nomes=JOptionPane.showInputDialog("Digite seu nome: ");
			System.out.println("Seu nome é: "+ nomes);
		}
	    public String getNomes() {
			return nomes;
		}
	    
		private void update(){
	    	keyManager.update();
	    	
	    	if(State.getCurrentState() != null) //if the current State is not null, update it
	    		State.getCurrentState().update();
	    }
	    
	    private void render(){
	        bs = display.getCanvas().getBufferStrategy(); //virtual screens to avoid flickering
	        if(bs == null){ //if bs is not created, create one
	            display.getCanvas().createBufferStrategy(3);
	            return;
	        }
	        g = bs.getDrawGraphics(); //allows to draw to canvas
	        //Clear Screen
	        g.clearRect(0, 0, width, height);
	        //Begin Drawing
	        
	        if(State.getCurrentState() != null) //if the current State is not null, render it
	    		State.getCurrentState().render(g);
	        
	        //End Drawing
	        bs.show();
	        g.dispose();
	    }
	    
	    public void run(){
	        init();
	        
	        //padroniza a velocidade de reproducao em qualquer computador
	        int fps = 60; //frames per second
	        double timePerUpdate = 1000000000 / fps; //max amount of time to run the followinf while
	        double delta = 0;
	        long now;
	        long lastTime = System.nanoTime(); //time of the computer in nanoseconds
	        /*long timer = 0;
	        int ticks = 0;*/
	        
	        //update() e render() na frequencia determinada
	        while(running){
	            now = System.nanoTime();
	            delta += (now - lastTime) / timePerUpdate;
	            //timer += now - lastTime;
	            lastTime = now;
	            
	            if(delta >= 1){
		        	update();
		            render();
		            //ticks++;
		            delta--;
	            }
	            
	            /*if (timer >= 1000000000){
	            	System.out.println("Ticks and frames: "+ ticks);
	            	ticks = 0;
	            	timer = 0;
	            }*/
	        }
	        
	        stop();
	    }
	    
	    
	    
	    public KeyManager getKeyManager() {
			return keyManager;
		}
	    
		/*public MouseManager getMouseManager() {
			return mouseManager;
		}*/

		public synchronized void start(){
	        if(running) //verifies if game is already running
	            return;
	        running = true;
	        thread = new Thread(this);
	        thread.start(); //calls run method
	    }
	    
	    public synchronized void stop(){
	        if(!running) //verifies if game is stopped already
	            return;
	        running = false;
	        try {
	            thread.join();
	        } catch (InterruptedException ex) {
	            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public Display getDisplay(){
	    	return this.display;
	    }
	}

