/**
* @author Aster Bodden Pineda 
* @author Abdullah Alaqeel
* This class implements a "C type" enum using the "int enum Pattern"
* This class defines a String Toy operator 
**/

/*
* Warning This should be the way to implement, USE ENUMS instead 
*/

public class cStringOperator{

	private static final int UPPERCASE = 0; 
	private static final int LOWERCASE = 1; 
	private static final int FIRSTUPPER = 2; 

	/**
	* @param Operation the operation to be applied to str String 
	* @param str  String to do Operation on 
	* @return A string after the operation is done, throws IllegalArgumentException if invalid operation 
	**/
	public static String apply(int Operation, String str ){
		switch (Operation){
			case UPPERCASE: return str.toUpperCase();

			case LOWERCASE: return str.toLowerCase();

			case FIRSTUPPER: 
							String[] words = str.split(" ");
							StringBuilder result = new StringBuilder(); // string builder to store result 
							for(String word : words){
								StringBuilder modWord = new StringBuilder(word);
								modWord.setCharAt(0,Character.toUpperCase(word.charAt(0))); // convert the first char to UpperCase
								result.append(" "+modWord); // add modified word to string builder 
							}
							return result.toString();

			default: 
				throw new IllegalArgumentException("Invalid Operation");
		}

	}

// Helper function to test logical functionality 
	public static void main ( String[] args){
		String str = "this Is the best Place to Be ";
		String result = cStringOperator.apply(cStringOperator.UPPERCASE, str);
		System.out.println("The converted String is = " + result );
		result = cStringOperator.apply(cStringOperator.LOWERCASE, str);
		System.out.println("The converted String is = " + result );
		result = cStringOperator.apply(cStringOperator.FIRSTUPPER, str);
		System.out.println("The converted String is = " + result );
	}

}