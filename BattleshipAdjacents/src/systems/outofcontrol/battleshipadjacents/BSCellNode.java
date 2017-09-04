package systems.outofcontrol.battleshipadjacents;

public class BSCellNode {
	
	int value;
	BSCellNode next;
	
	public BSCellNode() {
		this.value = -1;
		this.next = null;
		
	}
	
	public BSCellNode(int value, BSCellNode next) {
		this.value = value;
		this.next = next;
	}
	
	public Point getCartesianCoordinates(int width) {
		return new Point(this.value % width, this.value /width);
	}

}
