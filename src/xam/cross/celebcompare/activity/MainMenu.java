package xam.cross.celebcompare.activity;

import java.util.ArrayList;
import java.util.List;

import xam.cross.celebcompare.layout.BackgroundLayout;
import xam.cross.celebcompare.onclicklistener.AchievementsClickListener;
import xam.cross.celebcompare.onclicklistener.NewGameClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainMenu extends Activity {

	Button btnNewGame;
	Button btnTutorial;
	Button btnAchievements;
	BackgroundLayout blMainMenu;
	LinearLayout llButtonsMainMenu;
	List<View> childViews;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		setMainMenuButtons();
		
		childViews = new ArrayList<View>();
		
		childViews.add(llButtonsMainMenu);
		
		blMainMenu = new BackgroundLayout(this, params, childViews);

		setContentView(blMainMenu);

	}

	public void setMainMenuButtons(){
		llButtonsMainMenu = (LinearLayout) getLayoutInflater().inflate(
				R.layout.main_menu, null, false);
		
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.gravity = Gravity.CENTER;
		
		llButtonsMainMenu.setLayoutParams(params);

		btnNewGame = (Button) llButtonsMainMenu.findViewById(R.id.btnNewGame);

		btnTutorial = (Button) llButtonsMainMenu.findViewById(R.id.btnTutorial);

		btnAchievements = (Button) llButtonsMainMenu
				.findViewById(R.id.btnAchievements);

		btnNewGame.setOnClickListener(new NewGameClickListener(this));
		
		btnAchievements.setOnClickListener(new AchievementsClickListener(this));

	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);

	}

	@Override
	public void onResume(){
		super.onResume();
		Log.d("myLog", "MainMenu onResume()");
	}
	
}
