package test05;

public class LandGetter2 {
	/*
	 * 문제 설명
땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다. 
1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 
단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.

예를 들면,

| 1 | 2 | 3 | 5 |
| 5 | 6 | 7 | 8 |
| 4 | 3 | 2 | 1 |

로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.

마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요. 
위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.

제한사항
행의 개수 N : 100,000 이하의 자연수
열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
점수 : 100 이하의 자연수

규칙
1. 최대값으로 내려와야 한다
2. 같은 열은 밟을 수 없다
	 * 
	 * */
	public LandGetter2() {
		
	}
	
	private int[] rank(int[][] land) {
		int[] rank = new int[3];
		/*
		 * 
		 * 
		 * */
	
		
		
		return null;
	}
	
	
	private int getMax(int[][] land) {
		/*
		 * 1. 첫번째 줄의 1,2,3,4위를 구한다
		 * 2. 두번째 줄의 1,2,3,4위를 구한다
		 * 3. 두번째 줄의 1위가 첫번째 줄의 1위와 위치가 같은지 찾는다
		 * 	3.1 다를 경우
		 * 		3.1.1 2번으로 돌아가 루프한다
		 * 	3.2 같을 경우
		 * 		3.2.1 첫번째 줄의 1위 두번째 줄의 2위와 첫번째 줄의 2위, 두번째 줄의 1위의 합을 계산한다
		 * 		3.2.2 둘 중 높은 쪽을 선택한다
		 * 		3.2.3 2번으로 돌아가 루프한다
		 * 
		 * 
		 * 
		 * */
		
		
        int answer = 0;
        int j = 0;
        int bfj = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        int forth = 0;
        int rowMax = 0;
        int bfMax = 0;
        
        for (int i = 0; i < land.length; i++) {
        	while (j < 4) {
        		switch (j) {
    			case 0:
    				first = land[i][j];
    				j++;
    				break;
    			case 1:
    				second = land[i][j];
    				rowMax = first > second ? first : second;

    				j++;
    				break;
    			case 2:
    				third = land[i][j];
    				rowMax = rowMax > third ? rowMax : third;

    				j++;
    				break;
    			case 3:
    				forth = land[i][j];
    				rowMax = rowMax > forth ? rowMax : forth;
    				
    				j++;
    				break;
    			default:
    				break;
    			}
			}
        	j = 0;
		}

        return answer;

	}
	
	private int getMax2(int[][] land) {		
        int answer = 0;
        int evenMax = 0;
        int evenj = 0;
        int oddMax = 0;
        int oddj = 0;
        
        for (int i = 0; i < land.length; i++) {
        	if (i % 2 == 0) {
    			for (int j = 0; j < land[0].length; j++) {
    				if (evenMax < land[i][j]) {
    					evenMax = land[i][j];
    					evenj = j;
					}
    				
    				if (j == land[0].length - 1) {
						if (evenj == oddj) {
							
						}
    					evenj = 0;
					}
    			}
    			answer += evenMax;
			} else {
    			for (int j = 0; j < land[0].length; j++) {				
    				oddMax = oddMax > land[i][j] ? oddMax : land[i][j];
    			}
    			answer += oddMax;		
			}
		}
        return answer;
	}
}
