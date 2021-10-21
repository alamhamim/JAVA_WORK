
public class ReverseString {
	
	public static void reserveString(String givenString) {
		//string givenString = "Hello world";
		String words[] = givenString.split(" ");
	
		StringBuffer stringBuffer = new StringBuffer();
		
		
		for (String word : words) {
			for(int i = word.length()-1; i>=0; i--) {
				stringBuffer.append(word.charAt(i));
			}
			
			stringBuffer.append(" ");
			
		}
		
		 System.out.println(stringBuffer.toString().trim());
		
	}
	
	 public static void main(String[] args) {
		 reserveString("hello world");
	}

}
