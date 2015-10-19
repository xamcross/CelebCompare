package xam.cross.celebcompare.service;

import xam.cross.celebcompare.entity.Celebrity;
import xam.cross.celebcompare.utility.CompareCelebrity;

public class MainService {

	public static int compareCelebs(CompareCelebrity compareCelebrity,
			Celebrity depp, Celebrity stallone) {
		return compareCelebrity.compare(depp, stallone);
	}
	
}
