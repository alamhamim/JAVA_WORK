
public class FibonacciNumber {

	public void fibonacciNumber(int givenNumber) {
		
		int numOne = 0;
		int numTwo = 1;
		int count = 0;
		
//		0,1,1,2,3,5,8,13
		
		while (count<givenNumber) {
			System.out.println(numOne);
			
//			adding given number to the numOne and storing it in addNumber
			int numThree = numOne+numTwo;
			numOne = numTwo;
			numTwo = numThree;
			count = count+1;
			 
			
		}
		
	}
	
}
