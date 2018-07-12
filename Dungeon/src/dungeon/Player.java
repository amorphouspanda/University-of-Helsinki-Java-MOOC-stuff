/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Jennifer
 */
public class Player {

    private Size size;

    private int x;
    private int y;

    public Player() {
        size = new Size();

        x = 0;
        y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(char move) {
        switch (move) {
            case 'w':
                moveUp();
                break;
            case 's':
                moveDown();
                break;
            case 'a':
                moveLeft();
                break;
            case 'd':
                moveRight();
                break;
            default:
                break;
        }
    }

    public void moveDown() {
        if (y + 1 < size.getHeight()) {
            y++;
        }
    }

    public void moveUp() {
        if (y - 1 >= 0) {
            y--;
        }
    }

    public void moveLeft() {
        if (x - 1 >= 0) {
            x--;
        }
    }

    public void moveRight() {
        if (x + 1 < size.getLength()) {
            x++;
        }
    }

    public boolean checkPlace(int x, int y) {
        return getX() == x && getY() == y;
    }

    public void printPlace() {
        System.out.println("@ " + x + " " + y);
    }
}
