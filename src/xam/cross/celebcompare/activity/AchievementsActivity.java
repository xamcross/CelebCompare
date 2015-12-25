package xam.cross.celebcompare.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xam.cross.celebcompare.entity.Achievement;
import xam.cross.celebcompare.layout.BackgroundLayout;
import xam.cross.celebcompare.onclicklistener.BackToMenuClickListener;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AchievementsActivity extends Activity {

	List<View> childViews;
	ListView lvAchievements;
	BackgroundLayout blAchievementsActivity;
	LinearLayout llAchievementsActivity;
	Button btnLeave;
	List<Achievement> allAchievements;

	private static final String ATTRIBUTE_NAME_IMAGE = "image";
	private static final String ATTRIBUTE_NAME_TITLE = "title";
	private static final String ATTRIBUTE_NAME_DESCRIPTION = "description";
	private static final String ATTRIBUTE_NAME_ACHIEVED = "achieved";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setLayoutViews();

		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

		childViews = new ArrayList<View>();

		childViews.add(llAchievementsActivity);

		blAchievementsActivity = new BackgroundLayout(this, params, childViews);

		setContentView(blAchievementsActivity);

	}

	private void setLayoutViews() {

		llAchievementsActivity = (LinearLayout) getLayoutInflater().inflate(
				R.layout.activity_achievements, null, false);
		LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		llAchievementsActivity.setLayoutParams(params);

		setListView();

		btnLeave = (Button) llAchievementsActivity
				.findViewById(R.id.btnAchievementsLeave);
		btnLeave.setOnClickListener(new BackToMenuClickListener(this));
	}

	private void setListView() {

		Resources resources = getResources();
		
		int imageId = R.drawable.quick_punch;
		String titles[] = resources.getStringArray(R.array.achievements_titles);
		String descriptions[] = resources.getStringArray(R.array.achievements_descriptions);
		boolean achieved = false;

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>(titles.length);
		Map<String, Object> dummyMap;
		
		for (int i=0; i < titles.length; i++){
			dummyMap = new HashMap<String, Object>();
			dummyMap.put(ATTRIBUTE_NAME_IMAGE, imageId);
			dummyMap.put(ATTRIBUTE_NAME_TITLE, titles[i]);
			dummyMap.put(ATTRIBUTE_NAME_DESCRIPTION, descriptions[i]);
			dummyMap.put(ATTRIBUTE_NAME_ACHIEVED, achieved);
			data.add(dummyMap);
		}
		
		String from[] = { ATTRIBUTE_NAME_IMAGE, ATTRIBUTE_NAME_TITLE,
				ATTRIBUTE_NAME_DESCRIPTION, ATTRIBUTE_NAME_ACHIEVED };
		int to[] = { R.id.ivAchievementItemIcon, R.id.tvAchievementTitle,
				R.id.tvAchievementDescription, R.id.rbAchievement };

		lvAchievements = (ListView) llAchievementsActivity.findViewById(R.id.lvAchievements);

		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.achievement_item, from, to);
		lvAchievements.setAdapter(adapter);

	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(this, MainMenu.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.putExtra("caller", "AchievementsActivity");
		startActivity(intent);
	}
}
