package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those
//who do.
//
//-- James Parker (jamesp28)

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 *  Solver of the Hanoi problem.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    //~ Fields ................................................................
    private Tower left;
    private Tower center;
    private Tower right;
    private int numDisks;
    
    //~ Constructors ..........................................................
    /**
     * Creates a new HanoiSolver object.
     * 
     * @param numDisks - The number of disks in the problem
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        center = new Tower(Position.CENTER);
        right = new Tower(Position.RIGHT);
    }
    //~Public  Methods ........................................................
    /**
     * Gets the number of disks in the problem.
     * 
     * @return The number of disks
     */
    public int disks() {
        return numDisks;
    }
    
    /**
     * Gets the tower on the side specified by the user.
     * 
     * @param position - The position of the desired Tower
     * @return The specified Tower
     */
    public Tower getTower(Position position) {
        switch (position) {
            case LEFT:
                return left;
            
            case CENTER:
                return center;
            
            case RIGHT:
                return right;
            
            default:
                return center;
        }
    }
    
    /**
     * Solves the Hanoi problem.
     */
    public void solve() {
        solveTowers(numDisks, left, center, right);
    }
    
    /**
     * Prints the towers together as a String
     * 
     * @return The new String
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(left.toString());
        str.append(center.toString());
        str.append(right.toString());
        return str.toString();
    }
    
    /**
     * Moves a disk from one Tower to another.
     * 
     * @param source - The Tower the Disk is currently on
     * @param destination - The Tower where the Disk is going to go
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }
    
    /**
     * Solves the Hanoi problem through recursive movements of Disks.
     * 
     * @param currentDisks - The number of Disks in the problem
     * @param startPole - The Tower the Disk is currently on
     * @param tempPole - The helper or temporary Tower
     * @param endPole - The Tower where the Disk is going to go
     */
    private void solveTowers(int currentDisks, Tower startPole,
                             Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }
}
