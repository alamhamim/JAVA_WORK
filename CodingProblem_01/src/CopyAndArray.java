
public class CopyAndArray {

	public int[] copyAnArray(int[] givenArray) {
		int[]  one = new int[givenArray.length];
		
		for (int i = 0; i < one.length; i++) {
			one[i] = givenArray[i]; 
		}
		
		return one;
		
	}
	
	public static void main(String[] args) {
		CopyAndArray copyAnArray =  new CopyAndArray();
		
		int a[] = {1,2,3,4,4};
		
		  for (int i : a) {
			  System.out.println(i);
			
		}
	}
	
}
