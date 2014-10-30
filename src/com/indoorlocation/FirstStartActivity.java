package com.indoorlocation;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class FirstStartActivity extends Activity {

	private GestureDetector gestureDetector;
	final int RIGHT = 0;
	final int LEFT = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_start);
		gestureDetector = new GestureDetector(this, gesturelistener);
	}

	private GestureDetector.OnGestureListener gesturelistener = new GestureDetector.SimpleOnGestureListener() {
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			System.out.println(""+velocityX); 
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
