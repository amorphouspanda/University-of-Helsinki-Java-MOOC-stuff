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
public class Grid {
    
    private Size size;
    private Player player;
    private Vampires vamps;
    private boolean vampiresMove;
    
    public Grid(Player player, Vampires vamps, boolean vampiresMove) {
        size = new Size();
        
        this.player = player;
        this.vamps = vamps;
        
        this.vampiresMove = vampiresMove;
    }
    
    public void printTable() {
        player.printPlace();
        vamps.printVamps();
    }
    
    public void printGrid() {
        for (int a = 0; a < size.getHeight(); a++) {
            for (int b = 0; b <size.getLength(); b++) {
                if (player.checkPlace(b, a)) {
                    System.out.print("@");
                } else if (vamps.checkPlace(b, a)) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            
            System.out.println("");
        }
    }
}
