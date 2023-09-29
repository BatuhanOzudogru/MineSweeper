import java.util.Scanner;
public class MineSweeper {
    int row; // Represents the number of rows on the game board.
    int column; // Represents the number of columns on the game board.
    int mines; // Represents the number of mines on the game board.
    String[][] gameBoard; // Represents the mine map as a 2D array.
    String[][] playerBoard; // Represents the player's game board as a 2D array.
    int winCondition; // Represents the number of moves required to win the game.
    boolean isOver ; // Flag to indicate if the game is over.
    boolean isWin; // Flag to indicate if the game is won.
    int counter;

    MineSweeper(int row, int column){
        this.row=row;
        this.column=column;
        this.mines=(row*column)/4;
        this.winCondition=(row*column)-(((row*column))/4);
        isOver = false;
        isWin=false;
        setGameBoard();
        playerBoard();
        placeMines();
        System.out.println("---Mine map---");
        print(gameBoard);
        System.out.println("---Game Map---");
        print(playerBoard);
    }
    public void setGameBoard(){   // Initializes the game board with "-" characters.
        this.gameBoard = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                gameBoard[i][j] = "-";
            }
        }
    }
    // Değerlendirme Formu 7
    public static void start(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to MineSweeper game");
        System.out.println("Please enter the size you want to play");
        System.out.print("Row Number : ");
        int rowNumber=input.nextInt(); // Request the number of rows from the user.
        System.out.print("Column Number : ");
        int columnNumber=input.nextInt();  // Request the number of columns from the user.
        if (rowNumber>1&&columnNumber>1){
            MineSweeper mineSweeper = new MineSweeper(rowNumber,columnNumber); // Create a MineSweeper game instance with the user-defined grid size.
            mineSweeper.run();
        }
    }
    //Değerlendirme Formu 8
    public void placeMines(){  // Randomly places mines on the game board.
        int minesPlaced=0;
        while(minesPlaced<mines){
            int randomRow=(int)(Math.random()*row);
            int randomColumn=(int)(Math.random()*column);
            if (!gameBoard[randomRow][randomColumn].equals("*") ) {
                gameBoard[randomRow][randomColumn] = "*";
                minesPlaced++;
            }
        }
    }

    public void print(String[][] arr){  // Prints a 2D array to the console.
        for (int i = 0; i <row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void playerBoard(){   // Creates the player's game board based on the mine map.
        this.playerBoard = new String[row][column];
        for (int i = 0; i < gameBoard.length; i++) {
            for(int j=0;j< gameBoard[i].length;j++){
                playerBoard[i][j]=(gameBoard[i][j]);
            }
        }
    }
    //Değerlendirme Formu 9
    public void run(){   // Runs the game loop, allowing the player to make selections.
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("=========================");
            System.out.print("Row no "+"(1"+"-"+row+") : ");
            int row=input.nextInt();
            System.out.print("Column no "+"(1"+"-"+column+") : ");
            int column=input.nextInt();
            select(row,column);
            print(playerBoard);
        }while(!isOver&&!isWin);
        if(isWin){
            System.out.println("Congratulations!!\n\tYou won");
            print(gameBoard);
        }
        if (isOver){
            System.out.println("BOOOOM !!! You stepped on a mine !\n\tYou lose");
            print(gameBoard);
        }
    }
    public void checkTop(int x,int y){
        if(x!=0){
            if(gameBoard[x-1][y].equals("*")){
                counter++;
            }
        }
    }
    public void checkBottom(int x,int y){
        if(x!=row-1){
            if(gameBoard[x+1][y].equals("*")){
                counter++;
            }
        }
    }
    public void checkRight(int x,int y){
        if(y!=column-1){
            if(gameBoard[x][y+1].equals("*")){
                counter++;
            }
        }
    }
    public void checkLeft(int x,int y){
        if(y!=0){
            if(gameBoard[x][y-1].equals("*")){
                counter++;
            }
        }
    }
    public void checkLeftTop(int x,int y){
        if(y!=0&&x!=0){
            if(gameBoard[x-1][y-1].equals("*")){
                counter++;
            }
        }
    }
    public void checkLeftBottom(int x,int y){
        if(x!=row-1&&y!=0){
            if(gameBoard[x+1][y-1].equals("*")){
                counter++;
            }
        }
    }
    public void checkRightTop(int x,int y){
        if(x!=0&&y!=column-1){
            if(gameBoard[x-1][y+1].equals("*")){
                counter++;
            }
        }

    }
    public void checkRightBottom(int x,int y){
        if(y!=column-1&&x!=row-1){
            if(gameBoard[x+1][y+1].equals("*")){
                counter++;
            }
        }

    }

    public void select(int x,int y){
        int a=x-1;
        int b=y-1;
        if(a>=row||b>=column||a<=-1||b<=-1){   // Check if the player's selection is outside the coordinate system.
            System.out.println("You made a selection outside the coordinate system, try again.");
        }else if(!gameBoard[a][b].equals("-")&&!gameBoard[a][b].equals("*")) { // Check if the player has previously selected this coordinate.
            System.out.println("You have entered this coordinate before. Try again.");
        }else if(gameBoard[a][b].equals("*")){ // Check if the player stepped on a mine.
            isOver=true;
        }else {
            if (winCondition > 0) {
                counter=0;
                winCondition--;
                checkLeft(a,b);
                checkRight(a,b);
                checkTop(a,b);
                checkBottom(a,b);
                checkRightBottom(a,b);
                checkRightTop(a,b);
                checkLeftBottom(a,b);
                checkLeftTop(a,b);
                gameBoard[a][b]=""+counter;
                playerBoard[a][b]=""+counter;
            }
            if(winCondition==0){
                isWin=true;
            }
        }
    }
}