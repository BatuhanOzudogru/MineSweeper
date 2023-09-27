import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to MineSweeper game");
        System.out.println("Please enter the size you want to play");
        System.out.print("Row Number : ");
        int rowNumber=input.nextInt(); // Request the number of rows from the user.
        System.out.print("Column Number : ");
        int columnNumber=input.nextInt();  // Request the number of columns from the user.
        MineSweeper mineSweeper = new MineSweeper(rowNumber,columnNumber); // Create a MineSweeper game instance with the user-defined grid size.
        mineSweeper.run();
    }
}