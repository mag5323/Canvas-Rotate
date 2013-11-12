package com.example.animate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity {
	
	CustomView cv;
	SeekBar RPM;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final LinearLayout mLayout = (LinearLayout)findViewById(R.id.main);
		
		RPM = (SeekBar)findViewById(R.id.RPMbar);
		
		cv = new CustomView(this, null);
		mLayout.addView(cv);   

		
		RPM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){                         
              @Override
              public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            	  cv.setRPM(progress);
				  cv.invalidate();
              }

              @Override
              public void onStartTrackingTouch(SeekBar arg0) {
                      // TODO Auto-generated method stub

              }

              @Override
              public void onStopTrackingTouch(SeekBar arg0) {
                      // TODO Auto-generated method stub

              }
      });
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
