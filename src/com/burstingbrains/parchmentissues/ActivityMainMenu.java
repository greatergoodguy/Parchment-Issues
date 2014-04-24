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
		
		Button buttonIssue1 = (Button) findViewById(R.id.mainmenu_issue1);
		buttonIssue1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ActivityIssue1.class);
				startActivity(intent);
			}
		});
	}
}
