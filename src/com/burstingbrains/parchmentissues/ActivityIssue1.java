package com.burstingbrains.parchmentissues;

import java.util.ArrayList;
import java.util.List;

import com.burstingbrains.parchmentissues.toybox.AdapterRectangle;

import mobi.parchment.widget.adapterview.gridpatternview.GridPatternItemDefinition;
import mobi.parchment.widget.adapterview.gridpatternview.GridPatternView;
import android.os.Bundle;
import android.widget.BaseAdapter;

public class ActivityIssue1 extends ActivityMainMenu {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issue1);
		
		final GridPatternView<BaseAdapter> gridPatternView = (GridPatternView<BaseAdapter>) findViewById(R.id.issue1_gpv);

		final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();

//		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 2, 2));
//		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
//		gridPatternItemDefinitions.add(new GridPatternItemDefinition(1, 2, 1, 1));
//		gridPatternItemDefinitions.add(new GridPatternItemDefinition(2, 0, 1, 1));
//		gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
//		gridPatternItemDefinitions.clear();
		
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
		gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
		gridPatternItemDefinitions.clear();
		
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
		gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
		gridPatternItemDefinitions.clear();
		
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
		gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
		gridPatternItemDefinitions.clear();
		
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
		gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
		gridPatternItemDefinitions.clear();
		
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
		gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
		gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
		gridPatternItemDefinitions.clear();
		
		AdapterRectangle adapter = new AdapterRectangle(this, 6);
		gridPatternView.setAdapter(adapter);
	}	
}
