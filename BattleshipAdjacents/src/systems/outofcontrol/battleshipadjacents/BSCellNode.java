/*
 * Terry Speicher, CS 3331, HW1
 */
package systems.outofcontrol.battleshipadjacents;

/**
 * The Class BSCellNode.
 * 
 * The BSCellNode is used to hold the representation of a single square off of the battleship board.  It simply 
 * holds the sequential number of the cell and the link to the next node.
 */
public class BSCellNode {
	
	/** The sequential value of the square location on the battleship board. */
	int value;
	
	/** The next node link. */
	BSCellNode next;
	
	/**
	 * Instantiates a new BS cell node.  This is a general use constructor, used mostly for testing
	 */
	public BSCellNode() {
		this.value = -1;
		this.next = null;
		
	}
	
	/**
	 * Instantiates a new BS cell node.
	 *
	 * @param value the sequential value of the battleship square from the board
	 * @param next the link to the next node.
	 */
	public BSCellNode(int value, BSCellNode next) {
		this.value = value;
		this.next = next;
	}
	
	/**
	 * Gets the Cartesian coordinates.
	 *
	 * @param width the width of the battleship board
	 * @return the Cartesian coordinates
	 */
	public Point getCartesianCoordinates(int width) {
		return new Point(this.value % width, this.value /width);
	}

}
