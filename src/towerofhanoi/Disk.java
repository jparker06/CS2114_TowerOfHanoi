package towerofhanoi;

// Virginia Tech Honor Code Pledge:
// Project 3 Spring 2025
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
//
// -- James Parker (jamesp28)

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 *  A disk on one of the towers.
 * 
 *  @author James Parker
 *  @version Mar 25, 2025
 */
public class Disk extends Shape implements Comparable<Disk> {
    //~ Fields ................................................................
    private static final int HEIGHT = PuzzleWindow.DISK_HEIGHT;
    private TestableRandom generator = new TestableRandom();
    //~ Constructors ..........................................................
    /**
     * Create a new Disk object.
     * @param width - width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, HEIGHT);
        setBackgroundColor(new Color(generator.nextInt(255),
            generator.nextInt(255), generator.nextInt(255)));
    }
    //~Public  Methods ........................................................
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        else if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Returns the width of the disk as a String
     * 
     * @return The width of the disk
     */
    public String toString() {
        String str = "";
        return str + getWidth();
    }
    
    /**
     * Finds if the two disks are equal in width.
     * 
     * @param obj - the disk being compared
     * @return true if the disks have equal width; otherwise false
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Disk other = (Disk) obj;
            return (this.getWidth() == other.getWidth());
        }
        return false;
    }
}
