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
public class Size {
    
    private static int length;
    private static int height;
    
    public Size() {
        
    }
    
    public void setSize(int length, int height) {
        this.length = length;
        this.height = height;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getHeight() {
        return height;
    }
}
