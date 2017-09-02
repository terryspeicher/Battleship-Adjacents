package systems.outofcontrol.battleshipadjacents;

public class FindAdjacents {
	
	private int width;
	private int sequence;
	private Point chosenPoint;
	private BSCellNode board = null;
	private BSCellNode edgeAdjacent = null;
	private BSCellNode diagAdjacent = null;
	private BSCellNode nonAdjacent = null;
	
	public FindAdjacents(int width, Point p) {
		// TODO Auto-generated constructor stub
		setWidth(width);
		setChosenPoint(p);
		setSequence(this.chosenPoint);
		
	}
	
	private void sortLists() {
		BSCellNode currentNode = board;
		int end = this.width * this.width;
		for (int currentCell = 0 ; currentCell < end ; currentCell++) {
			
			switch (currentCell) {
			
			
			}
			
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
	public int getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Point p) {
		this.sequence = p.getY() * getWidth() + p.getY();
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
