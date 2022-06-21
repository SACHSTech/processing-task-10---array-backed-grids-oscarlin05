import processing.core.PApplet;
/**
 * title: processing-task-10---array-backed-grids
 * author: Oscar. L
 */

public class Sketch extends PApplet {
	
  // declare variables
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (ROW_COUNT * 20) + (11 * MARGIN);
  int SCREEN_HEIGHT = (ROW_COUNT * 20) + (11 * MARGIN);
  int[][] intGrid = new int[ROW_COUNT][COLUMN_COUNT];
  int intChosenCell;
  int intRowCounter = 0;
  int intCounter = 0;
  int intMaxCounter = 0;

  // set screen size
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

  // create the rows and columns with margin spacing in it
  public void draw() {
    for (int column = 0; column < COLUMN_COUNT; column++) {
      for (int row = 0; row < ROW_COUNT; row++) {

        // change colors when selected
        if (intGrid[row][column] == 1) {
          fill(0, 255, 0);
          rect(MARGIN + (column * (CELL_WIDTH + MARGIN)), MARGIN + (row * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
        }
        
        else {
          fill(255, 255, 255);
          rect(MARGIN + (column * (CELL_WIDTH + MARGIN)), MARGIN + (row * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
        }
      }
    }
  }

  // create mouse input for when user click on the cells 
  // create conditions to fulfill when the cells are selected 
  public void mousePressed() {
    for (int column = 0; column < COLUMN_COUNT; column++) {
      for (int row = 0; row< ROW_COUNT; row++){
        if (mouseX / (CELL_WIDTH + MARGIN) == column && mouseY / (CELL_HEIGHT + MARGIN) == row) {

          if (row > 0 && intGrid[row - 1][column] == 0){
            intGrid[row-1][column] = 1;
            intChosenCell++;
          }

          else if (row > 0 && intGrid[row - 1][column] == 1) {
            intGrid[row - 1][column] = 0;
            intChosenCell--;
          }

          if (row < ROW_COUNT - 1 && intGrid[row + 1][column] == 0) {
            intGrid[row + 1][column] = 1;
            intChosenCell++;
          }

          else if (row < ROW_COUNT - 1 && intGrid[row + 1][column] == 1) {
            intGrid[row + 1][column] = 0;
            intChosenCell--;
          }

          if (column > 0 && intGrid[row][column - 1] == 0) {
            intGrid[row][column - 1] = 1;
            intChosenCell++;
          }

          else if (column > 0 && intGrid[row][column - 1] == 1) {
            intGrid[row][column-1] = 0;
            intChosenCell--;
          }

          if (column < COLUMN_COUNT - 1 && intGrid[row][column+1] == 0) {
            intGrid[row][column+1] = 1;
            intChosenCell++;
          }

          else if (column < COLUMN_COUNT - 1 && intGrid[row][column+1] == 1) {
            intGrid[row][column+1] = 0;
            intChosenCell--;
          }

          if (intGrid[row][column] == 0) {
            intGrid[row][column] = 1;
            intChosenCell++;
          }

          else if (intGrid[row][column] == 1) {
            intGrid[row][column] = 0;
            intChosenCell--;
          }

          // print out the chosen cells 
          System.out.println("Total of " + intChosenCell + " cells are selected. ");            
          }
        }
      }
    
    for (int row = 0; row < ROW_COUNT; row++) {

      for (int column = 0; column < COLUMN_COUNT; column++) {
        if (intGrid[row][column] == 1) {
          intRowCounter++;
          intCounter++;
          
          if (intCounter > intMaxCounter) {
            intMaxCounter = intCounter;
          }
        }
        else {
          intCounter = 0;
        }
      }

      // create condition to check the amount of selected cells
      // print out the selected cells again (rows and columns)
      if (intMaxCounter > 2) {
        System.out.println("There are " + intMaxCounter + " continuous blocks selected on row " + row + ". ");
      }

      System.out.println("Row " + row + " has" + intCounter + " cells selected. ");
    }

    for (int column = 0; column < ROW_COUNT; column++) {
      
      int intColumnCounter = 0;
      for (int row = 0; row < COLUMN_COUNT; row++) {
        if (intGrid[row][column] == 1) {
          intColumnCounter++;
        }
      }
      System.out.println("Column " + column + " has " + intColumnCounter + " cells selected.");
    }
  }
}