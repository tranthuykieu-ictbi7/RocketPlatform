import java.util.Scanner;

public class Game {

    Scanner keyboardScanner = new Scanner(System.in);
    public char[][] a = new char[4][4];
    public int inputRow;
    public int inputColumn;
    public boolean notHitEnemy = true;
    public boolean hitEnemy1 = false;
    public boolean hitEnemy2 = false;
    public boolean hitEnemy3 = false;
    public boolean hitEnemy4 = false;
    public int countDeadEnemy = 0;
    public int countEnemyAround = 0;
    public int countEnemyLeft = 0;
    public CreateEnemy createEnemy;


    public Game() {

        this.initBattle(a);
        this.showBattle(a);
        this.createEnemy = new CreateEnemy();
        System.out.println(createEnemy.e1x + " " + createEnemy.e1y);
        System.out.println(createEnemy.e2x + " " + createEnemy.e2y);
        System.out.println(createEnemy.e3x + " " + createEnemy.e3y);
        System.out.println(createEnemy.e4x + " " + createEnemy.e4y);

        for (int i = 5; i >= 1; i--){

            getInput();
            hitEnemy(this.inputRow, this.inputColumn);
            getHitEnemy(this.inputRow, this.inputColumn);
            showBattle(a);
            notice();

            aroundEnemy(a, inputRow, inputColumn);

            System.out.println(countEnemyAround + " enemy(s) around");
            System.out.println( i - 1 + " rocket(s) left");


            System.out.println(4 - countDeadEnemy + " enemy(s) left");
            this.countEnemyLeft = 4 - countDeadEnemy;
            if (i == 1) endGame();

            reset();
        }
    }


    public void aroundEnemy(char a[][], int inputRow, int inputColumn){

        for (int x = inputRow - 1; x <= inputRow + 1; x++){
            for (int y = inputColumn - 1; y <= inputColumn + 1; y++){
                if (x == createEnemy.e1x && y == createEnemy.e1y && this.hitEnemy1 == false){
                    this.countEnemyAround += 1;
                }
                if (x == createEnemy.e2x && y == createEnemy.e2y && this.hitEnemy2 == false){
                    this.countEnemyAround += 1;
                }
                if (x == createEnemy.e3x && y == createEnemy.e3y && this.hitEnemy3 == false){
                    this.countEnemyAround += 1;
                }
                if (x == createEnemy.e4x && y == createEnemy.e4y && this.hitEnemy1 == false){
                    this.countEnemyAround += 1;
                }
            }
        }
    }

    public void getInput(){
        System.out.print("Your target? ");
        String inputPlayer = keyboardScanner.nextLine();
        char inputRowChar = inputPlayer.charAt(0);
        char inputColumnChar = inputPlayer.charAt(1);
        this.inputRow = Character.getNumericValue(inputRowChar);
        this.inputColumn = Character.getNumericValue(inputColumnChar);
    }

    public void endGame(){
        System.out.println("\n");
        if (this.countEnemyLeft == 0){
            System.out.println("You won");
        } else {
            System.out.println("You lose");
        }
    }

    public void hitEnemy(int inputRow, int inputColumn){
        if (inputRow == createEnemy.e1x && inputColumn == createEnemy.e1y){
            this.hitEnemy1 = true;
        } else if (inputRow == createEnemy.e2x && inputColumn == createEnemy.e2y){
            this.hitEnemy2 = true;
        } else if (inputRow == createEnemy.e3x && inputColumn == createEnemy.e3y){
            this.hitEnemy3 = true;
        } else if (inputRow == createEnemy.e4x && inputColumn == createEnemy.e4y){
            this.hitEnemy4 = true;
        } else notHitEnemy = false;
    }

    public void getHitEnemy(int inputRow, int inputColumn){

        if (this.notHitEnemy == false){
            a[inputRow][inputColumn] = 'X';
        }
        if (this.hitEnemy1 == true){
            this.countDeadEnemy += 1;
            a[createEnemy.e1x][createEnemy.e1y] = 'O';
        }
        if (this.hitEnemy2 == true){
            this.countDeadEnemy += 1;
            a[createEnemy.e2x][createEnemy.e2y] = 'O';
        }
        if (this.hitEnemy3 == true){
            this.countDeadEnemy += 1;
            a[createEnemy.e3x][createEnemy.e3y] = 'O';
        }
        if (this.hitEnemy4 == true){
            this.countDeadEnemy += 1;
            a[createEnemy.e4x][createEnemy.e4y] = 'O';
        }
    }

    public void notice(){
        if (this.notHitEnemy == false){
            System.out.println("You missed");
        } else System.out.println("You hit");
    }


    public void initBattle(char a[][]){
        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <=3; j++){
                a[i][j] = '-';
            }
        }
    }

    public void showBattle(char a[][]){
        System.out.print("  ");
        for (int k = 0; k <= 3; k++){
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i <= 3; i++){
            System.out.print(i + " ");
            for (int j = 0; j <=3; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void reset(){
        this.notHitEnemy = true;
        this.countEnemyAround = 0;
        this.countDeadEnemy = 0;
    }

}
