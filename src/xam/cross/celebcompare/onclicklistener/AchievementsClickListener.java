package xam.cross.celebcompare.onclicklistener;

import xam.cross.celebcompare.activity.AchievementsActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class AchievementsClickListener implements OnClickListener {

	Context context;
	
	public AchievementsClickListener(Context context){
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(context, AchievementsActivity.class);
		intent.putExtra("caller", "MainMenuActivity");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		context.startActivity(intent);
	}

}
