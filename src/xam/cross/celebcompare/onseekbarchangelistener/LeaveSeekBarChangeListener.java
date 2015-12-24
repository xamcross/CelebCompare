package xam.cross.celebcompare.onseekbarchangelistener;

import xam.cross.celebcompare.activity.GameActivity;
import xam.cross.celebcompare.activity.MainMenu;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class LeaveSeekBarChangeListener implements OnSeekBarChangeListener {

	GameActivity context;
	Intent intent;
	private int originalProgress;

	public LeaveSeekBarChangeListener(Context context) {
		super();
		this.context = (GameActivity) context;
		this.intent = new Intent(context, MainMenu.class);
		this.intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		this.intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (fromUser == true) {
			// only allow changes by 1 up or down
			if (progress > (originalProgress + 10)) {
				seekBar.setProgress(originalProgress);
			} else {
				originalProgress = progress;
				if (progress >= 90) {
					seekBar.setEnabled(false);
					context.startActivity(intent);
				}
			}
		}
		

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		originalProgress = seekBar.getProgress();
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		seekBar.setProgress(0);
	}

}
