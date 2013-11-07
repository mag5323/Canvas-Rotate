package com.example.animate;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(),R.drawable.ticker).copy(Bitmap.Config.ARGB_8888,  true );
	
	    int width = bitmapOrg.getWidth();
	    int height = bitmapOrg.getHeight();
	    Bitmap targetBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height);
	    
	    Canvas canvas = new Canvas(targetBitmap);
	    Matrix matrix = new Matrix();
	    matrix.setRotate(50, width/2, height/2);
	    canvas.drawBitmap(bitmapOrg, matrix, new Paint());
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
