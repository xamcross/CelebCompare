package xam.cross.celebcompare.layout;

import java.util.ArrayList;
import java.util.List;

import xam.cross.celebcompare.activity.R;
import xam.cross.celebcompare.animation.BackgroundAnimation;
import xam.cross.celebcompare.animation.BackgroundAnimationListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class BackgroundLayout extends FrameLayout {

	private ImageView ivLogo;

	private ImageView ivStar;

	private ValueAnimator fallAnim;
	private ValueAnimator fadeAnim;
	private AnimatorSet fallingStar;
	private List<View> starViews;
	private List<View> childViews;

	private boolean createdBefore = false;
	
	private FrameLayout.LayoutParams frameParams;

	private Context context;

	public AnimatorSet getFallingStar() {
		return fallingStar;
	}

	public BackgroundLayout(Context context, ViewGroup.LayoutParams params, List<View> childViews) {
		super(context);
		
		this.setLayoutParams(params);
		this.setBackgroundColor(getResources().getColor(R.color.background));
		this.context = context;
		this.fallingStar = new AnimatorSet();
		this.starViews = new ArrayList<View>();
		this.childViews = new ArrayList<View>(childViews);
		
		ivLogo = new ImageView(context);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (!createdBefore) {
			for (int margin = 0; margin < this.getWidth() - 30; margin += 25) {

				ivStar = new ImageView(context);

				setStarLayout(margin);
				starViews.add(ivStar);
				setStarAnimation(ivStar);
				this.addView(ivStar);
			}
			setLogoLayout();
			setChildViews();
			
			fallingStar.start();
		}
		createdBefore = true;
	}

	private void setChildViews() {
		for (int i =0; i < this.childViews.size(); i++){
			View childView = this.childViews.get(i);
			if (childView.getParent() == null){
				this.addView(childView);
			}
			else {
				break;
			}
		}
	}

	private void setLogoLayout() {
		if (ivLogo.getParent() == null){
			frameParams = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			frameParams.gravity = Gravity.CENTER_HORIZONTAL;
			frameParams.topMargin = 15;
			
			ivLogo.setLayoutParams(frameParams);
	
			this.addView(ivLogo);
			ivLogo.setImageResource(R.drawable.biglogo);
		}
	}

	private void setStarLayout(int topMargin) {
		frameParams = new FrameLayout.LayoutParams((int) 19, 25);
		ivStar.setLayoutParams(frameParams);
		ivStar.setImageResource(R.drawable.golden_star_small);
		frameParams.setMargins(topMargin, (int) (Math.random() * 200), 0, 0);
	}

	private void setStarAnimation(ImageView ivStar) {
		int duration = getRandomDuration();

		fallAnim = BackgroundAnimation.animateFall(ivStar, duration);
		fadeAnim = BackgroundAnimation.animateFadeOut(ivStar, duration);

		fallingStar.play(fallAnim);
		fallingStar.play(fadeAnim);
		fallAnim.addListener(new BackgroundAnimationListener(ivStar));

	}

	private int getRandomDuration() {
		return (int) (Math.random() * 4000 + 1000);
	}

}
