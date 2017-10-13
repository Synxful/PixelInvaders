import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class BossEnemy extends GameObject {

    private Handler handler;
    Random r = new Random();

    private int timer = 20;
    private int timer2 = 10;

    public BossEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 10;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 98 ,98);
    }


    @Override
    public void tick() {

        x += velX;
        y += velY;

        if(timer <= 0) {
            velY = 0;
        } else {
            timer--;
        }

        if(timer <= 0) {
            timer2--;
        }

        if(timer2 <= 0) {
            if(velX == 0) {
                velX = 5;

            }

        }


        /*if(y <= 0 || y >= Game.HEIGHT - 122) velY *= -1;*/
        if(x <= 0 || x >= Game.WIDTH - 98) velX *= -1;

        // trail
        /*handler.addObject(new Trail(x,y,ID.Trail, Color.red, 99, 99, 0.02f, handler));*/

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int)x, (int)y , 98, 98);

    }
}
