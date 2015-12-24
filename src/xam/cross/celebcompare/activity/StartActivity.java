package xam.cross.celebcompare.activity;

import xam.cross.celebcompare.onclicklistener.StartClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class StartActivity extends Activity {

	Button btnStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.golayout);

		btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new StartClickListener(this));
	}

	@Override
	public void onBackPressed(){
		
	}
	
}
