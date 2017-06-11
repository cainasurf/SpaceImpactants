package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	private boolean[] keys;
	public boolean up, down, esc, levelUP;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void update(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		
		esc = keys[KeyEvent.VK_ESCAPE]; 
		//CHEATS
		levelUP = keys[KeyEvent.VK_U];
	}
	
	@Override
	public void keyPressed(KeyEvent ev) {
		keys[ev.getKeyCode()] = true;
		//System.out.println("Pressed: "+ev.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent ev) {
		keys[ev.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
