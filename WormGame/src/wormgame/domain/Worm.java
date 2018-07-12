/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author Jennifer
 */
public class Worm {

    private List<Piece> pieces;
    private Direction direction;

    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        direction = originalDirection;

        grow = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        direction = dir;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        Piece head = pieces.get(getLength() - 1);

        if (direction == Direction.RIGHT) {
            pieces.add(new Piece(head.getX() + 1, head.getY()));
        } else if (direction == Direction.LEFT) {
            pieces.add(new Piece(head.getX() - 1, head.getY()));
        } else if (direction == Direction.DOWN) {
            pieces.add(new Piece(head.getX(), head.getY() + 1));
        } else {
            pieces.add(new Piece(head.getX(), head.getY() - 1));
        }

        if (getLength() <= 3) {
            grow();
        }
        
        if (!grow) {
            pieces.remove(0);
        } else {
            grow = false;
        }
    }

    public void grow() {
        grow = true;
    }

    public boolean runsInto(Piece piece) {
        boolean crash = false;

        for (Piece part : pieces) {
            if (part.getX() == piece.getX() && part.getY() == piece.getY()) {
                crash = true;
                break;
            }
        }

        return crash;
    }

    public boolean runsIntoItself() {

        for (Piece piece1 : pieces) {
            int crashes = 0;

            for (Piece piece2 : pieces) {
                if (piece1.getX() == piece2.getX() && piece1.getY() == piece2.getY()) {
                    crashes++;
                    if (crashes > 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
