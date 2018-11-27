public enum StringOperator{
	// all of the enum values have to implement the apply method 
	UPPERCASE{public String apply(String str){return str.toUpperCase();}}, 
	LOWERCASE{public String apply(String str){return str.toLowerCase();}},
	FIRSTUPPER{public String apply(String str){
		String[] words = str.split(" ");
							StringBuilder result = new StringBuilder(); // string builder to store result 
							for(String word : words){
								StringBuilder modWord = new StringBuilder(word);
								modWord.setCharAt(0,Character.toUpperCase(word.charAt(0))); // convert the first char to UpperCase
								result.append(" "+modWord); // add modified word to string builder 
							}
							return result.toString();
	}};

	// enum fields: 

	/**
	* @param str String to apply Operation 
	* @return String processed afrer operation 
	*/
	public abstract String apply(String str );

	// constructor 
	StringOperator(){

	}
}