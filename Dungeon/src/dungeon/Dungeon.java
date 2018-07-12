/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Jennifer
 */
public class Dungeon {

    private Size size;

    private int moves;

    private Player player;
    private Vampires vamps;

    private boolean vampiresMove;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        size = new Size();
        size.setSize(length, height);

        this.moves = moves;

        player = new Player();
        vamps = new Vampires(vampires);

        this.vampiresMove = vampiresMove;
    }

    public void run() {
        Scanner reader = new Scanner(System.in);

        while (true) {
            printGameState();

            makeMove(reader.nextLine());

            if (checkWin()) {
                System.out.println("YOU WIN");
                break;
            }

            if (checkLoss()) {
                System.out.println("YOU LOSE");
                break;
            }
        }
    }

    public void makeMove(String input) {
        for (int a = 0; a < input.length(); a++) {
            player.move(input.charAt(a));
            killVamps();

            if (vampiresMove == true) {
                vamps.moveAllVamps();
                killVamps();
            }
        }
        
        moves--;
    }

    public void killVamps() {
        int toKill = -1;
        for (int a = 0; a < vamps.getVamps().size(); a++) {
            int x = vamps.getVamps().get(a).getX();
            int y = vamps.getVamps().get(a).getY();

            if (x == player.getX() && y == player.getY()) {
                toKill = a;
            }
        }

        if (toKill != -1) {
            vamps.getVamps().remove(toKill);
        }
    }

    public boolean checkLoss() {
        return moves == 0;
    }

    public boolean checkWin() {
        return vamps.getVamps().isEmpty();
    }

    public void printGameState() {
        System.out.println(moves);
        System.out.println("");

        Grid grid = new Grid(player, vamps, true);
        grid.printTable();
        System.out.println("");

        grid.printGrid();
        System.out.println("");
    }

}
