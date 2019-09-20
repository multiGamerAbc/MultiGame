package mainPageListeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import mainPackage.ComponentBag;

// handles button focusGained events
public class ButtonFocusListener implements FocusListener{
	ComponentBag cb = new ComponentBag();
	
	// highlight button which gained focus
	@Override
	public void focusGained(FocusEvent arg0) {
		JButton sourceButton =  ((JButton)arg0.getComponent());
		if(		   sourceButton != cb.mainPageButtonsList.get(10) 
				&& sourceButton != cb.mainPageButtonsList.get(11)  // this one was taking focus briefly, inexplicably
				&& sourceButton != cb.mainPageButtonsList.get(12)
				&& sourceButton != cb.mainPageButtonsList.get(13)) {
			sourceButton.setBorderPainted(true); 
		}		
	}

	// un-highlight buttons which has lost focus
	@Override
	public void focusLost(FocusEvent arg0) {
		JButton sourceButton =  ((JButton)arg0.getComponent());
		sourceButton.setBorderPainted(false);
	}
}