/**
 * @author Aster Bodden Pineda
 * @author Abdullah Alaqeel
 * This class implements a "C type" enum using the "int enum Pattern"
 * This class defines a String Toy operator
 *
 * Warning This should not be the way to implement, USE ENUMS instead
 */

public class cStringOperator{

	private static final int UPPERCASE = 0;
	private static final int LOWERCASE = 1;
	private static final int FIRSTUPPER = 2;
	private static final int CAMELCASE = 3;
	/**
	 * @param Operation the operation to be applied to str String
	 * @param str  String to do Operation on
	 * @return A string after the operation is done, throws IllegalArgumentException if invalid operation
	 **/
	public static String apply(int Operation, String str){
		switch (Operation){
			case UPPERCASE: return str.toUpperCase();

			case LOWERCASE: return str.toLowerCase();

			case FIRSTUPPER:
				String[] words = str.split(" ");
				StringBuilder result = new StringBuilder(); // string builder to store result
				// adding the words
				for (String word : words) {
					int l = result.length();
					result.append(" ").append(word).setCharAt(l+1, Character.toUpperCase(word.charAt(0)));
				}
				return result.deleteCharAt(0).toString();
			case CAMELCASE:
				String[] w = str.split(" ");
				StringBuilder r = new StringBuilder(); // string builder to store result

				//adding the first word
				r.append(w[0]).setCharAt(0, Character.toLowerCase(w[0].charAt(0)));
				// adding the rest of the words
				for (int i = 1; i < w.length; i++) {
					int l = r.length();
					r.append(w[i]).setCharAt(l, Character.toUpperCase(w[i].charAt(0)));
				}

				return r.toString();
			default:
				throw new IllegalArgumentException("Invalid Operation");
		}

	}

	// Helper function to test logical functionality
	public static void main ( String[] args){
		String str = "This Is the best Place to Be ";
		String result = cStringOperator.apply(0, str);
		System.out.println("The converted String is = " + result );
		result = cStringOperator.apply(1, str);
		System.out.println("The converted String is = " + result );
		result = cStringOperator.apply(2, str);
		System.out.println("The converted String is = " + result );
		result = cStringOperator.apply(3, str);
		System.out.println("The converted String is = " + result );
	}

}