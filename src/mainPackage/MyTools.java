package mainPackage;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyTools {
	//=================================================================================================
	// tools and objects specific for MultiGame use
	
	static ComponentBag cb = new ComponentBag();
	
	// make sure the appropriate main page button is highlighted
	public static void updateMainPageButtonFocus() {
		int buttonNumber = cb.getCurrentGameInDetailPanel();
		int gameButtonArrayListIndex = buttonNumber - 1;
		JButton buttonNewlyInFocus = cb.getButtonWhichWillGainFocus(gameButtonArrayListIndex);
		buttonNewlyInFocus.requestFocus(); 
	}
	
	// read image from file, scale, and add to a JPanel
	public static void readAndScaleImageAndAddToJPanel(String imagePath, JPanel panel, int xScale, int yScale) {
		BufferedImage bufImg;
		try {
			File file = new File(imagePath);
			bufImg = ImageIO.read(file);
			Image bufImgScaled = bufImg.getScaledInstance(xScale, yScale, 0);
			ImageIcon imgIcon = new ImageIcon(bufImgScaled);
			JLabel imgLabel = new JLabel(imgIcon);
			addTheArrowButtonsToJLabel(imgLabel);
			panel.add(imgLabel);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//=================================================================================================
	// general use tools
	
	// System.out.println shortcut
	public static void prl(Object o) {
		System.out.println(o);
	}
	
	// sleep for one second
	public static void doSleep() {
        try {
        Thread.sleep(1000);
        } catch(Exception exc) {
        	exc.printStackTrace();
        }
	}

	// sleep for k milliseconds
	public static void doSleep(int k) {
        try {
        Thread.sleep(k);
        } catch(Exception exc) {
        	exc.printStackTrace();
        }
	}
	
	// get the string index of first digit in string, or -1
	public static int indexOfFirstDigit(String str) {
		for(int i =0 ; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				return i;
			}
		}
		return -1;
	}

	// get the first integer from a string which contains an integer as character sequence
	public static int readFirstIntegerFromString(String str) {
		String integerString = str.substring(indexOfFirstDigit(str));
		int result = Integer.parseInt(integerString);
		return result;
	}

	//=================================================================================================
	// private for MultiGame specific MyTools methods
	
	// add the arrow buttons to a specific JLabel (which contains details for one game)
	private static void addTheArrowButtonsToJLabel(JLabel imgLabel) {
		imgLabel.setLayout(new BoxLayout(imgLabel,BoxLayout.X_AXIS));
		
		cb.mainPageDetailsButtonLeft = new JButton("<");
		cb.mainPageDetailsButtonLeft.addActionListener(cb.mainPageButtonHandler);
		cb.mainPageDetailsButtonLeft.setPreferredSize(cb.dimensionOfDetailsArrowButtons);
		cb.mainPageDetailsButtonLeft.setMargin(new Insets(1,1,1,1));
		cb.mainPageDetailsButtonLeft.setBackground(new Color(0,0,0,0));
		cb.mainPageDetailsButtonLeft.setBorderPainted(false);
		cb.mainPageDetailsButtonLeft.setFocusPainted(false);
		cb.mainPageDetailsButtonLeft.setFont(cb.arrowButtonFont);
		cb.mainPageDetailsButtonLeft.setForeground(Color.CYAN);
		cb.mainPageDetailsButtonLeft.setRolloverEnabled(false);

		cb.mainPageDetailsButtonRight = new JButton(">");
		cb.mainPageDetailsButtonRight.addActionListener(cb.mainPageButtonHandler);
		cb.mainPageDetailsButtonRight.setPreferredSize(cb.dimensionOfDetailsArrowButtons);
		cb.mainPageDetailsButtonRight.setMargin(new Insets(1,1,1,1));
		cb.mainPageDetailsButtonRight.setBackground(new Color(0,0,0,0));
		cb.mainPageDetailsButtonRight.setBorderPainted(false);
		cb.mainPageDetailsButtonRight.setFocusPainted(false);
		cb.mainPageDetailsButtonRight.setFont(cb.arrowButtonFont);
		cb.mainPageDetailsButtonRight.setForeground(Color.CYAN);
		cb.mainPageDetailsButtonRight.setRolloverEnabled(false);

		imgLabel.add(cb.mainPageDetailsButtonLeft);
		imgLabel.add(Box.createRigidArea(cb.dimensionOfDetailsLabelSpacer));
		imgLabel.add(cb.mainPageDetailsButtonRight);
	}
}