package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void turnToLiving(int x, int y) {
        try {
            getBoard()[x][y] = true;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        try {
            getBoard()[x][y] = false;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        try {
            return getBoard()[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public void initiateRandomCells(double d) {
        Random rand = new Random();

        for (int a = 0; a < getBoard().length; a++) {
            for (int b = 0; b < getBoard()[a].length; b++) {
                double num = rand.nextDouble();

                if (num < d) {
                    turnToLiving(a, b);
                } else {
                    turnToDead(a, b);
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int alive = 0;

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (isAlive(x + b - 1, y + a - 1) && !(a == 1 && b == 1)) {
                    alive++;
                }
            }
        }

        return alive;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        }

        if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }
}
