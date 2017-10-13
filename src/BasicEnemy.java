import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y, 9 ,9);
    }


    @Override
    public void tick() {

        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail(x,y,ID.Trail, Color.red, 9, 9, 0.04f, handler));


    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int)x, (int)y , 9, 9);

    }
}
