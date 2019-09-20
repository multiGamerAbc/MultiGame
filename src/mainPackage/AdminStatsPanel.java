package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mainPackage.ComponentBag;

public class AdminStatsPanel extends JPanel{
	static ComponentBag cb;
	ButtonBar  buttonBar;
	GamePanelMiddle gamePanelMiddle;
	GameStats gameStatsSuperMath;
	JTextArea statsTextArea = new JTextArea();
	Map<String,ArrayList<String>> userStats;
	
	public AdminStatsPanel() {
		cb = new ComponentBag();
		buttonBar = new ButtonBar();
		gamePanelMiddle = new GamePanelMiddle();
		gameStatsSuperMath = new GameStats();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		buttonBar.setPreferredSize(new Dimension(0,50));
		gamePanelMiddle.setPreferredSize(new Dimension(0,750));
		gameStatsSuperMath.setPreferredSize(new Dimension(0,200));
		
		add(buttonBar);
		add(gamePanelMiddle);

		statsTextArea.setBackground(new Color(0,0,0,0));
		statsTextArea.setFont(cb.userNameFont);
		gameStatsSuperMath.add(statsTextArea);
		
		gamePanelMiddle.add(gameStatsSuperMath);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		populateTextArea();
		gamePanelMiddle.revalidate();
	}
	
	// populate stats text area with user's stats - buggy
	public void populateTextArea() {
		//statsTextArea.setText("");
		statsTextArea.setText("SuperMath:\n");
		userStats = cb.user1Stats.getUserStats();
		for(String key : userStats.keySet()) {
			for(String statistic : userStats.get(key)) {
				statsTextArea.append(statistic + "\n");
				System.out.println(statistic);	
			}
		}
		//statsTextArea.append("a b c");
	}
	
	// panel below the button bar, the name is misleading here
	protected static class GamePanelMiddle extends JPanel{
		public GamePanelMiddle() {
			setBackground(Color.BLACK);
			setLayout(new BoxLayout(this,  BoxLayout.Y_AXIS));
		}
	}
	
	// panel to hold game stats
	protected static class GameStats extends JPanel{
		public GameStats() {
			setBackground(Color.RED);
			setLayout(new FlowLayout());
		}
	}
	
	// panel to hold buttons
	protected class ButtonBar extends JPanel{
		JButton backButton 			= new JButton("Back");;
		MyGamePanelButtonHandler gamePanelButtonHandler = new MyGamePanelButtonHandler();
		public ButtonBar(){
			backButton.addActionListener(gamePanelButtonHandler);
			setBackground(Color.GREEN);
			backButton.setPreferredSize(new Dimension(125,35));
			add(backButton);
		}
	}
	
	// handler for buttons in button bar
	public class MyGamePanelButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String cmd = arg0.getActionCommand();
			if(cmd.compareTo("Back") == 0) {
				cb.mainJFrame.setContentPane(cb.mainPageMainContainer); 
				cb.tools.updateMainPageButtonFocus();
			}
		}
		
	}
}
