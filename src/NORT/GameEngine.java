package NORT;

import org.newdawn.slick.*;

import java.util.ArrayList;

public class GameEngine extends BasicGame{
    ArrayList arrx1 = new ArrayList();
    ArrayList arry1 = new ArrayList();
    ArrayList arrx2 = new ArrayList();
    ArrayList arry2 = new ArrayList();

    float[][] arr = new float[800][600];

    float x1 = 400;
    float y1 = 300;
    float x2 = 300;
    float y2 = 400;

    float x1old = x1;
    float y1old = y1;
    float x2old = x2;
    float y2old = y2;

    char aswd1 = 'w';
    char aswd2 = 'w';
    Image car = null;

    public GameEngine(String title) {
        super(title);
    }

    public void init(GameContainer contain) throws SlickException {
    }

    public void update(GameContainer contain, int i) throws SlickException {
        Input input = contain.getInput();

        if (aswd1 != 'd' && input.isKeyDown(Input.KEY_A)) {
            aswd1 = 'a';
        }
        if (aswd1 != 'a' && input.isKeyDown(Input.KEY_D)) {
            aswd1 = 'd';
        }
        if (aswd1 != 's' && input.isKeyDown(Input.KEY_W)) {
            aswd1 = 'w';
        }
        if (aswd1 != 'w' && input.isKeyDown(Input.KEY_S)) {
            aswd1 = 's';
        }
        if (aswd1 != 'd' && input.isKeyDown(Input.KEY_LEFT)) {
            aswd2 = 'a';
        }
        if (aswd1 != 'a' && input.isKeyDown(Input.KEY_RIGHT)) {
            aswd2 = 'd';
        }
        if (aswd1 != 's' && input.isKeyDown(Input.KEY_UP)) {
            aswd2 = 'w';
        }
        if (aswd1 != 'w' && input.isKeyDown(Input.KEY_DOWN)) {
            aswd2 = 's';
        }

        switch (aswd1){
            case 'a': x1--;break;
            case 'w': y1--;break;
            case 's': y1++;break;
            case 'd': x1++;break;
        }
        switch (aswd2){
            case 'a': x2--;break;
            case 'w': y2--;break;
            case 's': y2++;break;
            case 'd': x2++;break;
        }

        for(int j = 1; j < arrx1.size(); j++) {
            if (arrx1.size() >= 1) {
                if (x1 == (float) arrx1.get(j) && y1 == (float) arry1.get(j)){
                    throw new SlickException("555");
                }
                if (x1 == (float) arrx2.get(j) && y1 == (float) arry2.get(j)){
                    throw new SlickException("555");
                }
            }

            if(arrx2.size() >= 1) {
                if (x2 == (float) arrx1.get(j) && y2 == (float) arry1.get(j)){
                    throw new SlickException("555");
                }
                if (x2 == (float) arrx2.get(j) && y2 == (float) arry2.get(j)){
                    throw new SlickException("555");
                }
            }
        }

        if(arrx1.size() == 0 ){
            arrx1.add(x1);
            arry1.add(y1);
            arrx2.add(x2);
            arry2.add(y2);
        }

        if (!(x1 == x1old && y1 == y1old )){
            arrx1.add(x1);
            arry1.add(y1);
        }
        if (!(x2 == x2old && y2 == y2old )) {
            arrx2.add(x2);
            arry2.add(y2);
        }
    }

    public void render(GameContainer contain, Graphics g) throws SlickException {
        User player1 = new User();

        g.setColor(new Color(255,255,255));
        for(int i = 0; i < arrx1.size(); i++){
            g.fillRect((float) arrx1.get(i),(float) arry1.get(i),5,5);
            g.drawRect((float) arrx1.get(i),(float) arry1.get(i),5,5);
        }

        g.setColor(new Color(255,0,0));
        for(int i = 0; i < arrx2.size(); i++){
            g.fillRect((float) arrx2.get(i),(float) arry2.get(i),5,5);
            g.drawRect((float) arrx2.get(i),(float) arry2.get(i),5,5);
        }
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer tron = new AppGameContainer(new GameEngine("NORT"));

        tron.setTargetFrameRate(60);
        tron.setDisplayMode(800,600,false);

        tron.start();
    }
}