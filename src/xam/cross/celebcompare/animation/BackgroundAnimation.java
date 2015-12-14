package xam.cross.celebcompare.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;

public class BackgroundAnimation{

	private static ValueAnimator fallAnimator;
	
	private static ValueAnimator fadeOutAnimator;
	
	public static ValueAnimator animateFall(View view, int duration){
		fallAnimator = ObjectAnimator.ofFloat(view, "TranslationY", view.getTranslationY() , view.getTranslationY() + 350);
		fallAnimator.setDuration(duration);
		fallAnimator.setRepeatCount(Animation.INFINITE);
		fallAnimator.setRepeatMode(Animation.RESTART);
		return fallAnimator;
	}
	
	public static ValueAnimator animateFadeOut(View view, int duration){
		fadeOutAnimator = ObjectAnimator.ofFloat(view, "Alpha", view.getAlpha(), 0f);
		fadeOutAnimator.setDuration(duration);
		fadeOutAnimator.setRepeatCount(Animation.INFINITE);
		fadeOutAnimator.setRepeatMode(Animation.RESTART);
		return fadeOutAnimator;
	}
}
