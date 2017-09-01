package test02;

public class Main {
	
	public static void main(String[] args) {
		Sorting test = new Sorting();
		
		int[] arr = {1,3,5,7,9,8,6,4,2};
		
		test.quickSort(arr, 0, arr.length -1);
	}

}
