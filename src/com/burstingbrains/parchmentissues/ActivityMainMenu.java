package com.burstingbrains.parchmentissues;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		
		Button buttonGridView = (Button) findViewById(R.id.mainmenu_gridview);
		buttonGridView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ActivityGridView.class);
				startActivity(intent);
			}
		});
		
		Button buttonGPVZoom = (Button) findViewById(R.id.mainmenu_gpvZoom);
		buttonGPVZoom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ActivityGPVZoom.class);
				startActivity(intent);
			}
		});
		
		Button buttonScrollingWithFewElements = (Button) findViewById(R.id.mainmenu_scrollingWithFewElements);
		buttonScrollingWithFewElements.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ActivityScrollingWithFewElements.class);
				startActivity(intent);
			}
		});
	}
}
