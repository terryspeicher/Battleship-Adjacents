package systems.outofcontrol.battleshipadjacents;

public class Point {

	private int x;
	private int y;
	private int sequence;	//Starting at 0, numbering each cell sequentially, starting
				  	//at bottom left and going right, then up, continuing right
	
	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.sequence = this.y * WIDTH + this.x;
		
		
	}
	
	

}
