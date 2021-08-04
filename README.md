# Quiz-app
Chat interactive quiz mobile application where questions are based on fundamentals of software engineering and various models such as RAD model, Waterfall model, Agile, etc.
The user will experience a communicative and professional experience to learn about the office work ethics and ways. <br><br>
This chat interactive application that focuses on the questions based on the fundamentals of software engineering and various models such as RAD model, Waterfall model, Agile, etc. on Android Studios in Java.<br>
Once the user starts the application, the landing page will be is the splash screen – where the user has to click on the start button to continue. <br>
Splash Screen directs the user to the Start Screen where the user has to begin the game from newbie level which is the first level of the three level quiz game.

![alt text](https://github.com/khyaati26/Quiz-app/blob/main/img/start.JPG?raw=true) 

In all the levels, the user will have chat interaction wherein they will face questions and they have to select one of the four options.

![alt text](https://github.com/khyaati26/Quiz-app/blob/main/img/level1.JPG?raw=true) 

In the Newbie level, user will experience chat interaction and then will face easy level questions. <br> 
In the newbie level, the user need to answer 10 set of questions each having 5 marks. In case the user fails to score 20 marks, they will again go through set of questions. <br>	
Once they clear newbie level, they will be guided to the next level – Intermediate level. <br> 
Intermediate level will have more number of questions with increased difficulty and the user needs to answer 15 set of questions each having 5 marks. <br>
In case they fails to score 30 marks, the round will restart. Once the user qualifies the minimum number of questions, they will be directed to the Expert level <br>
These set of questions will keep on shuffling as it is implemented using Random class and after every level, the results will be displayed.

To change the new questions: Questions are stored using Array<string> class in the format where questions and answers are in the format. <br> 
{"Question", "Right Answer", "Choice1", "Choice2", "Choice3"}. We need to update each level levelname_main.java file,
 for update in newbie level, <br> Open Newbie_main.java file, <br>Go to String level1[][] = {} where other questions are already uploaded. <br>Here, update question in the above format
