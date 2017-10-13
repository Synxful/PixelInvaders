import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32 ,32);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        collision();

    }

    public void collision() {
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.BossEnemy) {
                if(getBounds().intersects(tempObject.getBounds())){
                    // collision code
                    HUD.HEALTH -= 0.5;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.green);
        g2d.draw(getBounds());


/*        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32 ,32);*/
//        if(id == ID.Player) g.setColor(Color.WHITE);
//        else if(id == ID.Player2) g.setColor(Color.BLUE);

    }
}
