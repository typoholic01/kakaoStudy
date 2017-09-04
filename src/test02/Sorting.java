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
	/* http://www.algolist.net/Algorithms/Sorting/Quicksort */
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

	void quickSort(int arr[], int left, int right) {
		// 배열을 반을 자르는게 아니라, pivot을 설정 하는 방법이 배열의 절반인겁니다.
		// 배열을 자르는 기준은 이 index입니다. index가 결정되는 조건은 partition로직을 보세요
		System.out.println("정렬 범위: left=" + left + " right=" + right);
		System.out.print("정렬 전 값: ");
		for (int j = left; j <= right ; j++) {
			System.out.print(arr[j] + ",");
		}
		System.out.println("");
		int index = partition(arr, left, right);
		
		System.out.print("정렬 후 값: ");
		for (int j = left; j <= right ; j++) {
			System.out.print(arr[j] + ",");
		}
		System.out.println("");
		System.out.println("자르기 기준: index=" + index + " Value=" + arr[index]);
		System.out.println("자른 배열 퀵정렬 할 건지 여부: " + "L=" +(left < index - 1) + " R=" + (index < right));
		System.out.println("");

		// 왼쪽을 정렬 할건지 여부 확인 및 왼쪽 정렬
		if (left < index - 1)
			//재귀로 반복한다
			quickSort(arr, left, index - 1);
		// 오른쪽을 정렬할건지 여부 확인 및 오른쪽 정렬
		if (index < right)
			quickSort(arr, index, right);
		
		// 즉 왼쪽 오른쪽 둘다 정렬 안하는것이 재귀 탈출 조건
	}

}
