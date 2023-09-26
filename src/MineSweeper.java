import java.util.Scanner;
public class MineSweeper {
    int row;
    int column;
    int mines;
    String[][] gameBoard;
    String[][] playerBoard;
    int winCond;
    boolean isOver ;
    boolean isWin;

    MineSweeper(int row, int column){
        this.row=row;
        this.column=column;
        this.mines=(row*column)/4;
        this.winCond=(row*column)-(((row*column))/4);
        isOver = false;
        isWin=false;
        setGameBoard();
        playerBoard(gameBoard);
        print(playerBoard);
        System.out.println("000000000000000000000000");
        placeMines();
        print(gameBoard);
        System.out.println("000000000000000000000000");
        print(playerBoard);

    }
    public void setGameBoard(){
        this.gameBoard = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                gameBoard[i][j] = "-";
            }
        }
    }
    public void placeMines(){
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

    public void print(String[][] arr){
        for (int i = 0; i <row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public String[][] playerBoard(String[][] arr){
        this.playerBoard = new String[row][column];
        for (int i = 0; i < gameBoard.length; i++) {
            for(int j=0;j< gameBoard[i].length;j++){
                playerBoard[i][j]=(gameBoard[i][j]);
            }
        }
        return playerBoard;
    }
    public void run(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("=========================");
            System.out.print("satır gir: ");
            int row=input.nextInt();
            System.out.print("sütun gir: ");
            int column=input.nextInt();
            select(row,column);
            print(playerBoard);
        }while(!isOver&&!isWin);
        if(isWin){
            System.out.println("Tebrikler!! Kazandınız!");
        }
        if (isOver){
            System.out.println("BOOOOM !!! Mayına bastınız !");
        }
    }
    public void select(int a,int b){
        int count=0;
        if(a>=row||b>=column){
            System.out.println("Koordinat sisteminin dışında seçim yaptınız tekrar deneyiniz.");
        }else if(!gameBoard[a][b].equals("-")&&!gameBoard[a][b].equals("*")) {
            System.out.println("Daha önce bu koordinatı girdiniz. Tekrar deneyiniz.");
        }else if(gameBoard[a][b].equals("*")){
            isOver=true;
        }else{
            if(winCond>0) {
                winCond--;
                System.out.println(winCond);

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
                    }else if (a==row-1&&b!=row-1) {
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
                    if(b==row-1){
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
                }else if(a>0){
                    if(a==column-1){
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
                playerBoard[a][b]=""+count;
            }
            if(winCond==0){
                isWin=true;
            }
        }
    }
}