package xam.cross.celebcompare.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;

public class BackgroundAnimationListener implements AnimatorListener {

	private View animatedView;


	public BackgroundAnimationListener(View view) {
		animatedView = view;
	}

	@Override
	public void onAnimationCancel(Animator animation) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAnimationEnd(Animator animation) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onAnimationRepeat(Animator animation) {
		// TODO Auto-generated method stub
		setRandomY();
		((ValueAnimator) animation).setFloatValues(animatedView.getTranslationY(), animatedView.getTranslationY() + 200);
	}

	@Override
	public void onAnimationStart(Animator animation) {
		// TODO Auto-generated method stub

	}

	private void setRandomY() {
		int translationY = (int) (Math.random() * 200);
		animatedView.setTranslationY(translationY);
	}

}
