package systems.outofcontrol.battleshipadjacents;

public class BattleshipAdjacents {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7678032691516184112L;
	public final static int WIDTH = 9;  //Represents the width (and height) of the board
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point selectedCell = new Point(5,5);
		FindAdjacents FA = new FindAdjacents(WIDTH,selectedCell);
		BSCellNode diagAdjacent = null;
		BSCellNode diagEdge = null;
		BSCellNode notAdjacent = null;
		BSCellNode board = null;
		FA.printLists();
		
	}

}
