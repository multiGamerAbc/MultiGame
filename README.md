# MultiGame

README For MultiGame System

I have three videos included above: a demonstration of the application, an install and run guide, and a code walkthrough.

(This was a project for a Software Engineering course.  The focus was on documentation, requirements engineering,
validation, verification, diagrams... that sort of thing.  It was not intended for us to focus too heavily on coding,
or even on completing all the requirements, since we "elicited" our own requirements.  It is still a working application
with a GUI, including a simple animated video game and a simple math quiz.  Please take a look.)

To install and run the MultiGame system:
1) Download and unzip the zip file I submitted for the project.
2) Inside you'll find a folder titled "MultiGameSystem".  Open this folder.
3) Open the Eclipse IDE.  Navigate to the Package Explorer view.
4) Right-click and select new → project.
5) Select Java→Java Project and click Next.
6) Name your new project "MultiGame".  Click Finish.
7) In the MultiGameSystem folder in your OS file browser highlight and copy both the "src" and the "resources" folders.
8) In Eclipse, right-click on the "MultiGame" project in the Package Explorer.  Choose Paste.
9) If you are prompted "Do you wish to overwrite" for "MultiGame/src" and/or "MultiGame/resources", choose Overwrite All.
10) In the Package Explorer navigate to MultiGame→src→mainPackage and double-click to open "MainClass.java".  Click the green 
and white Run button on the toolbar (or press ctrl + F11) to run MultiGame.
Please note: if you do not see the MultiGame window you might be able to alter its starting location by adjusting the following
line in the main() method of the MainClass class.  Try changing 
        cb.mainJFrame.setLocation(cb.mainJFrameLocationA);
to
        cb.mainJFrame.setLocation(cb.mainJFrameLocationB);
To use the MultiGame system:
Run the MultiGame system.  The main page GUI shows up with game buttons along the top and bottom, "admin" buttons on the sides, 
and game details panels shown in the center.  Click the game buttons, or alternatively click the "<" and ">" arrow buttons to 
view the different game details.  To navigate to a game click on the details panel for that game.  To navigate to an "admin" 
page click on the corresponding "admin" button.
The games which have been implemented include SuperMath and CoolPies, and the only implemented "admin" page is the "Stats" page.
To play SuperMath click the SuperMath details panel and click "New Game" in the game page.  You'll be presented with a simple 
addition quiz problem.  Enter your answer and click "enter" to do the next problem.  Continue in this fashion until ten problems 
have been solved and you will be shown your results.  Results will also be logged on the "stats" page.  To discard a game of 
SuperMath before completing the quiz click the "Discard Game" button.  The score will not be logged.  Click the "Back" button 
to return to the main GUI page.  Your results can be viewed on the "stats" page.
To play CoolPies click the CoolPies details panel.  Once in the game page, press the 'p' key on your keyboard to unpause the game.  You'll be bombarded with incoming pies.  Use the left, right, and down arrow keys to move about or stay still, and use the spacebar to jump.  When you touch a cool pie your score goes up but if you touch a hot pie your score goes down.  Your score and health will be displayed in the game panel.  You can press 'p' to pause the game.  The "Discard Game", "New Game", and "Pause" buttons are not functional and game results are not logged.  Pressing the "Back" button will navigate you back to the main GUI page.

