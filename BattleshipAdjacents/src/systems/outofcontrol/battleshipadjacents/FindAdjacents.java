package systems.outofcontrol.battleshipadjacents;

//72  73  74  75  76  77  78  79  80
//63  64  65  66  67  68  69  70  71
//54  55  56  57  58  59  60  61  62
//45  46  47  48  49  50  51  52  53
//36  37  38  39  40  41  42  43  44
//27  28  29  30  31  32  33  34  35
//18  19  20  21  22  23  24  25  26
//09  10  11  12  13  14  15  16  17
//00  01  02  03  04  05  06  07  08






public class FindAdjacents {
	
	private int width;
	private int sequenceNumOfChosenOne;
	private Point chosenPoint;
	private BSCellNode board = null;
	private BSCellNode edgeAdjacent = null;
	private BSCellNode diagAdjacent = null;
	private BSCellNode nonAdjacent = null;
	
	public FindAdjacents(int width, Point p) {
		// TODO Auto-generated constructor stub
		setWidth(width);
		setChosenPoint(p);
		setSequenceNumOfChosenOne(this.chosenPoint);
		sortLists();  // after this runs, the three linked lists will be complete and accessable
		
	}
	
	private void sortLists() {
		int end = width * width;
		
		boolean currentCellNotInLeftColumn;
		boolean currentCellNotInRightColumn;
		
		for (int currentCell = 0 ; currentCell < end ; currentCell++) {
			
			currentCellNotInLeftColumn = (currentCell % width) != 0;
			currentCellNotInRightColumn = (currentCell % width) != (width - 1);
			
			if ((currentCell == (sequenceNumOfChosenOne - width - 1)) && currentCellNotInRightColumn) {	//I am the chosen one's BL
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent );
			} else if (currentCell == (sequenceNumOfChosenOne - width)) {  //I am the chosen one's BM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne - width + 1)) && currentCellNotInLeftColumn) { //I am the chosen one's BR
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent );
			} else if ((currentCell == (sequenceNumOfChosenOne -1)) && currentCellNotInRightColumn) { //I am the chosen one's LM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + 1)) && currentCellNotInLeftColumn) { //I am the chosen one's RM
				edgeAdjacent = new BSCellNode(currentCell, edgeAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + width - 1)) && currentCellNotInRightColumn) { //I am the chosen one's TL
				diagAdjacent = new BSCellNode(currentCell, diagAdjacent);
			} else if ((currentCell == (sequenceNumOfChosenOne + width)) ) { // I am the chosen one's TM
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
	
	public void printLists() {
		
		while (edgeAdjacent != null) {
			System.out.println("Edges:" + edgeAdjacent.value);
			edgeAdjacent = edgeAdjacent.next;
			
		}
		System.out.println("");
		
		while (diagAdjacent != null) {
			System.out.println("Diags:" + diagAdjacent.value);
			diagAdjacent = diagAdjacent.next;
			
		}
		System.out.println("");
		
		while (nonAdjacent != null) {
			System.out.println("NA:" + nonAdjacent.value);
			nonAdjacent = nonAdjacent.next;
			
		}
	}
		
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the sequence
	 */
	public int getSequenceNumOfChosenOne() {
		return sequenceNumOfChosenOne;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequenceNumOfChosenOne(Point p) {
		this.sequenceNumOfChosenOne = (p.getY() * getWidth()) + p.getX();
	}

	/**
	 * @return the chosenPoint
	 */
	public Point getChosenPoint() {
		return chosenPoint;
	}

	/**
	 * @param chosenPoint the chosenPoint to set
	 */
	public void setChosenPoint(Point chosenPoint) {
		this.chosenPoint = chosenPoint;
	}

	/**
	 * @return the board
	 */
	public BSCellNode getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(BSCellNode board) {
		this.board = board;
	}

	/**
	 * @return the edgeAdjacent
	 */
	public BSCellNode getEdgeAdjacent() {
		return edgeAdjacent;
	}

	/**
	 * @param edgeAdjacent the edgeAdjacent to set
	 */
	public void setEdgeAdjacent(BSCellNode edgeAdjacent) {
		this.edgeAdjacent = edgeAdjacent;
	}

	/**
	 * @return the diagAdjacent
	 */
	public BSCellNode getDiagAdjacent() {
		return diagAdjacent;
	}

	/**
	 * @param diagAdjacent the diagAdjacent to set
	 */
	public void setDiagAdjacent(BSCellNode diagAdjacent) {
		this.diagAdjacent = diagAdjacent;
	}

	/**
	 * @return the nonAdjacent
	 */
	public BSCellNode getNonAdjacent() {
		return nonAdjacent;
	}

	/**
	 * @param nonAdjacent the nonAdjacent to set
	 */
	public void setNonAdjacent(BSCellNode nonAdjacent) {
		this.nonAdjacent = nonAdjacent;
	}

}
