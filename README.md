# DiceGame will play a game called 24.

**Copyright © 2021 Bradley M. Small**

## **Rules**

The rules are simple enough. Simply roll the dice and hold at least one die per roll. When you hold the last die, the
game is complete. In order to score you must retain at least one die with a value of 2 and one die with a value of 4.
Your final score is the sum of the other four dice. For example 2,4,6,6,6,6 is a perfect score of 24. While 6,6,6,6,6,6
is zero because you have not held both a 2 and a 4.

## **Code**

The source code is Java. App and DiePanel contain the code for the GUI Application. DiceGame, Die, and Hand contain the
code for the game logic itself. Development of the game used TDD, and the tests are in DiceGameTest. Once GUI
development began, it was a goal to keep the game logic separate from the GUI logic as much as possible. It is my goal
to create a WebUI and a TextUI to this game that will work without modification to the game code itself.

## **Suggestions**

This code is intended as an exercise for me to apply my learning of Java. I am quite open to suggestions and
recommendations for improvement.

## **License**

If you wish to use any of this code for personal and/or educational purposes you may freely do so as long as you do not
claim it as your own. Give a guy a little credit if you use his work.

If you wish to make money with this code, such as publishing it in a tutorial or making a salable product I want a cut
of the action. As unlikely as this may be, simply contact me, so we can work out the details. 
