package xam.cross.celebcompare.achievement;

import java.util.List;

import xam.cross.celebcompare.entity.Achievement;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class AchievementsAdapter extends BaseAdapter {

	Context context;
	
	public AchievementsAdapter(Context context, int layoutId, List<Achievement> achievements){
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
