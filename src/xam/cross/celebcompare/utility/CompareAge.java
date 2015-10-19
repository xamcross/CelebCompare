package xam.cross.celebcompare.utility;

import java.sql.Date;

import xam.cross.celebcompare.entity.Celebrity;

/**
 * Compares who is younger (younger gives positive result)
 * @author XAM_CROSS
 *
 */
public class CompareAge implements CompareCelebrity{
	
	public int compare(Celebrity lhs, Celebrity rhs){
		return ((Date)lhs.getAge()).compareTo((Date)rhs.getAge());
	}

}
