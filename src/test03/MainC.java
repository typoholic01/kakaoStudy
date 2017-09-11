package test03;

public class MainC {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		
		int [][]v = {{1, 4}, {3, 4}, {3, 10}};
		int []answer = r.insertCoordinate(v);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println("x: " + answer[i]);			
		}

	}

}
