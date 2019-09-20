package games;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import mainPackage.ComponentBag;

public class CoolPiesPanel extends JPanel{
	//=====================================================================================
	// Data
		
		static ComponentBag cb;
		static ButtonBar  buttonBar;
		static GamePanelMiddle gamePanelMiddle;
		static boolean isPaused = true;
		static int deltaX = 0, deltaY = 0;			// change dude's position by this much
		
		static int pieXorig = 850;					// pie origin
		static int pieYorig = 200;					
		static int pieX = pieXorig;					// pie position
		static int pieY = pieYorig;
		static int pieDiameter = 50;				// pie size
		static int checkDelta = 10;					// for hit check
		static boolean dudeHit = false;				// contact?

		static int dw, dh;							// dude's width, height
		static int dxo = 350;						// dude's original position
		static int dyo = 350;						
		static int dxBase = dxo;					// base point of dude
		static int dyBase = dyo;
		static int dyBaseReference = dyo;			// reference to base point
	
	
//=====================================================================================
// JPanel Classes	
	
	// list of Pies, these are hurled toward the dude
	static ArrayList<Pie> pieList = new ArrayList<Pie>();
	
	// holds data and operations for a Pie object
	static class Pie {
		public Pie() {}
		public Pie(int xOrig, int yOrig) {
			pieX = xOrig;
			pieY = yOrig;
		}
		public Pie(int xOrig, int yOrig, char color) {
			pieX = xOrig;
			pieY = yOrig;
			this.color = color;
		}
		char color = 'b';				// hot pie or cool pie?
		int pieXDelta = -5;				// position variables
		int pieXorig = 850;
		int pieYorig = 200;
		int pieX = pieXorig;
		int pieY = pieYorig;
		int pieDiameter = 50;
		int checkDelta = 10;
		boolean dudeHit = false;		// has dude been hit?
		public void updatePosition() { // move Pie by pieXDelta on timer event
			pieX += pieXDelta;
		}
		public void draw(Graphics g){	// draw pie
			if(color == 'b') {
				g.setColor(Color.BLUE);
			} else if (color == 'r') {
				g.setColor(Color.RED);
			}
			g.fillOval(pieX,pieY,pieDiameter, pieDiameter);
		}
	}
		
	// Middle Panel Class
	protected static class GamePanelMiddle extends JPanel implements ActionListener{
		// logic variables for dude's position
		static boolean dudeAtEdge = false;
		static boolean dudeAtLeftEdge = false;
		static boolean dudeAtRightEdge = false;
		static boolean isJumping = false;

		// numerical variables for dude's position
		static int jumpMax = 300;
		static int jumpDelta = 0;
		static int jumpTime = 0;
		
		// dude's health and score
		static int dudesHealth = 10;
		static int dudesScore = 0;
				
		static Timer timer;						// drives animation
		
		// has the dude been hit?
		public boolean checkForImpact(Pie p) {

			if( p.dudeHit == false
				&& p.pieY + p.pieDiameter > dyBase
				&& p.pieX < dyBase + dh
				&& p.pieX < dxBase + dw/2 + p.checkDelta) {
				p.dudeHit = true;
				return true;
			}
			return false;
		}
		
		// has the dude been hit by any of the pies in pie list?
		public boolean checkForPieHits() {
			for(Pie p : pieList) {
				if( p.dudeHit == false
					&& p.pieY + p.pieDiameter > dyBase
					&& p.pieY < dyBase + dh
					&& p.pieX < dxBase + dw/2 + p.checkDelta
					&& p.pieX + p.pieDiameter > dxBase + dw/2 - p.checkDelta) {
					p.dudeHit = true;
					if(p.color == 'b') {
						dudesScore += 1;
					} else if (p.color == 'r') {
						dudesHealth -= 1;
					}
					return true;
				}
			}
			return false;
		}
		
		// randomly distribute the pies horizontally (starting offscreen)
		public int[] createHorizontalPieDisplacementVector(int n) {
			int[] result = new int[n];
			result[0] = 900;
			for(int i = 1 ; i < n ; i++) {
				result[i] = (int)(result[i-1] + 20 + Math.random()*350);	
			}
			return result;
		}
		
		// setup pie horiz. displacement vector. add 100 new pies to pieList. setup game panel
		public GamePanelMiddle() {
			int[] horizontalDisplacementVector = createHorizontalPieDisplacementVector(100);
			for(int i = 0 ; i < 100 ; i++) {
				char color = Math.random() < .25 ? 'r' : 'b';
				pieList.add(new Pie(horizontalDisplacementVector[i], 50 + (int)(Math.random()*400), color));
			}
			setBackground(new Color(97, 40, 9));
			timer = new Timer(10,this);

		}
		
		// draw dude, pies, floor, and health and score text
		@Override
		public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        drawDude(g);
	        for(Pie p : pieList) {
	        	p.draw(g);
	        }
	        drawFloor(g);
	        drawText(g);
		}
		
		// draw health and score text
		public void drawText(Graphics gx) {
			Font healthAndScoreFont = new Font("TimesRoman", Font.BOLD, 40);
			gx.setFont(healthAndScoreFont);
			gx.setColor(Color.RED);
			gx.drawString("Health:  " + dudesHealth, 30,50);
			gx.setColor(new Color(13, 93, 214));
			gx.drawString("Score:  " + dudesScore, 600,50);
		}
		
		// draw floor dude stands on
		public void drawFloor(Graphics gx) {
			gx.setColor(Color.BLUE);
			gx.fillRect(25, dyo + dh, 750, 10);
		}
		
		// draw a pie
		public void drawPie(Graphics gx) {
			gx.setColor(Color.RED);
			gx.fillOval(pieX,pieY,pieDiameter, pieDiameter);
		}
		
		// draw the dude
		public void drawDude(Graphics gx){
			// variables used to draw dude's body and head
			double a, b, c, d, e, f, g, h, i, j, k, r, s, t, u, v, w, x, y, z;
			double ap, bp, cp, dp, ep, fp, gp, hp, ip, jp, kp, rp, sp, tp, up, vp, wp, xp, yp, zp;
			double zpr, ypr, xpr, wpr, vpr, upr, tpr, spr, rpr;			
	
			dw = 120; dh = 180;

			a = 0.13; b = .19; c = .22; d = .33; e = .42;  f = .59;  g = .74;
			h = .78; i = .84; j = .94; k = 1;
			r = .5; s = .46; t = .43; u = .40; v = .3; w = .28; x = .2; y = .15; z = .11;
			// verticals
			ap = dyBase + a*dh; bp = dyBase + b*dh; cp = dyBase + c*dh; dp = dyBase + d*dh; ep = dyBase + e*dh; 
			fp = dyBase + f*dh; gp = dyBase + g*dh; hp = dyBase + h*dh; ip = dyBase + i*dh; jp = dyBase + j*dh;
			kp = dyBase + k*dh; 
			// horizontals Left
			rp = dxBase + r*dw; sp = dxBase + s*dw; tp = dxBase + t*dw; 
			up = dxBase + u*dw; vp = dxBase + v*dw; wp = dxBase + w*dw;
			xp = dxBase + x*dw; yp = dxBase + y*dw; zp = dxBase + z*dw;
			// horizontals Right
			zpr = dxBase+dw*(1-z); ypr = dxBase+dw*(1- y); xpr = dxBase+dw*(1- x); 
			wpr = dxBase+dw*(1- w); vpr = dxBase+dw*(1- v); upr = dxBase+dw*(1- u); 
			tpr = dxBase+dw*(1- t); spr = dxBase+dw*(1- s); rpr = dxBase+dw*(1- r);
			
			int delta = 20;
			int headX = dxBase + (int)(dw/2 - (c*dw + delta)/2);

			double[] dbxsF = {tp,tp,vp,zp,dxBase,yp,tp,tp,wp,wp,xp,xp,up,up,sp,spr,upr,upr,xpr,xpr,wpr,
							wpr,tpr,tpr,ypr,dxBase+dw,zpr,vpr,tpr,tpr};
			double[] dbysF = {cp,dp,dp,ap,bp,ep,ep,fp,gp,jp,jp,kp,kp,ip,hp,hp,ip,kp,kp,jp,jp,gp,fp,ep,ep,
					bp,ap,dp,dp,cp};
			int[] dbxs = new int[dbxsF.length];
			int[] dbys = new int[dbysF.length];
			
			for(int index = 0 ; index < dbxs.length ; index++) {
				dbxs[index] = (int)dbxsF[index];
				dbys[index] = (int)dbysF[index];
			}
			
			int[] arr1a = {dbxs[1],dbxs[2],dbxs[3],dbxs[4]};
			int[] arr1b = {dbys[1],dbys[2],dbys[3],dbys[4]};

			
			gx.setColor(new Color(50, 168, 82));
			// draw head
			gx.fillOval(headX, dyBase, (int)(c*dw + delta), (int)(c*dw + delta));
			// draw body
			gx.fillPolygon(dbxs,dbys,dbxs.length);
		}
		
		// update dude's position and status (jumping or not)
		public void updatePositionLocAndStatus() {
			if(deltaX < 0) {
				if(!dudeAtLeftEdge) {
					dxBase += deltaX;
					dudeAtRightEdge = false;
				}
			}
			if(deltaX > 0) {
				if(!dudeAtRightEdge) {
					dxBase += deltaX;
					dudeAtLeftEdge = false;
				}
			}
			dyBase += deltaY;
			if(dxBase <= 0) {
				dudeAtLeftEdge = true;
			}
			if(dxBase >= 800 - dw) {
				dudeAtRightEdge = true;
			}
			if(isJumping) {
				jumpDelta = computeJumpDelta(jumpTime++);
				if(jumpTime == 100) {
					isJumping = false;
					jumpTime = 0;
					dyBase = dyBaseReference;
				} else {
					dyBase = dyBaseReference - jumpDelta;					
				}
			}
		}
		
		// update positions/status of dude and pies, check for pie hits
		@Override
		public void actionPerformed(ActionEvent arg0) {
			updatePositionLocAndStatus();
			
			for(Pie p : pieList) {
				p.updatePosition();
			}
			if(checkForPieHits()) {
				//System.out.println("HIT");
			}			
			repaint();			
		}
	
		// function to translate jump time to dude's vertical displacement scalar
		public double jumpTranslationFunction(double jumpTime) {
			double result = 1 - (2*jumpTime - 1) * (2*jumpTime - 1);
			return result;
		}
		
		// compute dude's vertical displacement
		public int computeJumpDelta(double jumpTime) {
			double translationInput = jumpTime / 100;  // 100 = # timer events per second
			int result = (int) (jumpTranslationFunction(translationInput) * jumpMax);
			return result;
		}
		
		// change dude's state from not jumping to jumping
		public void doJump() {
			if(!isJumping) {
				isJumping = true;	
			}
		}
	}
	
	// Button Bar class
	protected class ButtonBar extends JPanel{
		JButton backButton 			= new JButton("Back");;
		JButton discardGameButton   = new JButton("Discard Game");;
		JButton newGameButton 		= new JButton("New Game");
		JButton pauseButton 		= new JButton("Pause");
		MyGamePanelButtonHandler gamePanelButtonHandler = new MyGamePanelButtonHandler();
		// setup the ButtonBar GUI components
		public ButtonBar(){
			backButton.addActionListener(gamePanelButtonHandler);
			discardGameButton.addActionListener(gamePanelButtonHandler);
			newGameButton.addActionListener(gamePanelButtonHandler);
			pauseButton.addActionListener(gamePanelButtonHandler);
			setBackground(Color.DARK_GRAY);
			backButton.setPreferredSize(new Dimension(125,35));
			discardGameButton.setPreferredSize(new Dimension(125,35));
			newGameButton.setPreferredSize(new Dimension(125,35));
			pauseButton.setPreferredSize(new Dimension(125,35));
			add(backButton);
			add(discardGameButton);
			add(newGameButton);
			add(pauseButton);
		}
	}
	
//=====================================================================================
// Handlers and Listeners
	
	// handle button click events from ButtonBar
	public class MyGamePanelButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String cmd = arg0.getActionCommand();
			if(cmd.compareTo("Back") == 0) {
				cb.mainJFrame.setContentPane(cb.mainPageMainContainer); 
				cb.updateMainPageButtonFocus();
			} else if (cmd.compareTo("Discard Game") == 0) {
				
			} else if (cmd.compareTo("New Game") == 0) {  // needs work
				startGame();		
			} else if (cmd.compareTo("Pause") == 0) { }
			
			cb.mainJFrame.requestFocusInWindow();
		}
		
		// start a new game.  needs work
		private void startGame() {
			isPaused = true;
			for(Pie p : pieList) {
				p.dudeHit = false;
				p.pieX = pieXorig;
				p.pieY = pieYorig;
			}
			dxBase = dxo;
			dyBase = dyo;
			deltaX = 0;
			deltaY = 0;
			repaint();
		}
		private void discardGame() {}
	}
	
	// handle keyPressed events to move the dude, pause the game, start new game
	protected static class MyKeyListener implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				deltaX = -5;
				deltaY = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				deltaX = 5;
				deltaY = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				//deltaY = -5;
				//deltaX = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				deltaY = 0;
				deltaX = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_P) {
				if(isPaused) {
					GamePanelMiddle.timer.start();
				} else {
					GamePanelMiddle.timer.stop();
				}
				isPaused = !isPaused;
			} else if (e.getKeyCode() == KeyEvent.VK_N) {
				buttonBar.newGameButton.doClick();
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				gamePanelMiddle.doJump();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
	}

	// setup the CoolPiesPanel GUI components
//=====================================================================================
// Constructor
	
	public CoolPiesPanel() {
		cb = new ComponentBag();
		buttonBar = new ButtonBar();
		gamePanelMiddle = new GamePanelMiddle();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		buttonBar.setPreferredSize(new Dimension(0,50));
		gamePanelMiddle.setPreferredSize(new Dimension(0,750));
		add(buttonBar);
		add(gamePanelMiddle);
		cb.mainJFrame.addKeyListener(new MyKeyListener());
	}
	

	

}

// new game needs to reset Pie list
// new game unpaused










