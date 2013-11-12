package com.example.animate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {

	Bitmap bitmapOrg;
	int width, height, rpm;
	int RPMperGrad = 8000/12;
	float angle;
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		if(!isInEditMode()){
			bitmapOrg = BitmapFactory.decodeResource(getResources(),R.drawable.tick).copy(Bitmap.Config.ARGB_8888,  true );
			width = bitmapOrg.getWidth();
			height = bitmapOrg.getHeight();
		} 
	}
	
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int max = (int) Math.sqrt(width^2 + height^2);		
		
		angle = (float) ( this.rpm / RPMperGrad * 15 );
		
		Log.d("setRPM", this.rpm + "");		
		Log.d("angle", this.angle + "");
		
		canvas.translate(max, max);
		canvas.save();
		canvas.rotate(angle, width/2, height/2);
	    canvas.drawBitmap(bitmapOrg, 0, 0, null);
	    canvas.restore();
	}
	
	public void setRPM(int progress){		
		this.rpm = progress;				
	}
	
}