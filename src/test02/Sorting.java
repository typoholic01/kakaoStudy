package test02;
/**
 * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.

제한사항
배열의 길이는 10만 이하입니다.
배열의 원소는 10만 이하의 자연수입니다.
입출력 예
arr	result
[4, 1, 3, 2]	true
[4, 1, 3]	false
입출력 예 설명
입출력 예 #1
입력이 [4, 1, 3, 2]가 주어진 경우, 배열의 길이가 4이므로 배열에는 1부터 4까지 숫자가 모두 들어 있어야 합니다. [4, 1, 3, 2]에는 1부터 4까지의 숫자가 모두 들어 있으므로 true를 반환하면 됩니다.

입출력 예 #2
[4, 1, 3]이 주어진 경우, 배열의 길이가 3이므로 배열에는 1부터 3까지 숫자가 모두 들어 있어야 합니다. [4, 1, 3]에는 2가 없고 4가 있으므로 false를 반환하면 됩니다.
 * 
 * */
public class Sorting {
	/*http://www.algolist.net/Algorithms/Sorting/Quicksort
*/	private int partition(int[] arr, int left, int right) {
		int i = left;
		int j = right;
		int temp;
		int pivot = arr[(i+j)/2];
		
		//여기서 pivot은 가상의 값. 최종적으로 증가된 arr[i]가 pivot이 된 셈이 된다
		//참조하는 값이 right를 넘을 수 없다
		while (i <= j) {
			//pivot보다 커질때까지 i를 증가시킨다
			while (arr[i] < pivot) {
				i++;
			}
			//pivot보다 작아질때까지 j를 감소시킨다
			while (pivot < arr[j]) {
				j--;
			}
			if (i<=j) {
				//변환할 일이 생기면 변환한다
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				//가만히 냅두면 다시 같은 값을 참조하므로 증가시킨다
				i++;
				j--;
			}
		}
		return i;
	}

	void quickSort(int arr[], int left, int right) {
		//배열을 반으로 나눠 정렬한다
	    int index = partition(arr, left, right);
	    //index가 1보다 클 경우 
	    if (left < index - 1)
	          quickSort(arr, left, index - 1);
	    if (index < right)
	          quickSort(arr, index, right);
	}

}