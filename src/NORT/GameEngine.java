package NORT;

import org.newdawn.slick.*;

public class GameEngine extends BasicGame{
    float x = 400;
    float y = 300;
    char aswd = '\0';
    Image car = null;

    public GameEngine(String title) {
        super(title);
    }

    public void init(GameContainer contain) throws SlickException {
    }

    public void update(GameContainer contain, int i) throws SlickException {
        Input input = contain.getInput();
        if (input.isKeyDown(Input.KEY_A)) {
            aswd = 'a';
        }
        if (input.isKeyDown(Input.KEY_D)) {
            aswd = 'd';
        }
        if (input.isKeyDown(Input.KEY_W)) {
            aswd = 'w';
        }
        if (input.isKeyDown(Input.KEY_S)) {
            aswd = 's';
        }
        if (x < 0 ) {
            throw new SlickException("555");
        }
        if (x > 800) {
            throw new SlickException("555");
        }
        if (y < 0) {
            throw new SlickException("555");
        }
        if (y > 600) {
            throw new SlickException("555");
        }

        switch (aswd){
            case 'a': x--;break;
            case 'w': y--;break;
            case 's': y++;break;
            case 'd': x++;break;
        }
    }

    public void render(GameContainer contain, Graphics g) throws SlickException {
        g.fillRect(x,y,5,5);
        g.drawRect(x,y,5,5);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer tron = new AppGameContainer(new GameEngine("NORT"));

        tron.setDisplayMode(800,600,false);

        tron.start();
    }
}