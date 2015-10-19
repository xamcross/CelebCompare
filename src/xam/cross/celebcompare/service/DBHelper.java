package xam.cross.celebcompare.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	final static int DB_VERSION = 1;

	public DBHelper(Context context) {
		super(context, "celebCompareDb", null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table celebrities (id integer primary key autoincrement, "
				+ "name text, age integer, numChildren integer, numSpouses integer, wealth real, height real);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

	public void loadAllCelebrities(SQLiteDatabase db) {
		Cursor cursor = db.query("celebrities", null,null,null,null,null,null);
		
		if (cursor.moveToFirst()){
			int idColIndex = cursor.getColumnIndex("id");
			int idNameIndex = cursor.getColumnIndex("name");
			int idAgeIndex = cursor.getColumnIndex("age");
			int idNumChildrenIndex = cursor.getColumnIndex("numChildren");
			int idNumSpousesIndex = cursor.getColumnIndex("numSpouses");
			int idWealthIndex = cursor.getColumnIndex("wealth");
			int idHeightIndex = cursor.getColumnIndex("height");
			
			do {
				
			}
			while(cursor.moveToNext());
		}
	}

}
