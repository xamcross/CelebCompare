package xam.cross.celebcompare.onclicklistener;

import xam.cross.celebcompare.activity.MainMenu;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class BackToMenuClickListener implements OnClickListener {

	Context context;
	
	public BackToMenuClickListener(Context context){
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(context, MainMenu.class);
		intent.putExtra("caller", "AchievementsActivity");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		context.startActivity(intent);
	}

}
