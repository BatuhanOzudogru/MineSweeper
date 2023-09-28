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

    public void select(int x,int y){   // Handles the player's selection and updates the game board.
        int a=x-1;
        int b=y-1;
        int count=0;
        if(a>=row||b>=column||a<=-1||b<=-1){   // Check if the player's selection is outside the coordinate system.
            System.out.println("You made a selection outside the coordinate system, try again.");
        }else if(!gameBoard[a][b].equals("-")&&!gameBoard[a][b].equals("*")) { // Check if the player has previously selected this coordinate.
            System.out.println("You have entered this coordinate before. Try again.");
        }else if(gameBoard[a][b].equals("*")){ // Check if the player stepped on a mine.
            isOver=true;
        }else{
            if(winCondition>0) {
                winCondition--;

                    if(a>0&&b>0){
                        if(a==row-1&&b==column-1){
                            for(int i=a-1; i<a+1;i++){
                                for(int j=b-1;j<b+1;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        } else if(b==column-1&&a!=row-1){
                            for(int i=a-1; i<a+2;i++){
                                for(int j=b-1;j<=b;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }else if (a==row-1&&b!=column-1) {
                            for(int i=a-1; i<=a;i++){
                                for(int j=b-1;j<b+2;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }else{
                            for(int i=a-1; i<a+2;i++){
                                for(int j=b-1;j<b+2;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }
                    }else if(a==0&&b>0){
                        if(b==column-1){
                            for(int i=a; i<a+2;i++){
                                for(int j=b-1;j<=b;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }else{
                            for(int i=a; i<a+2;i++){
                                for(int j=b-1;j<b+2;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }
                    }else if(a>0&&b==0){
                        if(a==row-1){
                            for(int i=a-1; i<=a;i++){
                                for(int j=b;j<b+2;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }else{
                            for(int i=a-1; i<a+2;i++){
                                for(int j=b;j<b+2;j++){
                                    if(gameBoard[i][j].equals("*")){
                                        count++;
                                    }
                                }
                            }
                        }

                    }else{  //b==0&&a==0
                        for(int i=a; i<a+2;i++){
                            for(int j=b;j<b+2;j++){
                                if(gameBoard[i][j].equals("*")){
                                    count++;
                                }
                            }
                        }
                    }

                gameBoard[a][b]=""+count;
                playerBoard[a][b]=""+count;
            }
            if(winCondition==0){
                isWin=true;
            }
        }
    }
}