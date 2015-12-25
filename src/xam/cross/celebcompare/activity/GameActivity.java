package xam.cross.celebcompare.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import xam.cross.celebcompare.layout.BackgroundLayout;
import xam.cross.celebcompare.onclicklistener.LeaveClickListener;
import xam.cross.celebcompare.onseekbarchangelistener.LeaveSeekBarChangeListener;
import xam.cross.celebcompare.service.DBHelper;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class GameActivity extends Activity {

	TextView tvCelebLeft;
	TextView tvCelebRight;
	TextView tvCelebParam;
	TextView tvResult;
	LinearLayout llCompareButtons;
	LinearLayout llGameActivity;
	BackgroundLayout blGameActivity;
	List<View> childViews;
	Button btnLeave;
	SeekBar sbLeave;
	TextView tvTimer;
	public static CountDownTimer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setLayoutViews();

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

		childViews = new ArrayList<View>();

		childViews.add(llGameActivity);

		blGameActivity = new BackgroundLayout(this, params, childViews);

		setContentView(blGameActivity);

		DBHelper dbHelper = new DBHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		// dbHelper.loadAllCelebrities(db);

		// if (Celebrity.getTwoRandomCelebs() != null){ Object[] celebrities =
		// Celebrity.getTwoRandomCelebs().toArray(); Celebrity depp =
		// (Celebrity)celebrities[0]; Celebrity stallone =
		// (Celebrity)celebrities[1]; tvCelebLeft.setText(depp.getName());
		// tvCelebRight.setText(stallone.getName()); int result =
		// MainService.compareCelebs(new CompareAge(), depp, stallone); if
		// (result > 0){ tvResult.setText(depp.getName() + " is younger than " +
		// stallone.getName()); } else if (result < 0){
		// tvResult.setText(stallone.getName() + " is younger than " +
		// depp.getName()); } else { tvResult.setText(depp.getName() + " and " +
		// stallone.getName() + " are of the same age"); } }

	}

	private void setLayoutViews() {

		llGameActivity = (LinearLayout) getLayoutInflater().inflate(
				R.layout.activity_game, null, false);

		LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		llGameActivity.setLayoutParams(params);

		tvCelebLeft = (TextView) llGameActivity.findViewById(R.id.tvCelebLeft);
		tvCelebRight = (TextView) llGameActivity
				.findViewById(R.id.tvCelebRight);
		tvCelebParam = (TextView) llGameActivity
				.findViewById(R.id.tvCelebParam);
		tvResult = (TextView) llGameActivity.findViewById(R.id.tvResult);
		llCompareButtons = (LinearLayout) llGameActivity
				.findViewById(R.id.llCompareButtons);
		btnLeave = (Button) llGameActivity.findViewById(R.id.btnLeave);
		btnLeave.setOnClickListener(new LeaveClickListener(this));

		sbLeave = (SeekBar) llGameActivity.findViewById(R.id.sbLeave);
		sbLeave.setOnSeekBarChangeListener(new LeaveSeekBarChangeListener(this));

		tvTimer = (TextView) llGameActivity.findViewById(R.id.tvTimer);

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

	public void showLeaveBar() {
		btnLeave.setVisibility(View.GONE);
		sbLeave.setVisibility(View.VISIBLE);
	}

	public void hideLeaveBar() {
		sbLeave.setProgress(0);
		sbLeave.setVisibility(View.GONE);
		btnLeave.setVisibility(View.VISIBLE);
	}

	@Override
	protected void onResume() {
		super.onResume();

		hideLeaveBar();

		Intent intent = new Intent(this, StartActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		Intent callerIntent = getIntent();

		String callerName = callerIntent.getStringExtra("caller");
		
		if (callerName.equals("MainMenuActivity")) {
			this.startActivity(intent);
		}
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		Intent callerIntent = getIntent();

		String callerName = callerIntent.getStringExtra("caller");
		
		if (callerName.equals("StartActivity")) {
			timer = new CountDownTimer(7000, 1000) {

				public void onTick(long millisUntilFinished) {
					long timeShown = TimeUnit.MILLISECONDS
							.toSeconds(millisUntilFinished) - 1;
					if (timeShown > 0) {
						tvTimer.setText("" + timeShown);
					} else {
						tvTimer.setText("" + 0);
						this.cancel();
					}
				}

				public void onFinish() {

				}

			};
			timer.start();
		}
	}
	
	@Override
	public void onBackPressed() {
	}
}
