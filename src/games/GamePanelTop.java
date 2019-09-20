package games;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import mainPackage.ComponentBag;

public class GamePanelTop extends JPanel{
	static ComponentBag cb;
	ButtonBar  buttonBar;
	GamePanelMiddle gamePanelMiddle;
	
	// buttons for buttonBar
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	
	// set things up for this game panel
	public GamePanelTop() {
		cb = new ComponentBag();
		buttonBar = new ButtonBar();
		gamePanelMiddle = new GamePanelMiddle();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		buttonBar.setPreferredSize(new Dimension(0,50));
		gamePanelMiddle.setPreferredSize(new Dimension(0,750));
		add(buttonBar);
		add(gamePanelMiddle);
	}
	
	// main game panel, just below the buttonBar
	protected static class GamePanelMiddle extends JPanel{
		public GamePanelMiddle() {
			setBackground(Color.BLACK);
		}
	}
	
	// panel to hold buttons, sits near top of window
	protected class ButtonBar extends JPanel{
		JButton backButton 			= new JButton("Back");;
		JButton discardGameButton   = new JButton("Discard Game");;
		JButton newGameButton 		= new JButton("New Game");
		JButton pauseButton 		= new JButton("Pause");
		MyGamePanelButtonHandler gamePanelButtonHandler = new MyGamePanelButtonHandler();
		public ButtonBar(){
			backButton.addActionListener(gamePanelButtonHandler);
			discardGameButton.addActionListener(gamePanelButtonHandler);
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
	
	// handles button clicked events from the buttonBar buttons
	public class MyGamePanelButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String cmd = arg0.getActionCommand();
			if(cmd.compareTo("Back") == 0) { // go back to main GUI page
				cb.mainJFrame.setContentPane(cb.mainPageMainContainer); 
				cb.tools.updateMainPageButtonFocus();
			} else if (cmd.compareTo("Discard Game") == 0) {
				
			} else if (cmd.compareTo("New Game") == 0) {
				startGame();
			} else if (cmd.compareTo("Pause") == 0) { }
		}
		
		// To Do
		private void startGame() {}
		private void discardGame() {}
	}
}
