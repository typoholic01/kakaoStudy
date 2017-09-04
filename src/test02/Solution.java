package test02;
/* http://www.algolist.net/Algorithms/Sorting/Quicksort */
/*   https://okky.kr/article/413010?note=1295508   */
class Solution {
    public boolean solution(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        
        boolean answer = true;
        
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] != 1) {
            	System.out.println("arr["+i+"] = " + arr[i]);
                answer = false;
            }
        }
        return answer;
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

	void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
        
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
