package com.burstingbrains.parchmentissues;

import java.util.ArrayList;
import java.util.List;

import mobi.parchment.widget.adapterview.gridpatternview.GridPatternItemDefinition;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.burstingbrains.parchmentissues.toybox.AdapterRectangle;
import com.burstingbrains.parchmentissues.toybox.GridPatternView_WithPinchZoom;

public class ActivityGPVZoom extends ActivityMainMenu {

	public static final float SCALE_FACTOR_DEFAULT = 1.0f;
	public static final float SCALE_FACTOR_MAX = 5.0f;
	public static final float SCALE_FACTOR_MIN = 0.1f;
	
	public static final float SCALE_FACTOR_THRESHOLD_ZOOM_IN = 1.05f;
	public static final float SCALE_FACTOR_THRESHOLD_ZOOM_OUT = 0.95f;
	
	enum ZoomLevel {
		ZOOM_MINUS_2 {
	        @Override
	        public ZoomLevel prev() {
	            return ZOOM_MINUS_2;
	        };
	    },
		ZOOM_MINUS_1,
		ZOOM_DEFAULT,
		ZOOM_PLUS_1,
		ZOOM_PLUS_2	{
	        @Override
	        public ZoomLevel next() {
	            return ZOOM_PLUS_2;
	        };
	    };

	    public ZoomLevel prev() {
	        return values()[ordinal() - 1];
	    }
	    
		public ZoomLevel next() {
	        return values()[ordinal() + 1];
	    }
	};
	
    GridPatternView_WithPinchZoom gridPatternView;
    AdapterRectangle adapter;
    
    ZoomLevel zoomLevel = ZoomLevel.ZOOM_DEFAULT;
    
    Handler handler = new Handler();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpvzoom);

        gridPatternView = (GridPatternView_WithPinchZoom) findViewById(R.id.gpvzoom_gpv);
        gridPatternView.setSimpleOnScaleGestureListener(onScaleGestureListener);

        gridPatternView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ActivityGPVZoom.this, "Clicked: Position: " + position, Toast.LENGTH_SHORT).show();
				
//				Intent intent = new Intent(getApplicationContext(), ActivitySandbox.class);
//				startActivity(intent);
			}
		});
        
        final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();
        
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        adapter = new AdapterRectangle(this, 0);
        gridPatternView.setAdapter(adapter);
        
        zoomDefault();
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	handler.post(runnableTicker);
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	handler.removeCallbacks(runnableTicker);
    }
    
    
    // =============
    // Zoom Methods
    // =============
    public void zoomMinus2() {
    	final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();
    	gridPatternView.clear();
    	
    	gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(1, 0, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        adapter.setSizeAndNotifyDataSetChanged(7);
    }
    
    public void zoomMinus1() {
    	final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();
    	gridPatternView.clear();
    	
    	gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(1, 0, 2, 2));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        adapter.setSizeAndNotifyDataSetChanged(7);
    }
    
    public void zoomDefault() {
    	final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();
    	gridPatternView.clear();
    	
    	gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 2, 2));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 2, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(1, 2, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 1, 2, 2));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(1, 0, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 3, 3));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        adapter.setSizeAndNotifyDataSetChanged(7);
    }
    
    public void zoomPlus1() {
    	final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();
    	gridPatternView.clear();
    	
    	gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 2, 2));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(2, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(2, 1, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 2, 2));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(2, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(2, 1, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
		
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternView.addGridPatternGroupDefinition(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
        
        adapter.setSizeAndNotifyDataSetChanged(7);	
    }
    
    public void zoomPlus2() {
    	final List<GridPatternItemDefinition> gridPatternItemDefinitions = new ArrayList<GridPatternItemDefinition>();
    	gridPatternView.clear();
    	
    	gridPatternItemDefinitions.add(new GridPatternItemDefinition(0, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(1, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(2, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(3, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(4, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(5, 0, 1, 1));
        gridPatternItemDefinitions.add(new GridPatternItemDefinition(6, 0, 1, 1));
        gridPatternView.add(gridPatternItemDefinitions);
        gridPatternItemDefinitions.clear();
		
        adapter.setSizeAndNotifyDataSetChanged(7);	
    }
    
	// ====================
	// Runnable
	// ====================
	private Runnable runnableTicker = new Runnable() {
		@Override public void run() {
			Log.d("ActivityGPVZoom", "tick()");
			adapter.notifyDataSetChanged();
			handler.postDelayed(runnableTicker, 1000);
		}
	};
    
    // ==================================
    // Simple On Scale Gesture Listener
    // ==================================
    SimpleOnScaleGestureListener onScaleGestureListener = new SimpleOnScaleGestureListener() {
    	
    	float scaleFactor = SCALE_FACTOR_DEFAULT;
    	
    	@Override
    	public boolean onScaleBegin(ScaleGestureDetector detector) {
    		Log.d("ActivityGPVZoom", "onScaleBegin()");
    		
    		scaleFactor = SCALE_FACTOR_DEFAULT;
    		return true;
    	}
    	
    	@Override
    	public boolean onScale(ScaleGestureDetector detector) {
    		scaleFactor *= detector.getScaleFactor();
    		scaleFactor = Math.max(SCALE_FACTOR_MIN, Math.min(scaleFactor, SCALE_FACTOR_MAX));
    		return true;
    	}
    	
    	@Override
    	public void onScaleEnd(ScaleGestureDetector detector) {
    		Log.d("ActivityGPVZoom", "onScaleEnd(): " + scaleFactor);
    		
    		if(scaleFactor >= SCALE_FACTOR_THRESHOLD_ZOOM_IN) {
    			zoomLevel = zoomLevel.next();}
			else if(scaleFactor <= SCALE_FACTOR_THRESHOLD_ZOOM_OUT) {
				zoomLevel = zoomLevel.prev();}
    		
    		switch (zoomLevel) {
			case ZOOM_MINUS_2:
				Log.d("ActivityGPVZoom", "ZOOM_MINUS_2");
				zoomMinus2();
				break;

			case ZOOM_MINUS_1:
				Log.d("ActivityGPVZoom", "ZOOM_MINUS_1");
				zoomMinus1();
				break;
				
			case ZOOM_DEFAULT:
				Log.d("ActivityGPVZoom", "ZOOM_DEFAULT");
				zoomDefault();
				break;
				
			case ZOOM_PLUS_1:
				Log.d("ActivityGPVZoom", "ZOOM_PLUS_1");
				zoomPlus1();
				break;
				
			case ZOOM_PLUS_2:
				Log.d("ActivityGPVZoom", "ZOOM_PLUS_2");
				zoomPlus2();
				break;
				
			default:
				break;
			}
    	}
    };
}