package test05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Researching {
	private static final Logger logger = LoggerFactory.getLogger(Researching.class);	
	
	public Researching() {
	}
	
	/**************
	 * 
	 * 발생하고 있는 문제
	 * 	1. 나온 값을 전부 더하는 문제
	 * 	2. 특정 구간의 최적값을 구하는 문제
	 * 	3. 특정 구간을 구하는 문제
	 * 	4. MaxList를 구하는 문제
	 * 
	 * */
	
	/**
	 * 
	 * 1. 최대값을 전부 더한다
	 * 2. 최대값의 좌표가 일치할 경우 최대값이 되는 값쌍을 더한다
	 * 	2.1. 10개가 일치할 경우 
	 * 
	 * */
	
//	int[][] extractSection(int []maxList) {
//		//init
//		int [][]section = new int[maxList.length][2];
//		int startNum = 0;
//		int endNum = 0;
//		int j = 0;
//		
//		//run
//		for (int i = 0; i < maxList.length - 1; i++) {
//			//좌표가 일치할 경우 종점을 증가시킨다
//			if (maxList[i] == maxList[i+1]) {
//				endNum = i+1;				
//			} else {
//				//일치하지 않을 경우 구간이 1이상 있을 때만 등록한다
//				if (endNum - startNum > 0) {
//					section[j][0] = startNum;
//					section[j][1] = endNum;
//					j++;										
//				}
//				startNum = i;
//			}
//		}		
//		
//		return section;
//		
//	}
//	
//	int[] getMaxList(int [][]land) {
//		//init
//		int []solve = new int[land.length];
//		int []rank = new int[land[0].length];
//	    int []index = new int[land[0].length];
//		
//
//		//run
//	    
//	    for (int i = 0; i < land.length; i++) {
//	    	for (int j = 0; j < 4; j++) {
//		    	for (int k = j + 1; k < 4; k++) {
//					if (land[i][j] > land[i][k]) {
//						rank[k] += 1;
//					} else {
//						rank[j] += 1;
//					}
//				}
//		    	index[rank[j]] = j;
//		    	rank[j] = 0;		    	
//			}
//			solve[i] = index[0];
//		}
//	    
//	    return solve;
//
//	}

}
