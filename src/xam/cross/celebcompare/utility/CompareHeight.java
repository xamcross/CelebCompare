package xam.cross.celebcompare.utility;

import xam.cross.celebcompare.entity.Celebrity;

public class CompareHeight implements CompareCelebrity {

	@Override
	public int compare(Celebrity lhs, Celebrity rhs) {
		return ((Double)lhs.getHeightCm()).compareTo((Double)rhs.getHeightCm());
	}

}
