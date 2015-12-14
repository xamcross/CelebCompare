package xam.cross.celebcompare.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.util.Log;
import android.view.View;

public class BackgroundAnimationListener implements AnimatorListener {

	private View animatedView;
	private static int counter = 0;
	private static int repeat = 0;
	
	public BackgroundAnimationListener(View view) {
		animatedView = view;
	}

	@Override
	public void onAnimationCancel(Animator animation) {
		// TODO Auto-generated method stub
		Log.d("myLog", "onAnimationCancel");
	}

	@Override
	public void onAnimationEnd(Animator animation) {
		// TODO Auto-generated method stub
		Log.d("myLog","onAnimationEnd");
	}

	@Override
	public void onAnimationRepeat(Animator animation) {
		// TODO Auto-generated method stub
		Log.d("myLog","onAnimationRepeat, counter = " + repeat);
		repeat++;
	}

	@Override
	public void onAnimationStart(Animator animation) {
		// TODO Auto-generated method stub
		Log.d("myLog","onAnimationStart, counter = " + counter);
		counter++;
	}

}
