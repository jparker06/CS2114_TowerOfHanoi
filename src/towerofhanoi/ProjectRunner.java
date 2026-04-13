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
 *  Runs the Hanoi Problem solver.
 * 
 *  @author James Parker
 *  @version March 25, 2025
 */
public class ProjectRunner {
    //~ Fields ................................................................
    private static int disks = 5;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Runs the HanoiSolver project.
     * @param args - Arguments passed
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        PuzzleWindow puzzleWindow = new PuzzleWindow(new HanoiSolver(disks));
    }
}
