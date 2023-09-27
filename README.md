# MineSweeper

This project contains a simple Minesweeper game developed using the Java programming language. The game can be played in the terminal and challenges the user to open all fields on the Minesweeper, excluding mines. 

**Installation**
- bash
   git clone https://github.com/BatuhanOzudogru/MineSweeper.git 
 
- Open a Java IDE (Integrated Development Environment) of your choice.
- In your IDE, open the project by selecting an option like "Open Project" or "Open Folder." Navigate to the directory where you cloned the project and select it.
- Once the project is open, find the "Main.java" file and run it. You can typically do this by using the "Run" or "Execute" button in your IDE.

**How to Play**

The objective of the game is to open all the squares on the Minesweeper field without stepping on the mines.


First specify the number of rows and columns you want to play
*For example, you created a 4 by 4 area*
**Row No**/`Column No` | `1` | `2` | `3` | `4`
--- | --- | ---| --- | --- 
**1** | - | * | - | - 
**2** | - | - | - | - 
**3** | - | - | * | * 
**4** | * | - | - | - 

Select a cell by entering the "Row no" and "Column no."

*Let's say you select row 2 and column 2*

If the selected cell does not contain a mine, you will see the number of mines adjacent to that cell.

**Row No**/`Column No` | `1` | `2` | `3` | `4`
--- | --- | ---| --- | --- 
**1** | - | * | - | - 
**2** | - | 2 | - | - 
**3** | - | - | * | * 
**4** | * | - | - | - 

If you step on a mine, you lose the game.
If you successfully open all the squares without mines, you win the game.

**Row No**/`Column No` | `1` | `2` | `3` | `4`
--- | --- | ---| --- | --- 
**1** | 1 | * | 1 | 0 
**2** | 1 | 2 | 3 | 2 
**3** | 1 | 2 | * | * 
**4** | * | 2 | 2 | 2 

Enjoy the game!


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Mayın Tarlası

Bu proje, Java programlama dili kullanılarak geliştirilmiş basit bir Mayın Tarlası oyununu içerir. Oyun, terminal üzerinden oynanabilir ve kullanıcıya bir Mayın Tarlası sahası üzerindeki mayınlar hariç bütün alanları açmayı hedefler.

**Kurulum**

- bash
   git clone https://github.com/BatuhanOzudogru/MineSweeper.git 
 
- Bir Java IDE'si açın. 
- IDE'nizde "Open Project" veya "Projeyi Aç" gibi bir seçenekle projenizin klonladığı dizini açın.
- Proje açıldığında, "Main.java" adlı dosyayı bulun ve bu dosyayı çalıştırın. Genellikle IDE'nizde "Run" veya "Çalıştır" düğmesini kullanarak bu işlemi gerçekleştirebilirsiniz.

**Nasıl Oynanır**

Oyunun amacı Mayın Tarlası sahasındaki tüm kareleri mayınlara basmadan açmaktır.

Öncelikle oynatmak istediğiniz satır ve sütun sayısını belirtin.
*Örneğin, 4x4 bir alan oluşturdunuz.*
**Satır No**/`Sütun No` | `1` | `2` | `3` | `4`
--- | --- | ---| --- | --- 
**1** | - | * | - | - 
**2** | - | - | - | - 
**3** | - | - | * | * 
**4** | * | - | - | - 

Row no ve Column no girerek bir hücre seçin.

*Diyelim ki 2. satırı ve 2. sütunu seçtiniz*

Seçtiğiniz hücrede mayın yoksa, hücrede kaç tane mayın bulunduğunu göreceksiniz.

**Satır No**/`Sütun No` | `1` | `2` | `3` | `4`
--- | --- | ---| --- | --- 
**1** | - | * | - | - 
**2** | - | 2 | - | - 
**3** | - | - | * | * 
**4** | * | - | - | - 

Mayına basarsanız, oyunu kaybedersiniz.
Eğer mayınsız tüm kareleri başarıyla açarsanız oyunu kazanırsınız.

**Satır No**/`Sütun No` | `1` | `2` | `3` | `4`
--- | --- | ---| --- | --- 
**1** | 1 | * | 1 | 0 
**2** | 1 | 2 | 3 | 2 
**3** | 1 | 2 | * | * 
**4** | * | 2 | 2 | 2 

İyi Oyunlar !
