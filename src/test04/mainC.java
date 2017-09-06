package test04;

public class mainC {

	public static void main(String[] args) {
		GetMap map = new GetMap();
		
//		int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//		int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int [][]board = {{0,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{0,0,1,0,1}};

		int result = 0;
		
		result = map.secondScan(board);

		System.out.println("최종 숫자는: " + result);
	}

}
