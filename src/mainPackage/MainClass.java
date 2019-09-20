package mainPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainClass {
	// access many components through this object (mostly statically, used throughout program)
    static ComponentBag cb = new ComponentBag();
	
    public static void main(String[] args) {
        populateComponentAndDataArrayLists();
        populateButtonActionCommandToJPanelMap();
        populateDetailPanelClickIdToJPanelMap();
        setupMainPageComponents();
        addMainPageComponents();
        setupGameContainers();
        
        cb.mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ##
        cb.mainJFrame.setLocation(cb.mainJFrameLocationA);
        cb.mainJFrame.setContentPane(cb.mainPageMainContainer);
        cb.mainJFrame.pack();
        cb.mainJFrame.setVisible(true); 
        cb.mainJFrame.setFocusable(true);
        cb.mainJFrame.requestFocusInWindow();        
    }
    

    // populate component and data array lists for manipulation in main function, etc.
    private static void populateComponentAndDataArrayLists() {
    	// main page game buttons list
    	cb.mainPageGameButtonsList.add(cb.mainPageButton1);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton2);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton3);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton4);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton5);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton6);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton7);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton8);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton9);
    	cb.mainPageGameButtonsList.add(cb.mainPageButton10); 
    	// main page all buttons list
    	cb.mainPageButtonsList.add(cb.mainPageButton1);
    	cb.mainPageButtonsList.add(cb.mainPageButton2);
    	cb.mainPageButtonsList.add(cb.mainPageButton3);
    	cb.mainPageButtonsList.add(cb.mainPageButton4);
    	cb.mainPageButtonsList.add(cb.mainPageButton5);
    	cb.mainPageButtonsList.add(cb.mainPageButton6);
    	cb.mainPageButtonsList.add(cb.mainPageButton7);
    	cb.mainPageButtonsList.add(cb.mainPageButton8);
    	cb.mainPageButtonsList.add(cb.mainPageButton9);
    	cb.mainPageButtonsList.add(cb.mainPageButton10);
    	cb.mainPageButtonsList.add(cb.mainPageButton11);
    	cb.mainPageButtonsList.add(cb.mainPageButton12);
    	cb.mainPageButtonsList.add(cb.mainPageButton13);
    	cb.mainPageButtonsList.add(cb.mainPageButton14);
    	// detail panel list
    	cb.detailsPanelList.add(cb.gameDetailsPanel1);
    	cb.detailsPanelList.add(cb.gameDetailsPanel2);
    	cb.detailsPanelList.add(cb.gameDetailsPanel3);
    	cb.detailsPanelList.add(cb.gameDetailsPanel4);
    	cb.detailsPanelList.add(cb.gameDetailsPanel5);
    	cb.detailsPanelList.add(cb.gameDetailsPanel6);
    	cb.detailsPanelList.add(cb.gameDetailsPanel7);
    	cb.detailsPanelList.add(cb.gameDetailsPanel8);
    	cb.detailsPanelList.add(cb.gameDetailsPanel9);
    	cb.detailsPanelList.add(cb.gameDetailsPanel10);
    	// game panel list
    	cb.gamePanelList.add(cb.z_SuperMathPanelTop1);
    	cb.gamePanelList.add(cb.y_CoolPiesPanelTop1);
    	cb.gamePanelList.add(cb.gamePanelTop3);
    	cb.gamePanelList.add(cb.gamePanelTop4);
    	cb.gamePanelList.add(cb.gamePanelTop5);
    	cb.gamePanelList.add(cb.gamePanelTop6);
    	cb.gamePanelList.add(cb.gamePanelTop7);
    	cb.gamePanelList.add(cb.gamePanelTop8);
    	cb.gamePanelList.add(cb.gamePanelTop9);
    	cb.gamePanelList.add(cb.gamePanelTop10);
    	// admin panel list
    	cb.adminPanelList.add(cb.adminContainer1);
    	cb.adminPanelList.add(cb.adminContainer2);
    	cb.adminPanelList.add(cb.adminContainer3);
    	cb.adminPanelList.add(cb.adminContainer4);
    	// admin button list
    	cb.adminButtonList.add(cb.adminButton1);
    	cb.adminButtonList.add(cb.adminButton2);
    	cb.adminButtonList.add(cb.adminButton3);
    	cb.adminButtonList.add(cb.adminButton4);
    	// detail image path list
    	cb.detailsImagePathList.add("resources\\A_superMathDetailImg.jpeg");
    	cb.detailsImagePathList.add("resources\\A_CoolPies1.png");
    	cb.detailsImagePathList.add("resources\\A_StupendousSpaceship1.png");
    	cb.detailsImagePathList.add("resources\\A_QuickJump1.png");
    	cb.detailsImagePathList.add("resources\\A_2dMatchstickBowling.png");
    	cb.detailsImagePathList.add("resources\\A_Dynamaze1.png");
    	cb.detailsImagePathList.add("resources\\A_AandPQuiz1.png");
    	cb.detailsImagePathList.add("resources\\A_NotTooShabby2.jpeg");
    	cb.detailsImagePathList.add("resources\\A_Game9_1.png");
    	cb.detailsImagePathList.add("resources\\A_Game10_1.png");
    }
    
    // populate map so other functions will know where action originated
    private static void populateButtonActionCommandToJPanelMap() {
    	// add main page button action commands to their map
        for(int i = 1 ; i <= 10 ; i++) {
        	cb.buttonActionCommandToJPanelMap.put("mainPageButton" + i, 
        				cb.detailsPanelList.get(i-1));
        }
        // add admin button action commands to their map
        for(int i = 1 ; i <= 4 ; i++) {
        	cb.buttonActionCommandToJPanelMap.put("adminButton" + i, (JPanel)cb.mainPageMainContainer);
        }
    }
    
	// associate each detail panel (when clicked) with a game panel
    private static void populateDetailPanelClickIdToJPanelMap() {
    	for(int i = 1 ; i <= 10 ; i++) {
    		cb.detailPanelClickIdToJPanelMap.put(i,(JPanel)cb.gamePanelList.get(i-1));
    	}
    }
    
    // setup main page GUI components
    private static void setupMainPageComponents() {
    	// setup main page containers/sub-containers
        cb.mainPageMainContainer.setLayout(new BoxLayout(cb.mainPageMainContainer, BoxLayout.Y_AXIS));
    	
        cb.mainPageTop___Container.setPreferredSize(cb.dimensionOfTopAndBottom);
        cb.mainPageTop___Container.setBackground(Color.BLACK);

        cb.mainPageMiddleContainer.setBackground(Color.BLACK);
        cb.mainPageMiddleContainer.setLayout(new BoxLayout(cb.mainPageMiddleContainer, BoxLayout.X_AXIS));

        cb.mainPageBottomContainer.setPreferredSize(cb.dimensionOfTopAndBottom);
        cb.mainPageBottomContainer.setBackground(Color.BLACK);

        cb.mainPageMiddleLeft.setPreferredSize(cb.dimensionOfLeftAndRight);
        cb.mainPageMiddleLeft.setBackground(Color.BLACK);

        cb.mainPageMiddleRight.setPreferredSize(cb.dimensionOfLeftAndRight);
        cb.mainPageMiddleRight.setBackground(Color.BLACK);
        
        // populate detail panels (one shown at a time) with images from disk
        for(int i = 1 ; i <= 10 ; i++) {
        	cb.tools.readAndScaleImageAndAddToJPanel(cb.detailsImagePathList.get(i-1),
        			(JPanel)cb.detailsPanelList.get(i-1),
        			cb.dimensionOfMiddle.width,
        			cb.dimensionOfMiddle.height);
        }

        // setup details panels
        for(GameDetailsPanel detailPanel : cb.detailsPanelList) {
        	detailPanel.setPreferredSize(cb.dimensionOfMiddle);
        	detailPanel.setBackground(Color.BLACK);
        	detailPanel.addMouseListener(cb.mainPageMouseHandler);
        }

        // setup main page buttons
        for(JButton button : cb.mainPageButtonsList) {
        	button.setBackground(Color.BLACK);
        	button.setBorderPainted(false);
        	button.setBorder(new LineBorder(Color.CYAN));
        	button.setFocusPainted(false);
        	button.setFont(cb.buttonFont);
        	button.setPreferredSize(cb.dimensionOfButton);
        	button.setForeground(Color.WHITE);
        	button.setMargin(new Insets(0,0,0,0));
        	button.addFocusListener(cb.myFocusListener);
        }
        
    	// setup admin containers
    	for(Container adminPanel : cb.adminPanelList) {
    		adminPanel.setPreferredSize(cb.dimensionOfTestContainer);
    		adminPanel.setBackground(Color.BLACK);
    	}

    	// add action listener to admin buttons
    	cb.adminButton1.addActionListener(cb.adminButtonHandler);
    	cb.adminButton2.addActionListener(cb.adminButtonHandler);
    	cb.adminButton3.addActionListener(cb.adminButtonHandler);
    	cb.adminButton4.addActionListener(cb.adminButtonHandler);

    	// add admin buttons to admin containers
    	//cb.adminContainer1.add(cb.adminButton1);
    	cb.adminContainer2.add(cb.adminButton2);
    	cb.adminContainer3.add(cb.adminButton3);
    	cb.adminContainer4.add(cb.adminButton4);
    }
    
    // properly nest GUI components within one-another for display
    private static void addMainPageComponents() {
    	// add containers to main page main container
        cb.mainPageMainContainer.add(cb.mainPageTop___Container);
        cb.mainPageMainContainer.add(cb.mainPageMiddleContainer);
        cb.mainPageMainContainer.add(cb.mainPageBottomContainer);
         
    	// add containers to main page middle container
        cb.mainPageMiddleContainer.add(cb.mainPageMiddleLeft);
        cb.mainPageMiddleContainer.add(cb.gameDetailsPanel1);
        cb.mainPageMiddleContainer.add(cb.mainPageMiddleRight);
        
        // Add handler to all main page buttons and set action commands
        for(int i = 0 ; i < 14 ; i++) {
        	cb.mainPageButtonsList.get(i).addActionListener(cb.mainPageButtonHandler);
        	cb.mainPageButtonsList.get(i).setActionCommand("mainPageButton" + (i+1));
        }
 
        // Add main page buttons to respective JPanels and space with rigid areas ---
        cb.mainPageTop___Container.add(cb.mainPageButton1);
        cb.mainPageTop___Container.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageTop___Container.add(cb.mainPageButton2);
        cb.mainPageTop___Container.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageTop___Container.add(cb.mainPageButton3);
        cb.mainPageTop___Container.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageTop___Container.add(cb.mainPageButton4);
        cb.mainPageTop___Container.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageTop___Container.add(cb.mainPageButton5);        
        
        cb.mainPageBottomContainer.add(cb.mainPageButton6);
        cb.mainPageBottomContainer.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageBottomContainer.add(cb.mainPageButton7);
        cb.mainPageBottomContainer.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageBottomContainer.add(cb.mainPageButton8);
        cb.mainPageBottomContainer.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageBottomContainer.add(cb.mainPageButton9);
        cb.mainPageBottomContainer.add(Box.createRigidArea(cb.dimensionOfRigidAreaForTopAndBottomMainPagePanels));
        cb.mainPageBottomContainer.add(cb.mainPageButton10);
        
        cb.mainPageMiddleLeft.add(cb.mainPageButton11);
        cb.mainPageMiddleLeft.add(cb.mainPageButton13);
        
        cb.mainPageMiddleRight.add(cb.mainPageButton12);
        cb.mainPageMiddleRight.add(cb.mainPageButton14); 
        // ---
    }
    
    // give all the game containers the proper size
    private static void setupGameContainers() {
    	for(Container gamePanel :cb.gamePanelList) {
    		gamePanel.setPreferredSize(cb.dimensionOfGameContainer);
    	}
    }
    
}

//Notes:

// numGames, etc
// rename detailPanelClickIdToJPanelMap
// jar resources

// Eclipse:


//// TEMP for cool pies dev
//public static void loadCoolPies() {
//    JPanel panelToLoad = (JPanel)cb.y_CoolPiesPanelTop1;
//	cb.mainJFrame.setContentPane(panelToLoad);
//	cb.mainJFrame.revalidate();
//	panelToLoad.repaint();
//}




