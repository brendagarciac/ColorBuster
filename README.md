# ColorBuster
Introduction
The Color Buster game is a fun, interactive desktop application where tiles that match with the same color explode, 
creating new ones until no more matches are available in the board. The game was developed using the Java programming language 
on the software IntelliJ, following the MVC architecture.

Changes to source code
There were several changes that had to be made to the source code that was provided by the professor in order to piece together 
the layers of the application. One of the first changes made were the tile images, which were changed to colored tiles 
with diamonds inside to customize the game to my preference. In the Board Model, a private attribute for the match size was added 
so that the number would not stay hard coded, and an instance of the Board class would be created with a certain match size 
that is either default or selected by the user. In the BoardView class the processTouchedTile() method was implemented. 
Within this method, the code necessary to identify the number of matches found surrounding the tile touched was implemented. 
If this number was greater than, or equals to the match size of the game, the matching tiles would be removed, the rest would 
collapse, the score would increase by a multiple of 20, and lastly, the board would update. In the case that the number of tiles 
surrounding the tile touched was less than the match size, an error message would pop up notifying the user that the move was 
invalid. The ButtonView class had an extra method added to it so that every time the New Game button was clicked the value of 
the level selector dropdown would change to that of the match size, which by default is 3. It is to be noted that this particular 
method was implemented to address this particular issue that I was having with the way I designed my application. The ScoreView 
was also added another label to display the player’s name, as well as a method to update the label based on the name entered in 
the main screen of the game. The MainScreenView is a view that I created from scratch to provide the user with a welcome screen. 
This screen has a welcome message, as well as a text field to enter one’s name, and a dropdown to change size of the board by
rows and columns. Lastly, by clicking on the “Play” button, this screen closes and the view of the game is shown. In the GameView
class the isMoveAvailable() and processTouchedTile() classes were mainly further developed, delegating to each corresponding view 
the implantation of each function. The GameController class implements the listeners that take part in the game: such as the
changing of level (min match size), clicking on the new game button, and touching a tile.

Functionalities added
One of the main functionalities added to my implementation of the ColorBuster game were the main screen that welcomes
users to the game, displays a dropdown to select from the three options of board size based on rows times columns, and 
asks user to enter their name. If the player does not enter anything in the textbox, a pop up shows up warning the user
that in order to play, they need to enter something for the field. Once the player clicks on the Play button in the main menu,
this screen is removed from the view, and the game’s screen becomes visible for the user to play. In this view, I added at the 
top another label next to the score to also reflect the player’s name as it was entered in the main screen. Additionally, the
game does get created based on the board size selection that the user makes at the start of the game as well.
