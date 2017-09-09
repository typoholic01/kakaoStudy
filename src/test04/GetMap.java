package test04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetMap {
	/*https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220800582008&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
*/	Logger logger = LoggerFactory.getLogger(getClass());
	int result = 0;
	/*
	 * https://www.acmicpc.net/problem/1915
	 * */
	public GetMap() {
		/**	NOT CACHING
		 * 1. 전체스캔
		 * 2. 1만 남은 부분을 재귀 재스캔
		 * 3. 0이 될때까지 반복
		 * 4. 0이 되었을 때 값을 리턴
		 * 
		 * */
	}
	
	private int minVal(int a, int b, int c) {
		logger.info("minVal 진입");
		logger.info("a: {}",a);
		logger.info("b: {}",b);
		logger.info("c: {}",c);
		
		a = a < b ? a : b;
		return a < c ? a : c;		
	}
	
	public int secondScan(int [][]board) {
		logger.info("진입: secondScan");
		logger.info("x 길이: {}",board[0].length - 1);
		logger.info("y 길이: {}",board.length - 1);
		
		//init
		int d = 0;
		int result = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				logger.info("board[{}][{}]: {}",i,j,board[i][j]);
				
				if (board[i][j] == 1) {
					d = 1;

					//가로 세로 1번째 줄을 제외하고 합산한다
					if (i > 0 && j > 0) {
						d = minVal(board[i-1][j-1], board[i-1][j], board[i][j-1]) + 1;
						logger.info("result: {}",result);	
						logger.info("d: {}",d);
					}
				}
				result = result > d ? result : d;
				board[i][j] = d;
				d = 0;
			}
		}
		
		return result * result;
	}
}