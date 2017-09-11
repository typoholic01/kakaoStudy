package test05;

public class Rank {

	public Rank() {
		int[] target = {7,6,4,8};
		int[] rank = new int[4];
		
		int pivot = target[target.length/2];
		
		for (int i = 0; i < rank.length; i++) {
			
		}		
	}
	
	private int partition(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int temp;
		int pivot = arr[(i+j)/2];
		
		//참조하는 값이 right를 넘을 수 없다
		while (i <= j) {
			//pivot이 될때까지 pivot보다 큰 arr[i]를 찾는다
			while (arr[i] < pivot) {
				i++;
			}
			//pivot이 될때까지 pivot보다 작은 arr[j]를 찾는다
			while (pivot < arr[j]) {
				j--;
			}
			if (i <= j) {
				//pivot보다 큰 arr[i]와 pivot보다 작은 arr[j]를 스왑해준다.
				//pivot == arr[i]일 경우 pivot의 위치도 스왑된다
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				//가만히 냅두면 다시 같은 값을 참조하므로 증가시킨다
				i++;
				j--;
			}
		}
		//최종적으로 pivot[i+1]을 리턴하는 셈이다
		return i;

	}
	
	private void sort(int[] arr, int left, int right) {
		int index = partition(arr,left,right);
		
		if (left < index - 1) {
			sort(arr, left, right);
		}
		if (index < right) {
			sort(arr, left, right);
		}
		
	}
}
