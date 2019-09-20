package mainPackage;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import games.GamePanelTop;
import games.CoolPiesPanel;
import games.SuperMathPanel;
import mainPageListeners.AdminButtonHandler;
import mainPageListeners.ButtonHandler;
import mainPageListeners.ButtonFocusListener;
import mainPageListeners.MouseHandler;

public class ComponentBag {
	//=====================================================================================
	// User Stats Stuff
	public static UserStatsData user1Stats = new UserStatsData("User 1");
	public static String str1 = "this is str 1";
	
	//=====================================================================================
	// Data Structures
	public static ArrayList<JButton> mainPageButtonsList = new ArrayList<JButton>();
    public static ArrayList<JButton> adminButtonList = new ArrayList<JButton>();
	public static ArrayList<JButton> mainPageGameButtonsList = new ArrayList<JButton>();
    public static ArrayList<Container> adminPanelList = new ArrayList<Container>();
	public static ArrayList<GameDetailsPanel> detailsPanelList = new ArrayList<GameDetailsPanel>();
    public static ArrayList<Container> gamePanelList = new ArrayList<Container>();
    public static ArrayList<String> detailsImagePathList = new ArrayList<String>(); 
	public static Map<String,JPanel> buttonActionCommandToJPanelMap = new HashMap<String,JPanel>();
    public static Map<Integer, JPanel> detailPanelClickIdToJPanelMap = new HashMap<Integer, JPanel>();
    
	//=====================================================================================
	// Main Page GUI Components
    public static JFrame mainJFrame = new JFrame("MultiGame");
    
    public static Container mainPageMainContainer = new JPanel();

    public static JPanel mainPageTop___Container = new JPanel();
    public static JPanel mainPageMiddleContainer = new JPanel();
    public static JPanel mainPageBottomContainer = new JPanel();
    
    public static JPanel mainPageMiddleLeft = new JPanel();
    public static JPanel mainPageMiddleRight = new JPanel();
    
    // To Reside In detailsPanelList
    public static GameDetailsPanel gameDetailsPanel1 = new GameDetailsPanel(1);
    public static GameDetailsPanel gameDetailsPanel2 = new GameDetailsPanel(2);
    public static GameDetailsPanel gameDetailsPanel3 = new GameDetailsPanel(3);
    public static GameDetailsPanel gameDetailsPanel4 = new GameDetailsPanel(4);
    public static GameDetailsPanel gameDetailsPanel5 = new GameDetailsPanel(5);
    public static GameDetailsPanel gameDetailsPanel6 = new GameDetailsPanel(6);
    public static GameDetailsPanel gameDetailsPanel7 = new GameDetailsPanel(7);
    public static GameDetailsPanel gameDetailsPanel8 = new GameDetailsPanel(8);
    public static GameDetailsPanel gameDetailsPanel9 = new GameDetailsPanel(9);
    public static GameDetailsPanel gameDetailsPanel10 = new GameDetailsPanel(10);

    // To Reside In mainPageButtonsList ---
    public static JButton mainPageButton1 = new JButton("SuperMath");
    public static JButton mainPageButton2 = new JButton("CoolPies");
    public static JButton mainPageButton3 = new JButton("Stupendous\nSpaceship");
    public static JButton mainPageButton4 = new JButton("Quick Jump");
    public static JButton mainPageButton5 = new JButton("2D-Matchstick\nBowling");
    public static JButton mainPageButton6 = new JButton("DYNAMAZE");
    public static JButton mainPageButton7 = new JButton("AandPQuiz");
    public static JButton mainPageButton8 = new JButton("NotTooShabby-Vocab");
    public static JButton mainPageButton9 = new JButton("Game9");
    public static JButton mainPageButton10 = new JButton("Game10");

    public static JButton mainPageButton11 = new JButton("Stats");
    public static JButton mainPageButton12 = new JButton("Play Points");
    public static JButton mainPageButton13 = new JButton("Messages");
    public static JButton mainPageButton14 = new JButton("Settings");
    // ---
    
    public static JButton mainPageDetailsButtonLeft;
    public static JButton mainPageDetailsButtonRight;
	
	//=====================================================================================
	// Non-Main Page GUI Components
   
    public static Container adminContainer1 = new AdminStatsPanel();
    public static Container adminContainer2 = new JPanel();
    public static Container adminContainer3 = new JPanel();
    public static Container adminContainer4 = new JPanel();
        
    // To Reside in detailsPanelList
    public static Container z_SuperMathPanelTop1  = new SuperMathPanel();
    public static Container y_CoolPiesPanelTop1  = new CoolPiesPanel();
    public static Container gamePanelTop3 = new GamePanelTop();
    public static Container gamePanelTop4 = new GamePanelTop();
    public static Container gamePanelTop5 = new GamePanelTop();
    public static Container gamePanelTop6 = new GamePanelTop();
    public static Container gamePanelTop7 = new GamePanelTop();
    public static Container gamePanelTop8 = new GamePanelTop();
    public static Container gamePanelTop9 = new GamePanelTop();
    public static Container gamePanelTop10 = new GamePanelTop();
    
    // To Reside in adminButtonList - are these used?
    public static JButton adminButton1 = new JButton("back");
    public static JButton adminButton2 = new JButton("back");
    public static JButton adminButton3 = new JButton("back");
    public static JButton adminButton4 = new JButton("back");
    
	//=====================================================================================
	// Data Objects    
    
    public static Dimension dimensionOfTopAndBottom = new Dimension(800,150);
    public static Dimension dimensionOfLeftAndRight = new Dimension(150,300);
    public static Dimension dimensionOfMiddle = new Dimension(500,300);
    public static Dimension dimensionOfButton = new Dimension(140,140);
    public static Dimension dimensionOfRigidAreaForTopAndBottomMainPagePanels = new Dimension(13,0);
    public static Dimension dimensionOfTestContainer = new Dimension(800,600);
    public static Dimension dimensionOfGameContainer = new Dimension(800,600);

    public static Dimension dimensionOfGeneralButtonBar = new Dimension(0,50);
    public static Dimension dimensionOfGamePanelMiddle = new Dimension(0,750);

    public static Dimension dimensionOfDetailsArrowButtons = new Dimension(80,80);
    public static Dimension dimensionOfDetailsLabelSpacer = new Dimension(500 - 80 - 30,200);
    
    public static Dimension dimensionOfUserNameText = new Dimension(0,40);
    
	public static Point mainJFrameLocationA = new Point(0,700);
	public static Point mainJFrameLocationB  = new Point(900,400);
		
	public static Font buttonFont = new Font("ZapfDingbats", Font.PLAIN, 24);
	public static Font arrowButtonFont = new Font("TimesRoman", Font.BOLD, 84);
	public static Font userNameFont = new Font("Calibri", Font.BOLD, 26);

	
	public static int numGames = 10;
	public static int currentGameInDetailPane = 1;
	public static String currentUser = "User 1";
	public static String getCurrentUser() {
		return "User 2";
	}
	public static String getCurrentGameString() {
		if(currentGameInDetailPane == 1) {
			return "SuperMath!";
		} else {
			return "none";
		}
	}
   
	//=====================================================================================
	// Handlers and Listeners
    public static ButtonHandler mainPageButtonHandler = new ButtonHandler();
    public static AdminButtonHandler adminButtonHandler = new AdminButtonHandler();
    public static MouseHandler mainPageMouseHandler = new MouseHandler();
    public static ButtonFocusListener myFocusListener = new ButtonFocusListener();
    
	//=====================================================================================
	// Tools Object
    public static MyTools tools = new MyTools();
    
	//=====================================================================================
	// Added Functions
    public void swapMiddleContainerContents(String cmd, int buttonNumber) {
		mainPageMiddleContainer.remove(1); // remove jpanel at loc 1
		mainPageMiddleContainer.add(buttonActionCommandToJPanelMap // add jpanel to loc 1
				.get(cmd),1);
		mainPageMiddleContainer.revalidate();
		mainPageMiddleContainer.repaint();			
		currentGameInDetailPane = buttonNumber; // ##
		tools.updateMainPageButtonFocus();	
    }
    
    // returns an integer representing the game currently displayed in details panel
    public static int getCurrentGameInDetailPanel() {
    	return currentGameInDetailPane;
    }
    
    // returns JButton (supposed to return the one which will gain focus - requires caller knowledge)
    public static JButton getButtonWhichWillGainFocus(int gameButtonArrayListIndex) {
    	return mainPageGameButtonsList.get(gameButtonArrayListIndex);
    }
    
    // request focus on the button which should be focused
	public static void updateMainPageButtonFocus() {
		int gameButtonArrayListIndex = currentGameInDetailPane - 1;
		JButton buttonNewlyInFocus = mainPageGameButtonsList.get(gameButtonArrayListIndex);
		buttonNewlyInFocus.requestFocus(); 
	}
	
	// map GameDetailsPanel to a game (JPanel) and load said into main window 
	public static void loadGamePanel(GameDetailsPanel detailPanel) {
		JPanel gamePanelToLoad = detailPanelClickIdToJPanelMap.get(detailPanel.getId());
		mainJFrame.setContentPane(gamePanelToLoad);
		mainJFrame.revalidate();
		gamePanelToLoad.repaint();
	}
    
    
}





