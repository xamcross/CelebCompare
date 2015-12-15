package xam.cross.celebcompare.activity;

import xam.cross.celebcompare.entity.Celebrity;
import xam.cross.celebcompare.service.DBHelper;
import xam.cross.celebcompare.service.MainService;
import xam.cross.celebcompare.utility.CompareAge;
import xam.cross.celebcompare.utility.CompareWealth;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvCelebLeft;
	TextView tvCelebRight;
	TextView tvCelebParam;
	TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvCelebLeft = (TextView) findViewById(R.id.tvCelebLeft);
		tvCelebRight = (TextView) findViewById(R.id.tvCelebRight);
		tvCelebParam = (TextView) findViewById(R.id.tvCelebParam);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		tvCelebParam.setText("Wealth");
		
		/*DBHelper dbHelper = new DBHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		dbHelper.loadAllCelebrities(db);
		
		if (Celebrity.getTwoRandomCelebs() != null){
			Object[] celebrities = Celebrity.getTwoRandomCelebs().toArray();
			Celebrity depp = (Celebrity)celebrities[0];
			Celebrity stallone = (Celebrity)celebrities[1];
			tvCelebLeft.setText(depp.getName());
			tvCelebRight.setText(stallone.getName());
			int result = MainService.compareCelebs(new CompareAge(), depp, stallone);
			if (result > 0){
				tvResult.setText(depp.getName() + " is younger than " + stallone.getName());	
			}
			else if (result < 0){
				tvResult.setText(stallone.getName() + " is younger than " + depp.getName());
			}
			else {
				tvResult.setText(depp.getName() + " and " + stallone.getName() + " are of the same age");
			}
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent context in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
