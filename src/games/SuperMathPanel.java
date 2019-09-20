package games;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mainPackage.ComponentBag;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

// administer one or more simple addition quizzes and log results
public class SuperMathPanel extends JPanel{
	ComponentBag cb;
	ButtonBar  buttonBar;
	GamePanelMiddle gamePanelMiddle;
	MyGamePanelButtonHandler myGamePanelButtonHandler = new MyGamePanelButtonHandler();
	AnswerSubmissionListener answerSubmissionListener = new AnswerSubmissionListener();
	Random rand = new Random();
	Quiz quiz = new Quiz();
	boolean gameInProgress = false;
	
	//====================================================================================
	// Constructor
	//====================================================================================
	
	// set things up for the game panel
	public SuperMathPanel() {
		cb = new ComponentBag();
		buttonBar = new ButtonBar();
		gamePanelMiddle = new GamePanelMiddle();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		buttonBar.setPreferredSize(new Dimension(0,50));
		gamePanelMiddle.setPreferredSize(new Dimension(0,750));
		add(buttonBar);
		add(gamePanelMiddle);
	}	
	
	//====================================================================================
	// Quiz and Quiz-Related Classes and Methods
	//====================================================================================
	
	// a class for data associated with a single quiz
	public class Quiz{
		ArrayList<AdditionQuizProblem> problemList;
		int numProblems = 10;
		int numCorrect = 0;
		int currentProblem = 1;
		// populate problemList
		public Quiz() {
			problemList = createListOfAdditionQuizProblems();
		}
		// display first problem
		public void startQuiz() {
			problemList.get(currentProblem-1).displayProblem();
		}
		// create a list of simple addition problems
		public ArrayList<AdditionQuizProblem> createListOfAdditionQuizProblems(){
			ArrayList<AdditionQuizProblem> problemList = new ArrayList<AdditionQuizProblem>();
			for(int i = 1 ; i <= 10 ; i++) {
				problemList.add(new AdditionQuizProblem(i));
			}
			return problemList;
		}
		// grade this problem.  if last in quiz, finish, else display next problem
		public void gradeThisProblemAndDisplayTheNextOrDisplayResultsOrFinish(String response) {
			if(currentProblem >= 1 && currentProblem <= numProblems) {
				try {
					int answer = Integer.parseInt(response);				
					if(answer == problemList.get(currentProblem - 1).operandA
							+ problemList.get(currentProblem - 1).operandB) {
						numCorrect++;
					}
				} catch (Exception exc) {}
			}
			currentProblem++;
			if(currentProblem == 11) { // Quiz completed, display the results
				displayAndLogResults();
			} else if(currentProblem == 12) { // Quiz completed, results already viewed
				discardGame();
			} else {
				problemList.get(currentProblem-1).displayProblem();
			}
		}
		// log and display quiz results
		public void displayAndLogResults() {
			JPanel resultsPanel = new JPanel();
			resultsPanel.setPreferredSize(new Dimension(800,60));
			resultsPanel.setBackground(Color.CYAN);
			String resultsString = "You answered "  + numCorrect + " out of " + numProblems + " correctly.";
			JTextField resultsText = new JTextField(
					"You answered "  + numCorrect + " out of " + numProblems + " correctly.");
			Date d = new Date();
			long t = d.getTime();
			Timestamp ts = new Timestamp(t);
			
			String result = resultsText + " " + ts;
			resultsPanel.add(resultsText );
			gamePanelMiddle.add(resultsPanel);
			gamePanelMiddle.revalidate();
			cb.user1Stats.addStatistic("SuperMath", resultsString + " " + ts);
		}
		// one simple addition problem, associated problem number, displayProblem method
		public class AdditionQuizProblem{
			JTextField problemNumberAndStatement;
			JTextField input;
			JButton submit;
			JPanel problemPanel = new JPanel();
			int operandA, operandB;
			public AdditionQuizProblem(int problemNumber){
				problemPanel.setPreferredSize(new Dimension(800,40));
				problemPanel.setBackground(Color.BLUE);
				operandA = (int)(Math.random() * 10) + 1;
				operandB = (int)(Math.random() * 10) + 1;
				problemNumberAndStatement 
					= new JTextField(problemNumber + ") " + operandA + " + " + operandB + "  = ");
				input = new JTextField(5);
				input.addActionListener(answerSubmissionListener);
				problemPanel.add(problemNumberAndStatement);
				problemPanel.add(input);
			}
			public void displayProblem() {
				gamePanelMiddle.add(problemPanel);
				gamePanelMiddle.revalidate();
				input.requestFocus();
			}
		}
	}
	
	// discard current game, don't log results
	private void discardGame() {
		gamePanelMiddle.removeAll();
		gamePanelMiddle.revalidate();
		gamePanelMiddle.repaint();
		gameInProgress = false;
	}

	//====================================================================================
	// ActionListeners
	//====================================================================================
	
	// answer (input) field 'enter' event handler
	public class AnswerSubmissionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			quiz.gradeThisProblemAndDisplayTheNextOrDisplayResultsOrFinish(e.getActionCommand());
		}
	}
	
	// handles button clicked events from buttons in buttonBar
	public class MyGamePanelButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String cmd = arg0.getActionCommand();
			if(cmd.compareTo("Back") == 0) {  // return to main GUI page
				cb.mainJFrame.setContentPane(cb.mainPageMainContainer); 
				cb.tools.updateMainPageButtonFocus();
			} else if (cmd.compareTo("Discard Game") == 0) {
				discardGame();
			} else if (cmd.compareTo("New Game") == 0) {
				startGame();
			} else if (cmd.compareTo("Pause") == 0) {
				// "Pause" is not functional in this "game"
			}
		}
		
		// take a new math quiz
		private void startGame() {
			if(!gameInProgress) {
				gameInProgress = true;
				quiz = new Quiz();
				quiz.startQuiz();
			} else {
				// toast?
				// get focus back to input field, maybe
			}
		}
	}
	
	//====================================================================================
	// User Interface Component Classes
	//====================================================================================
	
	// JPanel Where The Quiz Is Displayed
	protected static class GamePanelMiddle extends JPanel{
		public GamePanelMiddle() {
			setBackground(new Color(12, 170, 194));
		}
		
		@Override
		public void paintComponent(Graphics g) {
	        super.paintComponent(g);
		}
	}
	// JPanel That Holds The Buttons At The Top
	protected class ButtonBar extends JPanel{
		JButton backButton 			= new JButton("Back");;
		JButton discardGameButton   = new JButton("Discard Game");;
		JButton newGameButton 		= new JButton("New Game");
		JButton pauseButton 		= new JButton("Pause");
		JTextField userNameText		= new JTextField();
		
		// display current game name and userName
		@Override
		public void paintComponent(Graphics g) {		
			g.setFont(cb.userNameFont);
			g.drawString(cb.getCurrentGameString(), 10, 28);
			g.drawString(cb.getCurrentUser(), 670, 28);
		}
		
		// set things up for the ButtonBar
		public ButtonBar(){
			cb = new ComponentBag();
			setBackground(Color.DARK_GRAY);
			backButton.setPreferredSize(new Dimension(125,35));
			discardGameButton.setPreferredSize(new Dimension(125,35));
			newGameButton.setPreferredSize(new Dimension(125,35));
			pauseButton.setPreferredSize(new Dimension(125,35));
			
			backButton.addActionListener(myGamePanelButtonHandler);
			discardGameButton.addActionListener(myGamePanelButtonHandler);
			newGameButton.addActionListener(myGamePanelButtonHandler);

			add(backButton);
			add(discardGameButton);
			add(newGameButton);
			add(pauseButton);
		}
	}
}

//fix user name view

