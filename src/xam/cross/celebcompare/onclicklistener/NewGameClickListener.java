package xam.cross.celebcompare.onclicklistener;

import xam.cross.celebcompare.activity.GameActivity;
import xam.cross.celebcompare.activity.R;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class NewGameClickListener implements OnClickListener {

	Context context;
	
	public NewGameClickListener(Context context){
		super();
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		//Animation slide = AnimationUtils.loadAnimation(context, R.anim.slideleft);
		//ViewGroup parentView = (ViewGroup) v.getParent();
		//parentView.startAnimation(slide);
		
		Intent intent = new Intent(context, GameActivity.class);
		intent.putExtra("caller", "MainMenuActivity");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		context.startActivity(intent);
		
	}

}
