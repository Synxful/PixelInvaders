import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {

        scoreKeep++;

        if(scoreKeep >= 100){
            scoreKeep = 0;
            hud.setLevel((int)hud.getLevel()+1);


            /*if(hud.getLevel() == 2) {
                handler.addObject(new BossEnemy((Game.WIDTH / 2 ),100, ID.BossEnemy, handler));
            }*/

            /*if(hud.getLevel() == 4) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
            }

            if(hud.getLevel() == 2) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
            }*/

        }

    }
}
