package systems.outofcontrol.battleshipadjacents;

public class BSCellNode {
	
	int value;
	BSCellNode next;
	
	public BSCellNode() {
		// TODO Auto-generated constructor stub
		this.value = -1;
		this.next = null;
		
	}
	
	public BSCellNode(int value, BSCellNode next) {
		this.value = value;
		this.next = next;
	}
	

}
