package xam.cross.celebcompare.utility;

import xam.cross.celebcompare.entity.Celebrity;

public class CompareNumberSpouses implements CompareCelebrity{

	@Override
	public int compare(Celebrity lhs, Celebrity rhs) {
		return ((Integer)lhs.getNumberSpouses()).compareTo((Integer)rhs.getNumberSpouses());
	}

	
}
