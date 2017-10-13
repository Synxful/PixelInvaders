import java.awt.*;

public class HUD  {


    public static float HEALTH = 100;
    private float greenValue = 255f;

    private int score = 0 ;
    private int level = 1;

    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0 ,100);
        greenValue = Game.clamp(greenValue, 0 , 255);

        greenValue = HEALTH*2;

        score++;

    }


    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(150, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);

        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);


        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);

    }

    public void score(int score) {
        this.score = score;
    }

    public float getScore() {
        return score;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
