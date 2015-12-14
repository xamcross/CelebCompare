package xam.cross.celebcompare.activity;

import xam.cross.celebcompare.animation.BackgroundAnimation;
import xam.cross.celebcompare.animation.BackgroundAnimationListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainMenu extends Activity {

	Button btnNewGame;
	Button btnTutorial;
	Button btnAchievements;
	RelativeLayout rlMainMenu;
	LinearLayout llButtonsMainMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		rlMainMenu = (RelativeLayout) findViewById(R.id.rlMainMenu);
		llButtonsMainMenu = (LinearLayout) findViewById(R.id.llButtonsMainMenu);
		btnNewGame = (Button) findViewById(R.id.btnNewGame);
		btnTutorial = (Button) findViewById(R.id.btnTutorial);
		btnAchievements = (Button) findViewById(R.id.btnAchievements);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		
		ValueAnimator fallAnim;
		ValueAnimator fadeAnim;
		AnimatorSet fallingStar = new AnimatorSet();
		
		RelativeLayout.LayoutParams params;
		
		ImageView ivStar;
		
		Log.d("myLog", "Parent width = " + rlMainMenu.getWidth());

		int counter = 0;
		
		for (int margin = 0; margin < rlMainMenu.getWidth() - 50; margin += 50) {
			
			Log.d("myLog", "Loop counter = " + counter);
			
			
			ivStar = new ImageView(this);
			
			params = new RelativeLayout.LayoutParams((int) 37.5, 50);
			ivStar.setLayoutParams(params);
			ivStar.setImageResource(R.drawable.golden_star_pc_image_500_clr);
			params.setMargins(margin, (int) (Math.random() * 200), 0, 0);
			
			rlMainMenu.addView(ivStar);
			
			fallingStar.play(BackgroundAnimation.animateFall(ivStar, 3000));
			fallingStar.getChildAnimations().get(counter).addListener(new BackgroundAnimationListener(ivStar));
			counter++;
		}
		fallingStar.start();
	}

}
