import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 22;
        velY = 19;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 9 ,9);
    }


    @Override
    public void tick() {

        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

        handler.addObject(new Trail(x,y,ID.Trail, Color.CYAN, 50, 50, 0.09f, handler));

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.CYAN);
        g.fillRect((int)x, (int)y , 9, 9);

    }
}
