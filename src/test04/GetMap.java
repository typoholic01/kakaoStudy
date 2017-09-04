package test04;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetMap {
	Logger logger = LogManager.getLogger(mainC.class);
	List<XY> xys = new ArrayList<XY>();
	int result = 0;
	/*
	 * https://www.acmicpc.net/problem/1915
	 * */
	public GetMap() {
		/**
		 * 1. 전체스캔
		 * 2. 1만 남은 부분을 재귀 재스캔
		 * 3. 0이 될때까지 반복
		 * 4. 0이 되었을 때 값을 리턴
		 * 
		 * */
	}
	
	
	
	public int recursion(int [][]board) {
		logger.info("진입: recursion");
		
		if (!xys.isEmpty()) {
			board = secondScan(board);
			recursion(board);
		} else {
			result = result * result;
		}
		
		return result;
	}
	
	public void init(int [][]board) {
		logger.info("진입: init");
		//처음 x,y를 세팅한다
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				XY xy = new XY();
				
				xy.setX(i);
				xy.setY(j);
				
				xys.add(xy);
			}
		}
	}
	
	private int[][] secondScan(int [][]board) {
		logger.info("진입: secondScan");

		int [][]neoBoard = new int[board.length][board[0].length];		//구성값을 바꾼 새로운 보드를 추가한다		
		List<XY> xysAf = new ArrayList<>();								//xys값 구성을 바꿀 새 리스트를 준비한다
		
		for (XY xy : xys) {
			XY temp = new XY();
			
			int i = xy.getX();
			int j = xy.getY();

			logger.info("now board[" + i + "][" + j + "] : " + board[i][j]);
			//2X2를 이룰 경우 +1해서 새로운 보드에 저장한다
			
			//TODO i,j가 끝일 경우 스킵한다
			if (i != board.length -1 && j != board[0].length - 1 && board[i][j] != 0 && board[i+1][j] != 0 && board[i][j+1] != 0 && board[i+1][j+1] != 0) {
				neoBoard[i][j] = board[i][j] + 1;
				temp.setX(i);
				temp.setY(j);
				
				logger.info("new XY: " + i + "," + j);
				result = board[i][j] + 1;
				xysAf.add(temp);
			} else {
				neoBoard[i][j] = 0;
			}
		}
		//새로운 xys 구성으로 교체한다
		xys.clear();
		xys = xysAf;
		
		if (xys.isEmpty()) {
			return board;
		}
		
		return neoBoard;
	}
}