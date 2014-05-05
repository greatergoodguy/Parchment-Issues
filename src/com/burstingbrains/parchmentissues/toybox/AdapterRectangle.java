package com.burstingbrains.parchmentissues.toybox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.burstingbrains.parchmentissues.R;

public class AdapterRectangle extends BaseAdapter {
	
	Context context;
	int size;
	
	public AdapterRectangle(Context context, int size) {
		this.context = context;
		this.size = size;
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
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
				
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.view_rectangle_2, null);
		}
		
		return convertView;
	}

}
