package systems.outofcontrol.battleshipadjacents;

import java.util.Scanner;

public class BattleshipAdjacents {

	private static final long serialVersionUID = 7678032691516184112L;
	public final static int WIDTH = 9;  //Represents the width (and height) of the board
	
	public static void main(String[] args) {
		Point selectedCell = new Point(5,8);
		FindAdjacents FA = new FindAdjacents(WIDTH,selectedCell);
		FA.printLists();
		
		// read points format: (5, 5)  3 0  4,1  a7  b 2
		
	    Scanner input = new Scanner(System.in);
	    
	    System.out.println("Please enter battleship coordinates:");
	    String shot = input.nextLine();
	    Point chosen = parseCoordinates(shot);
	    	System.out.println( chosen != null ? chosen.toString() : "Unable to parse coordinates entered." );
	    	
	    	
	    	
	}
	
	private static Point parseCoordinates(String s) {
		String in = s.toUpperCase().trim();
		String stringX = "";
		String stringY = "";
		int x;
		int y;
		boolean valid = true;
		
		
		if (in.length() < 2) {
			valid = false;
		} 
		
		in = in.replace(")", "");   
		in = in.replace("(", "");
		
		if (in.indexOf(',') != -1) {
			String[] split = in.split(",");
			stringX = split[0];
			stringY = split[1];
		}
		
		if (in.indexOf(' ') > 0) {
			String[] split = in.split(" ");
			stringX = split[0];
			stringY = split[1];
		}
		
		if (in.length() == 2) {
			stringX = Character.toString(in.charAt(0));
			stringY = Character.toString(in.charAt(1));
		}

		System.out.println("left: " + stringX + " right: " + stringY);

		return null; //new Point(5,5);
		
	}
	
//	import javax.swing.JOptionPane;
//
//	public class Ch3_20 {
//
//	    /**
//	     * @param args the command line arguments
//	     */
//	    public static void main(String[] args) {
//	        // TODO code application logic here
//	      
//	        String string1,string2,relation;
//	        int result;
//	        string1 = JOptionPane.showInputDialog("Enter your name:");
//	        /*string2 = JOptionPane.showInputDialog("Enter second String");
//	        
//	        result = string1.compareTo(string2);
//	        
//	        if (result < 0)
//	        {
//	        relation = " < ";
//	        }
//	        else if (result > 0)
//	        {
//	            relation = " > ";
//	        }
//	        else
//	        {
//	            relation = " = ";
//	        }
//	        */
//	        if (string1.compareToIgnoreCase("Timothy")==0)
//	        {
//	          JOptionPane.showMessageDialog(null,"Do I know you?");
//	        };
//	           
//	    }
//	    
//	}
	

}
