package test05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainC {
	private static final Logger logger = LoggerFactory.getLogger(MainC.class);
	
	public static void main(String[] args) {
		int[][] test = {{1,2,3,5},{5,6,7,8},{4,3,2,7},{5,9,7,10},{5,6,10,12}};
		Researching cls = new Researching();
		
		int []maxList = cls.getMaxList(test);
		
		int [][]section = cls.extractSection(maxList);
		
		for (int i = 0; i < maxList.length; i++) {
			logger.info("{}번째 1위: {}",i,maxList[i]);
		}
		
		for (int i = 0; i < section.length; i++) {
			for (int j = 0; j < section[0].length; j++) {
				switch (j) {
				case 0:
					logger.info("시점: {}",section[i][0]);
					break;
				case 1:
					logger.info("종점: {}",section[i][1]);					
					break;
				}
			}
		}
		
	}

}
