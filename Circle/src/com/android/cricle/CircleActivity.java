package com.android.cricle;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class CircleActivity extends Activity {
	/** Called when the activity is first created. */
	Circleview view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		FrameLayout layout = (FrameLayout) findViewById(R.id.Lottery);
		int screnWidth = getWindowManager().getDefaultDisplay().getWidth();
		/**
		 * 添加随机数，制定奖项数量为上限，一般抽奖中什么都是服务器返回的，
		 * 可以在请求服务器接口成功再指定转盘转到那个奖项
		 */

		final Random random = new Random();
		final Circleview claert = new Circleview(this, screnWidth);
		
		layout.addView(claert, new LayoutParams(LayoutParams.MATCH_PARENT,
				DensityUtil.dip2px(this, 300)));
		layout.setPadding(10, 0, 0,0);
		claert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int place = random.nextInt(9);
				Log.e("当前的位置", place + "");
				claert.setPlace(place);
				claert.setStopPlace(place);
				claert.setStopRoter(false);
			}
		});
		
		findViewById(R.id.begin_btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int place = random.nextInt(9);
				Log.e("当前的位置", place + "");
				claert.setPlace(place);
				claert.setStopPlace(place);
				claert.setStopRoter(false);
			}
		});
		findViewById(R.id.end_btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				claert.setStopRoter(true);
			}
		});
	}
}