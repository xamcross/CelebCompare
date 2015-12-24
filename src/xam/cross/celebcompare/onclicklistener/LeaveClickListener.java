package xam.cross.celebcompare.onclicklistener;

import xam.cross.celebcompare.activity.GameActivity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class LeaveClickListener implements OnClickListener {

	Context context;
	
	public LeaveClickListener(Context context){
		super();
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		
		GameActivity activity = (GameActivity) this.context;
		activity.showLeaveBar();
		
	}

}
