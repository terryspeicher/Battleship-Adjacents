package systems.outofcontrol.battleshipadjacents;

public class Point {

	private int x;
	private int y;
	//private int sequence;	//Starting at 0, numbering each cell sequentially, starting
				  	//at bottom left and going right, then up, continuing right
	
	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.setX(x); 
		this.setY(y);
		
	}
	
	@Override
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	

}
