package com.indoorlocation;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings.System;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends Activity {

	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	private ViewGroup main, group;
	private ImageView imageView;
	private ImageView[] imageViews;
	private Button buttong_experience;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = getLayoutInflater();
		pageViews = new ArrayList<View>();
		pageViews.add(inflater.inflate(R.layout.guide_view_01, null));
		pageViews.add(inflater.inflate(R.layout.guide_view_02, null));
		pageViews.add(inflater.inflate(R.layout.guide_view_03, null));
		pageViews.add(inflater.inflate(R.layout.guide_view_04, null));
		imageViews = new ImageView[pageViews.size()];
		main = (ViewGroup) inflater.inflate(R.layout.activity_guide, null);
		// group是R.layou.activity_guide中的负责包裹小圆点的LinearLayout.
		group = (ViewGroup) main.findViewById(R.id.viewGroup);
		viewPager = (ViewPager) main.findViewById(R.id.guidePages);
		// 初始化小圆点
		for (int i = 0; i < pageViews.size(); i++) {
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(50, 50));
			imageView.setPadding(20, 0, 20, 0);
			imageViews[i] = imageView;
			if (i == 0) {
				imageViews[i].setBackgroundResource(R.drawable.guide_indicator_focused);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.guide_indicator);
			}
			group.addView(imageViews[i]);
		}
		setContentView(main);
		viewPager.setAdapter(new GuidePageAdapter());
		viewPager.setOnPageChangeListener(new GuidePageChangeListener());
	}

	/**
	 * 指引页面Adapter
	 */
	class GuidePageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).removeView(pageViews.get(arg1));
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).addView(pageViews.get(arg1));
			buttong_experience = (Button) pageViews.get(arg1).findViewById(R.id.buttonexperience);
			if (buttong_experience != null) {
				buttong_experience.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// gotoStartActivity();
						gotoStartActivity();
					}

				});
			}
			return pageViews.get(arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * 指引页面的监听器
	 */
	class GuidePageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[arg0].setBackgroundResource(R.drawable.guide_indicator_focused);
				if (arg0 != i) {
					imageViews[i].setBackgroundResource(R.drawable.guide_indicator);
				}
			}

		}

	}

	private void gotoStartActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_start, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
