package xam.cross.celebcompare.activity;

import static xam.cross.celebcompare.service.MainService.compareCelebs;
import xam.cross.celebcompare.entity.Celebrity;
import xam.cross.celebcompare.utility.CompareAge;
import xam.cross.celebcompare.utility.CompareNumberChildren;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Celebrity Depp = new Celebrity();
		Celebrity Stalone = new Celebrity();

		Depp.setAge(64);
		Stalone.setAge(64);

		Depp.setNumberChildren(2);
		Stalone.setNumberChildren(0);

		int resultAge = compareCelebs(new CompareAge(), Depp, Stalone);
		int resultNumberChildren = compareCelebs(new CompareNumberChildren(), Depp, Stalone);

		TextView tvHello = (TextView) findViewById(R.id.tvHello);
		tvHello.setText("Result age compare = " + resultAge + "\n"
				+ "Result children compare = " + resultNumberChildren);

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
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
