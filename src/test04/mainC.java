package test04;

public class mainC {

	public static void main(String[] args) {
		GetMap map = new GetMap();
		
		int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};

		int result = 0;
		map.init(board);
		
		result = map.recursion(board);

		System.out.println("최종 숫자는: " + result);
	}

}
