package com.burstingbrains.parchmentissues.toybox;

import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.burstingbrains.parchmentissues.R;

public class AdapterRectangle extends BaseAdapter {
	
	Context context;
	int size;
	
	int offset;
	boolean hasStableIds;
	
	public AdapterRectangle(Context context, int size) {
		this.context = context;
		this.size = size;
		
		offset = 0;
		hasStableIds = false;
	}
	
	public void setSizeAndNotifyDataSetChanged(int size) {
		this.size = size;
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return size;
	}

	@Override
	public Integer getItem(int position) {
		return position + offset;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
				
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.view_rectangle, null);
		}
		
		Random random = new Random(); 
		int colorHex = Color.argb(200, random.nextInt(256), random.nextInt(256), random.nextInt(256));
		LinearLayout llInnerRect = (LinearLayout) convertView.findViewById(R.id.view_rectangle_innerRect);
		llInnerRect.setBackgroundColor(colorHex);
		
		int itemAsInt = getItem(position);
		TextView tvText = (TextView) convertView.findViewById(R.id.view_rectangle_text);
		tvText.setText("Value: " + itemAsInt);
		
		return convertView;
	}
	
	@Override
	public boolean hasStableIds() {
		return hasStableIds;
	}

	public void setHasStableIds(boolean hasStableIds) {
		this.hasStableIds = hasStableIds;
	}
	
	public void increaseOffsetAndNotifyDataSetChanged() {
		offset++;
		notifyDataSetChanged();
	}
}
