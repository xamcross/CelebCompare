package xam.cross.celebcompare.utility;

import xam.cross.celebcompare.entity.Celebrity;

public class CompareWealth implements CompareCelebrity {

	@Override
	public int compare(Celebrity lhs, Celebrity rhs) {
		return ((Double)lhs.getWealthMillions()).compareTo((Double)rhs.getWealthMillions());
	}

}
