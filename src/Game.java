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
    public int countEnemyLeft = 0;
    public int countEnemyAround = 0;


    public Game() {

        this.initBattle(a);
        this.showBattle(a);

        for (int i = 5; i >= 1; i--){
            getInput();
            hitEnemy(this.inputRow, this.inputColumn);
            getHitEnemy(this.inputRow, this.inputColumn);
            showBattle(a);
            notice();
            reset();
//            aroundEnemy(a, inputRow, inputColumn);
//            System.out.println(countEnemyAround + " enemy(s) around");
            System.out.println( i - 1 + " rocket(s) left");
            System.out.println(4 - countEnemyLeft + " enemy(s) left");
        }
        endGame();
    }


    public void aroundEnemy(char a[][], int inputRow, int inputColumn){

        // need to be fixed

        for (int x = inputRow - 1; x <= inputRow + 1; x++){
            for (int y = inputColumn - 1; y <= inputColumn + 1; y++){
                if (a[x][y] == a[0][3] || a[x][y] == a[1][1]
                        || a[x][y] == a[1][2] || a[x][y] == a[3][0]){
                    this.countEnemyAround += 1;
                }
            }
        }

    }

    public void endGame(){
        if (this.countEnemyLeft == 0){
            System.out.println("You won");
        } else {
            System.out.println("You lose");
        }
    }

    public void getHitEnemy(int inputRow, int inputColumn){

        if (this.notHitEnemy == false){
            a[inputRow][inputColumn] = 'X';
        }
        if (this.hitEnemy1 == true){
            this.countEnemyLeft += 1;
            a[0][3] = 'O';
        }
        if (this.hitEnemy2 == true){
            this.countEnemyLeft += 1;
            a[1][1] = 'O';
        }
        if (this.hitEnemy3 == true){
            this.countEnemyLeft += 1;
            a[1][2] = 'O';
        }
        if (this.hitEnemy4 == true){
            this.countEnemyLeft += 1;
            a[3][0] = 'O';
        }
    }

    public void notice(){
        if (this.notHitEnemy == false){
            System.out.println("You missed");
        }
        if (this.hitEnemy1 == true || this.hitEnemy2 == true
                || this.hitEnemy3 == true || this.hitEnemy4 == true)
        {
            System.out.println("You hit");
        }
    }

    public void hitEnemy(int inputRow, int inputColumn){
        if (inputRow == 0 && inputColumn == 3){
            this.hitEnemy1 = true;
        } else if (inputRow == 1 && inputColumn == 1){
            this.hitEnemy2 = true;
        } else if (inputRow == 1 && inputColumn == 2){
            this.hitEnemy3 = true;
        }else if (inputRow == 3 && inputColumn == 0){
            this.hitEnemy4 = true;
        } else notHitEnemy = false;

    }

    public void getInput(){
        System.out.print("Your target? ");
        String inputPlayer = keyboardScanner.nextLine();
        char inputRowChar = inputPlayer.charAt(0);
        char inputColumnChar = inputPlayer.charAt(1);
        this.inputRow = Character.getNumericValue(inputRowChar);
        this.inputColumn = Character.getNumericValue(inputColumnChar);
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
        this.hitEnemy1 = false;
        this.hitEnemy2 = false;
        this.hitEnemy3 = false;
        this.hitEnemy4 = false;
        this.notHitEnemy = true;
    }


}
