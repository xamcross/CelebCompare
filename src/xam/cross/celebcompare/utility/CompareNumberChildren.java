package xam.cross.celebcompare.utility;

import xam.cross.celebcompare.entity.Celebrity;

public class CompareNumberChildren implements CompareCelebrity{

	public int compare(Celebrity lhs, Celebrity rhs){
		return ((Integer)lhs.getNumberChildren()).compareTo((Integer)rhs.getNumberChildren());
	}
	
}
