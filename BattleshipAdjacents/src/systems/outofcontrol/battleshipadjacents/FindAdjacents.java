/*
 * Terry Speicher, CS 3331, HW1
 */
package systems.outofcontrol.battleshipadjacents;


/*
 
 Terry Speicher, CS 3331
 
 Model explanation:
 
Homework assignment #1 was to list edge adjacent cells to a given cell.  Also, list the diagonally adjacent 
cells.  And finally, list the cells that are not adjacent to the chosen cell.

Given that the battleship board is square, the width is important.  It determines how many cells are in each 
row.

Therefore, we can determine adjacents and nonadjacents with just 2 pieces of information:

	1.  The width of the board
	2.  The x and y coordinates of the selected (chosen) cell.  
	
In this class, we refer to the cell that the user chose as the "chosen one".  

Because the application specs dictated a board of 9 x 9 (width of 9), the main class uses 9 as a constant. 
The implementation of the solution allows the width to be changed and could be easily modified to allow 
the size of the board to be specified at runtime.  This solution works for board widths from 0 to INTEGER MAX.

The solution for cells that are adjacent to the chosen one can be determined mathematically.

Given this representation of the battleship board, we can find some simple basic equations for the adjacent
cells:


  8 | 72  73  74  75  76  77  78  79  80
  7 | 63  64  65  66  67  68  69  70  71
  6 | 54  55  56  57  58  59  60  61  62
  5 | 45  46  47  48  49  50  51  52  53
  4 | 36  37  38  39  40  41  42  43  44
  3 | 27  28  29  30  31  32  33  34  35
  2 | 18  19  20  21  22  23  24  25  26
  1 | 09  10  11  12  13  14  15  16  17
  0 | 00  01  02  03  04  05  06  07  08 
     -----------------------------------
       0   1   2   3   4   5   6   7   8  


The input and output of this solution is, as is the real battleship game, based on some representation of 
Cartesian coordinates (i.e. (3,3), A5...).

Starting at (0,0), we number the cells sequentially, starting at 0. (refer to chart above)

So, as an example, if the chosen cell is (2,3), then we can get the sequential number of that cell on the board by using the following
formula:

sequencialNumberOfCell = (y * width) + x

or, with a board width of 9:

( 3 * 9 ) + 2 = 29

Remember that we start our counting at zero.

Given a chosen cell, then we label the adjacent cells as:


TL    TM     TR           TL = Top Left, TM = Top Middle, TR = Top Right
LM   chosen  RM           LM = Left Middle,               RM = Right Middle
BL    BM     BR           BL = Bottom Left, BM = Bottom Middle, BR = Bottom Right

The adjacent cells can be calculated based on the following formulas:

BL = sequenceNumOfChosenOne - width - 1
BM = sequenceNumOfChosenOne - width 
BR = sequenceNumOfChosenOne - width + 1
LM = sequenceNumOfChosenOne - 1
RM = sequenceNumOfChosenOne + 1
TL = sequenceNumOfChosenOne + width - 1
TM = sequenceNumOfChosenOne + width 
TR = sequenceNumOfChosenOne + width + 1

My solution goes through the board in sequential order and calculates adjacent cells mathematically, without any data structure.  
As cells are identified, they are added to one of 3 linked lists: edgeAdjacent list, diagAdjacent list, or nonAdjacent list.  The
chosen cell is discarded.

The above evaluation of adjacents works great for general use, but before any left or right adjacent can be committed to 
its corresponding list, it must be determined that the cell currently being processed is not in the right of left column, 
respectively.  Top and bottom rows are not an issue.  I leave the proof of this to the reader.

This solution has a Big-O of (n) because there are no nested loops and sorting of cells is done sequentially.  

*/

 /** 
 * The Class FindAdjacents.
 * 
 * This Class is the Model portion that accepts a Point (a class that holds x,y coordinates) and the board width.  Upon 
 * Instantiation, the board is evaluated and the lists are created.  
 */
public class FindAdjacents {
	
	/** The width of the board. */
	private int width;
	
	/** The sequence number of the chosen one. */
	private int sequenceNumOfChosenOne;
	
	/** The chosen point. */
	private Point chosenPoint;
	
	/** The edge adjacent linked list. */
	private BSCellNode edgeAdjacent = null;
	
	/** The diag adjacent linked list. */
	private BSCellNode diagAdjacent = null;
	
	/** The non adjacent linked list. */
	private BSCellNode nonAdjacent = null;
	
	/**
	 * Instantiates a new find adjacents.
	 *
	 * @param width the width of the battleship board
	 * @param p the point that holds the (x,y) Cartesian coordinates for the chosen cell.
	 */
	public FindAdjacents(int width, Point p) {
		setWidth(width);
		setChosenPoint(p);
		setSequenceNumOfChosenOne(this.chosenPoint);
		sortLists();  // after this runs, the three linked lists will be complete and accessable
		
	}
	
	/**
	 * Sort lists.
	 * 
	 * This is a basic printout of the three lists.  It is used for testing purposes.
	 */
	private void sortLists() {
		
		int end = width * width;
		
		boolean currentCellNotInLeftColumn;
		boolean currentCellNotInRightColumn;
		
		for (int currentCell = 0 ; currentCell < end ; currentCell++) {
			
			currentCellNotInLeftColumn = (currentCell % width) != 0;
			currentCellNotInRightColumn = (currentCell % width) != (width - 1);
			
			if ((currentCell == (sequenceNumOfChosenOne - width - 1)) && currentCellNotInRightColumn) {	//I am the chosen one's BL
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent );
			} else if (currentCell == (sequenceNumOfChosenOne - width)) {       //I am the chosen one's BM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne - width + 1)) && currentCellNotInLeftColumn) { //I am the chosen one's BR
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent );
			} else if ((currentCell == (sequenceNumOfChosenOne -1)) && currentCellNotInRightColumn) { //I am the chosen one's LM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + 1)) && currentCellNotInLeftColumn) { //I am the chosen one's RM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + width - 1)) && currentCellNotInRightColumn) { //I am the chosen one's TL
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + width)) ) {     // I am the chosen one's TM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + width + 1)) && currentCellNotInLeftColumn	)  {//I am the chosen one's TR
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent);
			} else if (currentCell == sequenceNumOfChosenOne) { //I am Neo, the chosen one. I don't go on any list, so discard me and go on.
				;
			} else {    											//I am nobody, I am not adjacent to the chosen one at all
				nonAdjacent = new BSCellNode(currentCell,nonAdjacent);
			}
			
		}
			
	}
	
	/**
	 * Prints the lists.
	 */
	public void printLists() {
		
		while (edgeAdjacent != null) {
			System.out.println("Edges:" + edgeAdjacent.getCartesianCoordinates(width).toString());
			edgeAdjacent = edgeAdjacent.next;
			
		}
		System.out.println("");
		
		while (diagAdjacent != null) {
			System.out.println("Diags:" + diagAdjacent.getCartesianCoordinates(width).toString());
			diagAdjacent = diagAdjacent.next;
			
		}
		System.out.println("");
		
		while (nonAdjacent != null) {
			System.out.println("NA:" + nonAdjacent.getCartesianCoordinates(width).toString());
			nonAdjacent = nonAdjacent.next;
			
		}
	}
		
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the sequence num of chosen one.
	 *
	 * @return the sequence
	 */
	public int getSequenceNumOfChosenOne() {
		return sequenceNumOfChosenOne;
	}

	/**
	 * Sets the sequence num of chosen one.
	 *
	 * @param p the new sequence num of chosen one
	 */
	public void setSequenceNumOfChosenOne(Point p) {
		this.sequenceNumOfChosenOne = (p.getY() * getWidth()) + p.getX();
	}

	/**
	 * Gets the chosen point.
	 *
	 * @return the chosenPoint
	 */
	public Point getChosenPoint() {
		return chosenPoint;
	}

	/**
	 * Sets the chosen point.
	 *
	 * @param chosenPoint the chosenPoint to set
	 */
	public void setChosenPoint(Point chosenPoint) {
		this.chosenPoint = chosenPoint;
	}

	/**
	 * Gets the edge adjacent.
	 *
	 * @return the edgeAdjacent
	 */
	public BSCellNode getEdgeAdjacent() {
		return edgeAdjacent;
	}

	/**
	 * Sets the edge adjacent.
	 *
	 * @param edgeAdjacent the edgeAdjacent to set
	 */
	public void setEdgeAdjacent(BSCellNode edgeAdjacent) {
		this.edgeAdjacent = edgeAdjacent;
	}

	/**
	 * Gets the diag adjacent.
	 *
	 * @return the diagAdjacent
	 */
	public BSCellNode getDiagAdjacent() {
		return diagAdjacent;
	}

	/**
	 * Sets the diag adjacent.
	 *
	 * @param diagAdjacent the diagAdjacent to set
	 */
	public void setDiagAdjacent(BSCellNode diagAdjacent) {
		this.diagAdjacent = diagAdjacent;
	}

	/**
	 * Gets the non adjacent.
	 *
	 * @return the nonAdjacent
	 */
	public BSCellNode getNonAdjacent() {
		return nonAdjacent;
	}

	/**
	 * Sets the non adjacent.
	 *
	 * @param nonAdjacent the nonAdjacent to set
	 */
	public void setNonAdjacent(BSCellNode nonAdjacent) {
		this.nonAdjacent = nonAdjacent;
	}

}
