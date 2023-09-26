import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //System.out.print("Satır sayısı : ");
        //int satirSayisi=input.nextInt();
        //System.out.print("Sütun sayısı : ");
        //int sutunSayisi=input.nextInt();
        MineSweeper mineSweeper = new MineSweeper(3,3);
        mineSweeper.run();
    }
}