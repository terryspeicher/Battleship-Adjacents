/*
 * Terry Speicher, CS 3331, HW1
 */
package systems.outofcontrol.battleshipadjacents;

/**
 * The Class Point.
 */
public class Point {

	/** The x coordinate. */
	private int x;
	
	/** The y coordinate. */
	private int y;
	//private int sequence;	//Starting at 0, numbering each cell sequentially, starting
				  	//at bottom left and going right, then up, continuing right
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.setX(x); 
		this.setY(y);
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	/**
	 * Gets the x coordinate
	 *
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate.
	 *
	 * @param x the new x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate.
	 *
	 * @param y the new y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	

}
