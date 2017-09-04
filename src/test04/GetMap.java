package test04;

import java.util.ArrayList;
import java.util.List;

public class GetMap {
	List<XY> xys = new ArrayList<XY>();
	XY xy = new XY();
	/*
	 * https://www.acmicpc.net/problem/1915
	 * */
	public GetMap(int [][]board) {
		/**
		 * 1. 전체스캔
		 * 2. 1만 남은 부분을 재귀 재스캔
		 * 3. 0이 될때까지 반복
		 * 4. 0이 되었을 때 값을 리턴
		 * 
		 * */
		
	}
	
	private void firstScan() {
		/**
		 * 1 이었을 경우 i, j 값을 저장
		 * 
		 * */
		
	}
	
	private void secondScan(int [][]board, int i, int j) {
		/*
		 * for문 바깥에서 clear한다
		 * xys.clear();*/
		
		if (board[i+1][j] != 0 && board[i][j+1] != 0 && board[i+1][j+1] != 0) {
			board[i][j] = 1;
			xy.x = i;
			xy.y = j;
			xys.add(xy);
		} else {
			board[i][j] = 0;
		}
	}
}