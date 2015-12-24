package xam.cross.celebcompare.onclicklistener;

import xam.cross.celebcompare.activity.GameActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class StartClickListener implements OnClickListener {

	Context context;
	
	public StartClickListener(Context context){
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(context, GameActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.putExtra("caller", "StartActivity");
		context.startActivity(intent);
	}

}
