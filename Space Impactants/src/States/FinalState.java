package States;

import java.awt.Graphics;

import Main.Handler;

public class FinalState extends State{
	
	public FinalState(Handler game){
		super(game);
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	/*public void showScore(){
	    
		JPanel panel = new JPanel();
	    JLabel jlabel = new JLabel(game.getNomes().get(0));
	    jlabel.setFont(new Font("Verdana",1,20));
	    panel.add(jlabel);
	    game.getDisplay().painelFinal.add(panel);
	   
	    System.out.println("created showscore()");
	}*/

}
