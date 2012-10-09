package com.example.colorcontroller;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ColorControllerActivity extends Activity {
	private ImageView imageView;
	private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
	private Button button,resetButton;
	
	private Bitmap bm ;
	
	private float []carray=new float[20]; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_controller);
        
        imageView = (ImageView) findViewById(R.id.imageView);
		linearLayout1 = (LinearLayout) findViewById(R.id.edit_text_linearlayout1);
		linearLayout2 = (LinearLayout) findViewById(R.id.edit_text_linearlayout2);
		linearLayout3 = (LinearLayout) findViewById(R.id.edit_text_linearlayout3);
		linearLayout4 = (LinearLayout) findViewById(R.id.edit_text_linearlayout4);
		button = (Button) findViewById(R.id.button);
		resetButton = (Button) findViewById(R.id.button_reset);
		
		bm = bitmapFromDrawable(imageView.getDrawable());
		resetButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				imageView.setImageBitmap(bm);
				
			}
		});
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText et = (EditText) linearLayout1.getChildAt(0);//1
				carray[0] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout1.getChildAt(1);//0
				carray[1] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout1.getChildAt(2);//0
				carray[2] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout1.getChildAt(3);//0
				carray[3] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout1.getChildAt(4);//0
				carray[4] = Float.valueOf(et.getText().toString());
				
				et = (EditText) linearLayout2.getChildAt(0);//0
				carray[5] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout2.getChildAt(1);//1
				carray[6] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout2.getChildAt(2);//0
				carray[7] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout2.getChildAt(3);//0
				carray[8] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout2.getChildAt(4);//0
				carray[9] = Float.valueOf(et.getText().toString());
				
				et = (EditText) linearLayout3.getChildAt(0);//0
				carray[10] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout3.getChildAt(1);//0
				carray[11] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout3.getChildAt(2);//1
				carray[12] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout3.getChildAt(3);//0
				carray[13] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout3.getChildAt(4);//0
				carray[14] = Float.valueOf(et.getText().toString());
				
				et = (EditText) linearLayout4.getChildAt(0);//0
				carray[15] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout4.getChildAt(1);//0
				carray[16] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout4.getChildAt(2);//0
				carray[17] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout4.getChildAt(3);//1
				carray[18] = Float.valueOf(et.getText().toString());
				et = (EditText) linearLayout4.getChildAt(4);//0
				carray[19] = Float.valueOf(et.getText().toString());
				
				Bitmap bitmap = Bitmap.createBitmap(bm);
				Paint paint = new Paint(); 
				paint.setColorFilter(null); 
				Canvas canvas = new Canvas(bitmap);
				ColorMatrix cm = new ColorMatrix(); 
				//设置颜色矩阵 
				cm.set(carray); 
				//颜色滤镜，将颜色矩阵应用于图片 
				paint.setColorFilter(new ColorMatrixColorFilter(cm)); 
				//绘图 
				canvas.drawBitmap(bitmap, 0, 0, paint); 
				
				imageView.setImageBitmap(bitmap);
			}
		});
    }
    
    public static Bitmap bitmapFromDrawable(Drawable drawable) {
		Bitmap bitmap = Bitmap
				.createBitmap(
						drawable.getIntrinsicWidth(),
						drawable.getIntrinsicHeight(),
						drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
								: Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas();
		canvas.setBitmap(bitmap);
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());
		drawable.draw(canvas);
		return bitmap;
	}

}
