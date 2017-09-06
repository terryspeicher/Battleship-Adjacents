/*
 * Terry Speicher, CS 3331, HW1
 */
package systems.outofcontrol.battleshipadjacents;

import java.util.Scanner;

/**
 * The Class BattleshipAdjacents.
 * 
 * This is the controller in the MVC model for HW1.  It gets the input, calls the controller (class FindAdjacents), then uses 
 * the rudimentary view to display the results in a console window.
 */
public class BattleshipAdjacents {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7678032691516184112L;
	
	/** The Constant WIDTH. */
	public final static int WIDTH = 9;  //Represents the width (and height) of the board
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
	    Scanner input = new Scanner(System.in);
	    MyPoint chosen;
	    
	    do {
		System.out.print("Please enter coordinates (0,0) through (8,8): ");
	    String shot = input.nextLine();
	    chosen = parseCoordinates(shot);
     	System.out.println( chosen != null ? "Examining coordinates : " + chosen.toString() : "Unable to parse coordinates entered." );
	    } while (chosen == null);
	    
		FindAdjacents FA = new FindAdjacents(WIDTH,chosen);  //Create the FindAdjacents class.  
		
		
		FA.printListsInColumns();
		
	}
	
	/**
	 * Parses the coordinates from the string that the user types in.  Repeats user input if it can not extract Cartesian
	 * coordinates.  
	 *
	 * @param s the string that the user has typed in that we must now parse.
	 * @return the myPoint that holds a valid set of Cartesian coordinates - the "chosen one"
	 */
	private static MyPoint parseCoordinates(String s) {
		
		// read points format: (5, 5)  3 0  4,1  a7  b 2
		
		String in = s.toUpperCase().trim();
		String stringX = "";
		String stringY = "";
		int x = -1;
		int y = -1;
		boolean valid = true;
		
		
		if (in.length() < 2) {      //input has to have at least 2 characters to be valid
			valid = false;
		} 
		
		in = in.replace(")", "");   //Get rid of parenthesis
		in = in.replace("(", "");
		
		//At this point, if the input is valid, then there should only be letters [A-I] and numbers [0-8],
		//with a space, a comma, or nothing, separating the two coordinates
		
		if (in.indexOf(',') != -1) {        //comma separator, split at comma
			String[] split = in.split(",");
			stringX = split[0];
			stringY = split[1];
		}
		
		if (in.indexOf(' ') > 0) {             //space separator, split at space
			String[] split = in.split(" ");
			stringX = split[0];
			stringY = split[1];
			
		}
		
		if (in.length() == 2) {                          //nothing separating, split in middle
			stringX = Character.toString(in.charAt(0));
			stringY = Character.toString(in.charAt(1));
		}

		if ((stringX.length() != 1) || (stringY.length() != 1)){  //Both should have only one character to be valid
			valid = false;
		}
		//Check to make sure stringX is only A-I or 0-8
		if (valid && (!((stringX.charAt(0) >= 48) && (stringX.charAt(0) <= 56)) &&       // if ! 48<=X<=56   and
				!((stringX.charAt(0) >= 65) && (stringX.charAt(0) <= 73)))) {   // if ! 65<=X<=73
			valid = false;
		}
		//Same with stringY
		if (valid && (!((stringY.charAt(0) >= 48) && (stringY.charAt(0) <= 56)) &&          // if ! 48<=Y<=56  and
				!((stringY.charAt(0) >= 65) && (stringY.charAt(0) <= 73))))  {   // if ! 65<=Y<=73
			valid = false;
		}
		//if still valid, then convert the strings into their integer values
		if (valid) {
			
			if ((stringX.charAt(0) >= 48) && (stringX.charAt(0) <= 56)) {  //48 = ascii('0')
				x = stringX.charAt(0) - 48;
			} else { x = stringX.charAt(0) - 65; }                         //65 = ascii('A')
			if ((stringY.charAt(0) >= 48) && (stringY.charAt(0) <= 56)) {
				y = stringY.charAt(0) - 48;
			} else { y = stringY.charAt(0) - 65; }

		}
	
		return ( valid ? new MyPoint(x,y) : null); 
		
	}
	
	

}
