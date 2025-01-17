package Main;
	import java.awt.Canvas;
import java.awt.CardLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.GridBagLayout;


	/**
	 *
	 * @author Guaiamum
	 */
	public class Display implements ActionListener{
	    
	    private JFrame frame;
	    private Canvas canvas;
	    public JPanel principal,painelMenu,painelGame,painelFinal;
	    
	    public JList<String> list;
	    public DefaultListModel<String> dlm,dlm2;
	    
	    private String title;
	    private int width, height;
	    
	    private Handler game;

	    public Display(String title, int width, int height,Handler game) {
	        this.title = title;
	        this.width = width;
	        this.height = height;
	        this.game = game;
	        
	        createDisplay();
	    }
	    
	    public void createDisplay(){
	        frame = new JFrame(title); //sets the title
	        frame.setSize(width,height); //sets the size
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program when windows is closed
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);//windows appears at the center
	        frame.setVisible(true); //by default is false(invisible)
	        
	        createPainel();
	        
	        createCanvas(); 
	        
	        CardLayout cl = (CardLayout)(principal.getLayout());
	        cl.show(principal,"menu");
	    }
	    
		public void createPainel(){
	    	principal = new JPanel();
	    	principal.setLayout(new CardLayout());
	    	principal.addKeyListener(game.getKeyManager());
	    	principal.setFocusable(true);
	    	
	    	createMenuPanel();
	    	painelGame = new JPanel(); 	  
	    	principal.add(painelGame, "game");
	    	createFinalPanel();
	    	
	    	
	    	frame.add(principal);
	    }
	    
		private void createMenuPanel(){
			painelMenu = new JPanel();
			painelMenu.setLayout(new GridBagLayout());
			painelMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			
			JButton botao = new JButton("PLAY");
	    	botao.setPreferredSize(new Dimension(130,30));
	    	botao.addActionListener(this);
	    	c.gridy = 0;
	    	painelMenu.add(botao, c);
	    	
	    	JButton sair = new JButton("EXIT");
	    	sair.setPreferredSize(new Dimension(130,30));
	    	sair.addActionListener(this);
	    	c.gridy = 1;
	    	painelMenu.add(sair, c);
	    	
	    	principal.add(painelMenu, "menu");
		}
		
		private void createFinalPanel(){
			painelFinal = new JPanel();
			painelFinal.setLayout(new GridBagLayout());
			painelFinal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		    
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			
			JButton menu = new JButton("MENU");
	    	menu.setPreferredSize(new Dimension(130,30));
	    	menu.addActionListener(this);
	    	c.gridy = 1;
	    	painelFinal.add(menu, c);
	    	
	    	JButton sair = new JButton("EXIT");
	    	sair.setPreferredSize(new Dimension(130,30));
	    	sair.addActionListener(this);
	    	c.gridy = 2;
	    	painelFinal.add(sair, c);
			
	    	//lista nomes
	    	list = new JList<>();
		    dlm = new DefaultListModel<>();
		    list.setModel(dlm);
		    painelFinal.add(list);
		    
		    //lista scores
		    JList<String> list2 = new JList<>();
		    dlm2 = new DefaultListModel<>();
		    list2.setModel(dlm2);
		    painelFinal.add(list2);
		    
			principal.add(painelFinal, "final");
		}
		
	    private void createCanvas(){
	    	canvas = new Canvas();
	        canvas.setPreferredSize(new Dimension(width, height));
	        canvas.setMaximumSize(new Dimension(width, height));
	        canvas.setMinimumSize(new Dimension(width, height));
	        canvas.setFocusable(false);//disable the canvas to be focused, so key can be pressed
	        
	        painelGame.add(canvas);//,"game");
	        frame.pack();
	    }
	    
	    public Canvas getCanvas() {
	        return canvas;
	    }

		public JFrame getFrame() {
			return frame;
		}

	    public JPanel getPrincipal() {
			return principal;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("PLAY")){
				game.setNome();
				game.SwitchCards("game");
			}
			else if(e.getActionCommand().equals("EXIT"))
				System.exit(0);
			
			else if(e.getActionCommand().equals("MENU"))
				game.SwitchCards("menu");;
		}

	    
	    
	}
