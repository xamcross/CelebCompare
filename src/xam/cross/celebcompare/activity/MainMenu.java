package xam.cross.celebcompare.activity;

import xam.cross.celebcompare.layout.BackgroundLayout;
import xam.cross.celebcompare.onclicklistener.NewGameClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainMenu extends Activity {

	Button btnNewGame;
	Button btnTutorial;
	Button btnAchievements;
	BackgroundLayout blMainMenu;
	LinearLayout llButtonsMainMenu;
	FrameLayout flMainMenu;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		flMainMenu = (FrameLayout) findViewById(R.id.flMainMenu);
		llButtonsMainMenu = (LinearLayout) findViewById(R.id.llButtonsMainMenu);
		btnNewGame = (Button) findViewById(R.id.btnNewGame);
		btnTutorial = (Button) findViewById(R.id.btnTutorial);
		btnAchievements = (Button) findViewById(R.id.btnAchievements);

		blMainMenu = new BackgroundLayout(this, flMainMenu.getLayoutParams());
		flMainMenu.removeAllViews();
		flMainMenu.addView(blMainMenu);
		flMainMenu.addView(llButtonsMainMenu);
		
		btnNewGame.setOnClickListener(new NewGameClickListener(this));
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);

	}

}
