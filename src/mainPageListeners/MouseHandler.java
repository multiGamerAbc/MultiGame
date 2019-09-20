package mainPageListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mainPackage.GameDetailsPanel;
import mainPackage.ComponentBag;

// handles mouse clicked events from gameDetailsPanels
public class MouseHandler implements MouseListener{
	ComponentBag cb = new ComponentBag();
	
	// load the appropriate game panel - (redirects)
	@Override
	public void mouseClicked(MouseEvent e) {
		loadGamePanelAssociatedWithDetailsPanelClicked(e);
	}

	// load the appropriate game panel - (redirects)
	private void loadGamePanelAssociatedWithDetailsPanelClicked(MouseEvent e) {
		GameDetailsPanel detailPanel = (GameDetailsPanel)e.getSource();
		cb.loadGamePanel(detailPanel);
	}

	// these methods are not used ---
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	// ---
}
