package mainPageListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainPackage.ComponentBag;

// handles button click events from 'Back' button in the 'admin' pages
public class AdminButtonHandler implements ActionListener {
	ComponentBag cb = new ComponentBag();
	// navigate back to main GUI page
	@Override
	public void actionPerformed(ActionEvent arg0) {
		cb.mainJFrame.setContentPane(cb.mainPageMainContainer); 
		cb.tools.updateMainPageButtonFocus();
	}
}