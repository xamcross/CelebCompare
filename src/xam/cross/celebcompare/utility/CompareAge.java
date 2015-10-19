package xam.cross.celebcompare.utility;

import xam.cross.celebcompare.entity.Celebrity;

public class CompareAge implements CompareCelebrity{
	
	public int compare(Celebrity lhs, Celebrity rhs){
		return ((Integer)lhs.getAge()).compareTo((Integer)rhs.getAge());
	}

}
