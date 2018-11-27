/**
 * @author Aster Bodden Pineda
 * @author Abdullah Alaqeel
 * This class implements a "C type" enum using Java Enums
 * This class defines a String Toy operator
 *
 */
public enum StringOperator {
	// all of the enum values have to implement the apply method 
	UPPERCASE {public String apply(String str){return str.toUpperCase();}},
	LOWERCASE {public String apply(String str){return str.toLowerCase();}},
	FIRSTUPPER {
		public String apply(String str) {
			String[] words = str.split(" ");
			StringBuilder result = new StringBuilder(); // string builder to store result
			// adding the words
			for (String word : words) {
				int l = result.length();
				result.append(" ").append(word).setCharAt(l+1, Character.toUpperCase(word.charAt(0)));
			}
			return result.deleteCharAt(0).toString();
		}
	},
	CAMELCASE {
		public String apply (String str) {

			String[] w = str.split(" ");
			StringBuilder result = new StringBuilder(); // string builder to store result
			// adding the first word
			result.append(w[0]).setCharAt(0, Character.toLowerCase(w[0].charAt(0)));
			// adding the rest of the words
			for (int i = 1; i < w.length; i++) {
				int l = result.length();
				result.append(w[i]).setCharAt(l, Character.toUpperCase(w[i].charAt(0)));
			}
			return result.toString();
		}
	};

	/**
	 * @param str String to apply Operation
	 * @return String processed afrer operation
	 */
	public abstract String apply(String str );

	/**
	 * The constructor is private because it is not needed.
	 */
	private StringOperator(){

	}

	public static void main(String[] args ){
		String str = "Enums make things awesome";
		System.out.println(str);
		for(StringOperator op : StringOperator.values()) // apply all variations
			System.out.printf("%s applied:\n\t%s\n", op, op.apply(str));
	}
}