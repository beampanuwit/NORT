package TRON;

import org.newdawn.slick.*;

public class Tron extends BasicGame{
    float x = 400;
    float y = 300;
    char aswd = '\0';
    Image car = null;

    public Tron(String title) {
        super(title);
    }

    public void init(GameContainer contain) throws SlickException {
        car = new Image("picture/carl.png");
    }

    public void update(GameContainer contain, int i) throws SlickException {
        Input input = contain.getInput();
        if (input.isKeyDown(Input.KEY_A)) {
            aswd = 'a';
            car = new Image("picture/carl.png");
        }
        if (input.isKeyDown(Input.KEY_D)) {
            aswd = 'd';
            car = new Image("picture/carr.png");
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
        car.draw(x,y);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer tron = new AppGameContainer(new Tron("TRON"));

        tron.setDisplayMode(800,600,false);

        tron.start();
    }
}