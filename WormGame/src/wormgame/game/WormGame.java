package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private Worm worm;
    private Apple apple;

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);

        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        
        apple = newApple();
    }
    
    public Apple newApple() {
        Random rand = new Random();
        Apple buffer = null;
        
        while (true) {
            buffer = new Apple(rand.nextInt(width), rand.nextInt(height));
            if (!worm.runsInto(buffer)) {
                break;
            }
        }
        
        return buffer;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Random rand = new Random();

        if (!continues) {
            return;
        }

        worm.move();

        if (worm.runsInto(apple)) {
            worm.grow();
            setApple(newApple());
        }

        if (worm.runsIntoItself()) {
            continues = false;
        }

        for (Piece piece : worm.getPieces()) {
            if (piece.getX() >= width || piece.getX() <= 0 || piece.getY() >= height || piece.getY() <= 0) {
                this.continues = false;
            }
        }

        updatable.update();
        super.setDelay(1000 / worm.getLength());
    }

}
