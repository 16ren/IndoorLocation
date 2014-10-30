package com.indoorlocation;

import java.util.ArrayList;


import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.view.LayoutInflater;

public class GuideActivity extends Activity {

	private GestureDetector gestureDetector;
	final int RIGHT = 0;
	final int LEFT = 1;

	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	private ViewGroup main, group;
	private ImageView imageView;
	private ImageView[] imageViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		gestureDetector = new GestureDetector(this, gesturelistener);

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
		viewPager = (ViewPager)main.findViewById(R.id.guidePages);
		//初始化小圆点
		for(int i = 0; i<pageViews.size();i++)
		{
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(20, 20));
			imageView.setPadding(20, 0, 20, 0);
			imageViews[i]=imageView;
		/*	if(i==0)
			{
				//imageViews[i].setb
			}else {
				
			}
			group.addView(imageViews[i]);*/
		}

	}

	private GestureDetector.OnGestureListener gesturelistener = new GestureDetector.SimpleOnGestureListener() {
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			System.out.println("" + velocityX);
			float move = e2.getX() - e1.getX();
			if (move > 0) {
				doResult(RIGHT);
			} else {
				doResult(LEFT);
			}
			return true;
		}
	};

	private void doResult(int action) {
		// TODO Auto-generated method stub
		switch (action) {
		case RIGHT:
			System.out.println("go right");
			break;
		case LEFT:
			System.out.println("go left");
			break;
		default:
			break;
		}
	};

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
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
