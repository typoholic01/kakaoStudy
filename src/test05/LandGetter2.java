package test05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandGetter2 {
	private static final Logger logger = LoggerFactory.getLogger(LandGetter2.class);
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
	public int getMax(int[][] land) {
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
		 * 1. 모든 줄의 index rank를 구한다
		 * i-1랭크의 1위와 i랭크의 1위의 index를 비교한다
		 * 불일치할 경우 다음줄, 일치할 경우 i-1랭크의 2위, i랭크의 1위, 혹은 i-1랭크의 1위, i랭크의 2위를 비교한다
		 * 다음줄로 넘어간다
		 * 
		 * 3개 이상으로 줄이 겹칠 경우 소팅의 가짓수가 늘어난다
		 * 
		 * 
		 * */
		int [][]index = new int[land.length][land[0].length];		
		int answer = 0;
		int i = 0;
		
		while (i < land.length) {
			index[i] = writeRank(land[i]);
        	
        	int max;
        	
        	if (i < land.length - 1) {
	        	int nowFirst = index[i][0];
	        	int nowSecond = index[i][1];
	        	int afterFirst = index[i+1][0];
	        	int afterSecond = index[i+1][1];
				
				if (nowFirst != afterFirst) {
					max = land[i][nowFirst];
    			} else if (nowFirst + afterSecond > nowSecond + afterFirst) {
    				max = land[i][nowFirst];
    			} else {
    				max = land[i][nowSecond];
    			}
				i++;
	        	answer += max;
			} else {
				
			}
        	
        	logger.info("{}번째 합산: {}",i,answer);
		}

        return answer;

	}
	
	int[] writeRank(int []arr)
	{
	    int []rank = new int[arr.length];
	    int []index = new int[arr.length];
	    
	    for (int i = 0; i < 4; i++) {
	    	for (int j = i + 1; j < 4; j++) {
				if (arr[i] > arr[j]) {
					rank[j] += 1;
				} else {
					rank[i] += 1;
				}
			}
	    	index[rank[i]] = i;
		}
	    
	    return index;
	}
}
