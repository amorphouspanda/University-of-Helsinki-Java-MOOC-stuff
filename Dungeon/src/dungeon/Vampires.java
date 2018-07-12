/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.*;

/**
 *
 * @author Jennifer
 */
public class Vampires {

    private List<Vampire> vamps;
    private Size size;

    public Vampires(int number) {
        size = new Size();
        vamps = new ArrayList<Vampire>();
        createMultipleVamps(number);
    }
    
    public List<Vampire> getVamps() {
        return vamps;
    }
    
    public void moveAllVamps() {
        for (Vampire vamp : vamps) {
            moveVamp(vamp);
        }
    }
    
    public void moveVamp(Vampire vamp) {
        Random rand = new Random();
        
        int move = rand.nextInt(4);
        int testX = 0;
        int testY = 0;
        
        switch (move) {
            case 0:
                testX = vamp.getX() + 1;
                testY = vamp.getY();
                break;
            case 1:
                testX = vamp.getX() - 1;
                testY = vamp.getY();
                break;
            case 2:
                testX = vamp.getX();
                testY = vamp.getY() + 1;
                break;
            case 3:
                testX = vamp.getX();
                testY = vamp.getY() - 1;
                break;
            default:
                break;
        }
        
        if (checkMove(testX, testY)) {
            vamp.move(testX, testY);
        }
        
    }

    public void createMultipleVamps(int number) {
        for (int a = 0; a < number; a++) {
            createVamp();
        }
    }

    public void createVamp() {
        Random rand = new Random();
        
        while (true) {
            int x = rand.nextInt(size.getLength());
            int y = rand.nextInt(size.getHeight());

            if (!checkPlace(x, y)) {
                vamps.add(new Vampire(x, y));
                return;
            }
        }
    }
    
    public boolean checkMove(int x, int y) {
        if (x >= size.getLength() || x < 0 || y >= size.getHeight() || y < 0) {
            return false;
        } 
        
        if (checkPlace(x, y)) {
            return false;
        }
        
        return true;
    }
    
    public boolean checkPlace(int x, int y) {
        for (Vampire vamp : vamps) {
            if (x == vamp.getX() && y == vamp.getY()) {
                return true;
            }
        }
        
        return false;
    }
    
    public void printVamps() {
        for (Vampire vamp : vamps) {
            System.out.println("v " + vamp.getX() + " " + vamp.getY());
        }
    }
}
