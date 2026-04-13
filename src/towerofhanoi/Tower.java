package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those
//who do.
//
//-- James Parker (jamesp28)

// -------------------------------------------------------------------------
/**
 *  A tower with which disks will sit.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
public class Tower extends LinkedStack<Disk> {
    //~ Fields ................................................................
    /**
     * The position of the Tower.
     */
    private Position position;
    //~ Constructors ..........................................................
    /**
     * Creates a new Tower object.
     * 
     * @param position - The position of the Tower.
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
    
    //~Public  Methods ........................................................
    /**
     * Gets the position of the Tower.
     * 
     * @return The position of the Tower.
     */
    public Position position() {
        return position;
    }
    
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            super.push(disk);
        }
        else if (disk.compareTo(peek()) < 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
