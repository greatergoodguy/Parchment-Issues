package com.burstingbrains.parchmentissues;

import android.os.Bundle;
import android.widget.GridView;

public class ActivityGridView extends ActivityMainMenu {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview);
		
		GridView gridView = (GridView) findViewById(R.id.gridview_gv);
		 
		AdapterRectangle adapter = new AdapterRectangle(this, 10);
		gridView.setAdapter(adapter);
	}	
}
