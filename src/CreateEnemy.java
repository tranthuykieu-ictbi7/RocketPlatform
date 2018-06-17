import java.util.Random;

public class CreateEnemy {

    public Random random = new Random();
    public int e1x;
    public int e1y;
    public int e2x;
    public int e2y;

    public int e3x;
    public int e3y;
    public int e4x;
    public int e4y;

    public CreateEnemy() {

        this.e1x = random.nextInt(4);
        this.e1y = random.nextInt(4);

        this.e2x = random.nextInt(4);
        this.e2y = random.nextInt(4);

        this.e3x = random.nextInt(4);
        this.e3y = random.nextInt(4);

        this.e4x = random.nextInt(4);
        this.e4y = random.nextInt(4);

    }
}
