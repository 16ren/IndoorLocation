package com.indoorlocation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.content.Intent;
import android.content.SharedPreferences;
/**
 * @author chenlei
 * @version v1.0
 */
public class LogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);

		SharedPreferences sharedPreferences = getSharedPreferences(Config.CONFIGFILE, 0);
		boolean isfirststart = sharedPreferences.getBoolean("isfirststart", true);

		if (isfirststart) {
			Intent intent = new Intent(this, GuideActivity.class);
			startActivity(intent);
			this.finish();
			SharedPreferences.Editor editor= sharedPreferences.edit();
			editor.putBoolean("isfirststart", false);
			editor.commit();
		} else {
			ImageView imageLogo = (ImageView) findViewById(R.id.img_logo);
			Animation animation = AnimationUtils.loadAnimation(this, R.anim.logoanimation);
			imageLogo.setAnimation(animation);
			animation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(LogoActivity.this, MainActivity.class);
					startActivity(intent);
					LogoActivity.this.finish();
				}
			});
			animation.startNow();
			
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logo, menu);
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
