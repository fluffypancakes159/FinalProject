# FinalProject
## By Alwin Peng and Ciaran Diep, Team 814

Welcome to **Into the Den of Snakes**, a RPG set in the one and only Stuyvesant High School!
> This is a work of fiction. Names, characters, businesses, places, events, locales, and incidents are either the products of the authors’ imagination or used in a fictitious manner. Any resemblance to actual persons, living or dead, or actual events is purely coincidental.
> Also no offense is intended in any way from anything in this game.

In this game, there are many things to do, but most important of them all is to fix your Advanced Placement Computer Science grade! You will do a multitude of things in this adventure throught Stuyvesant to figure out where in the world Mr. Konstantinovich went so you can harass him about your "unfair" 98 test score.

## How to Use the Game

When you import the repository, compile using `javac *.java`.

When you are about to run the code using `java Game`, you will need a parameter after Game. The possible inputs are:

- `java Game game`, which starts the introductory cutscene.
- `java Game battle`, which is a sandbox mode to allow you to simulate a battle.
- `java Game codebattle`, which allows you to test your Python skills (yes I know this is Java code in a Java course, but whatever)

Any other input and Java will yell at you.

## How to Play the Game

This game is based around menu navigation, and you will do this by inputting **only a single number** to pick a choice. There are countermeasures to incorrect inputs, but please don't intentionally misuse the menus (unless you're Mr. K, in which case by all means), because it hurts their feelings. 

Menus such as these will appear:

1. Go up
2. Go down
3. Go right
4. Go to sleep

And let's say you want to go to sleep. You would enter in `4`, **not** `5`, but `4`.

## Battling

Oh dear, you've entered a battle! Here's a basic tutorial for a basic battle system:

When you're battling, you have 3 options: 

- Poking
- Kicking
- Item

Poking is just a basic attack based on your equipped weapon.

Kicking is a stronger attack, but it leaves you on cooldown for the next attack.

Items allows you to heal yourself using a restorative item during battle. The way the battle system is structured, you can use items while on cooldown, so maximize your damage by kicking before healing!

### Stats

The stats are as follows:

- HP: amount of damage you can take before you die
- ATK: amount of damage you deal
- DEF: amount of damage you reduce
- SPD: determines who goes first (player gets precedence)

When you level up, each stat increases randomly from an amount between 1 and 3 and you are fully healed.

## Code Battling

**IMPORTANT: CODE BATTLING NEEDS GEDIT TO BE RUNNABLE FROM THE TERMINAL USING THE `gedit` KEYWORD TO WORK**

**ALSO PYTHON NEEDS TO BE RUNNABLE USING `python`**

Code Battling tests your knowledge of Python using Java code. When you enter a code battle, a gedit window will open, and your job is to write correct Python code based on the question given.

In order to submit the code, you must close the window. If the code works, then you will move on with your life. But if not, then the window will reopen and you will have to try again.