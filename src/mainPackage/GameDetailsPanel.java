package mainPackage;

import javax.swing.JPanel;

// sub-classing is for the Id and understandability.  These are
//  displayed in main GUI
public class GameDetailsPanel extends JPanel  {
	private int id;
	
	public GameDetailsPanel(int id) {
		this.id = id;
	}
	// return this panel's id
	public int getId() {
		return id;
	}
}
