package mainPageListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainPackage.ComponentBag;

// handles button click events from main GUI
public class ButtonHandler implements ActionListener {
	ComponentBag cb = new ComponentBag();
	
	// called on button clicks
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		if(cmd.compareTo("<") == 0 || 
		   cmd.compareTo(">") == 0) {  // arrow click
			updateDisplayForMainPageArrowButtonClick(cmd);
		} else { // not an arrow click
			updateDisplayForMainPageNormalButtonClick(cmd);
		}
	}

	// ascertain new game number (for details pane) and update details pane
	private void updateDisplayForMainPageArrowButtonClick(String cmd) {
		int newGameNum = -1;
		if(cmd.compareTo("<") == 0) {
			newGameNum = ascertainNewGameNumForLeftArrowClick();
		} else if(cmd.compareTo(">") == 0) {
			newGameNum = ascertainNewGameNumForRightArrowClick();
		}
		String newCommandString = "mainPageButton" + newGameNum;
		updateDisplayForMainPageNormalButtonClick(newCommandString);
	}

	// get new game number on 'left' click
	private int ascertainNewGameNumForLeftArrowClick() {
		int newGameNum;
		if(cb.currentGameInDetailPane != 1) {
			newGameNum = --cb.currentGameInDetailPane; // ##
		} else {
			newGameNum = cb.numGames;
		}
		return newGameNum;
	}

	// get new game number on 'right' click
	private int ascertainNewGameNumForRightArrowClick() {
		int newGameNum;
		if(cb.currentGameInDetailPane != 10) {
			newGameNum = ++cb.currentGameInDetailPane; // ##
		} else {
			newGameNum = 1;
		}
		return newGameNum;
	}
	
	// get button number and load appropriate panel or switch to admin page
	private void updateDisplayForMainPageNormalButtonClick(String cmd) {
		int buttonNumber = getButtonNumberFromActionCommandString(cmd);
		if(buttonNumber <= cb.numGames) {  // action is from one of buttons 1..10
			updateMainPageMiddleContainerWithNewDetailsPanel(cmd, buttonNumber); // ## redundant?		
		} else {
			loadAdminPage(buttonNumber);
		}
	}

	// parse button number from button's action command string
	private int getButtonNumberFromActionCommandString(String cmd) {
		String buttonNumberString =  cmd.substring(cb.tools.indexOfFirstDigit(cmd));
		int buttonNumber = Integer.parseInt(buttonNumberString);
		return buttonNumber;
	}
	
	// swap contents of details panel in main GUI page
	private void updateMainPageMiddleContainerWithNewDetailsPanel(String cmd, int buttonNumber) {
		cb.swapMiddleContainerContents(cmd, buttonNumber);
	}
	
	// swap main GUI page out of main window and replace with an admin page
	private void loadAdminPage(int adminButtonNumber) {		
		if(adminButtonNumber == 11) {
			cb.mainJFrame.setContentPane(cb.adminContainer1);
		}else if(adminButtonNumber == 12) {
			cb.mainJFrame.setContentPane(cb.adminContainer2);
		}else if(adminButtonNumber == 13) {
			cb.mainJFrame.setContentPane(cb.adminContainer3);
		}else if(adminButtonNumber == 14) {
			cb.mainJFrame.setContentPane(cb.adminContainer4);
		}
		cb.mainJFrame.revalidate();
	}

}