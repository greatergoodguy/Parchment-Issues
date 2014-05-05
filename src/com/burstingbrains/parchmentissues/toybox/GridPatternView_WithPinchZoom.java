package com.burstingbrains.parchmentissues.toybox;

import mobi.parchment.widget.adapterview.gridpatternview.GridPatternView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.BaseAdapter;

public class GridPatternView_WithPinchZoom extends GridPatternView<BaseAdapter> {

	public static final float SCALE_FACTOR_DEFAULT = 1.0f;
	public static final float SCALE_FACTOR_MAX = 5.0f;
	public static final float SCALE_FACTOR_MIN = 0.1f;
	
	protected final String TAG = getClass().getSimpleName();
	
	ScaleGestureDetector scaleDetectorDeflector;
	SimpleOnScaleGestureListener scaleGestureListenerAcceptor;

	boolean isScaling = false;
	float scaleFactor = SCALE_FACTOR_DEFAULT;
	
    public GridPatternView_WithPinchZoom(Context context) {
        super(context);
        initView();
    }

    public GridPatternView_WithPinchZoom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public GridPatternView_WithPinchZoom(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        initView();
    }
    
    public void initView() {
    	scaleDetectorDeflector = new ScaleGestureDetector(getContext(), new SimpleOnScaleGestureListener() {
			
			@Override
			public boolean onScale(ScaleGestureDetector detector) {
				scaleFactor *= detector.getScaleFactor();
				// Don't let the object get too small or too large.
				scaleFactor = Math.max(SCALE_FACTOR_MIN, Math.min(scaleFactor, SCALE_FACTOR_MAX));
				
				if(scaleGestureListenerAcceptor == null) {
					return true;}
				
				return scaleGestureListenerAcceptor.onScale(detector);
			}

			@Override
			public boolean onScaleBegin(ScaleGestureDetector detector) {
				//UtilLogger.logInfo(TAG, "onScaleBegin()");
				isScaling = true;
				scaleFactor = SCALE_FACTOR_DEFAULT;
				
				if(scaleGestureListenerAcceptor == null) {
					return true;}
				
				return scaleGestureListenerAcceptor.onScaleBegin(detector);
			}

			@Override
			public void onScaleEnd(ScaleGestureDetector detector) {
				//UtilLogger.logInfo(TAG, "onScaleEnd()");
				isScaling = false;
				
				if(scaleGestureListenerAcceptor == null) {
					return;}
				
				scaleGestureListenerAcceptor.onScaleEnd(detector);
				
			}
		});
    }
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		scaleDetectorDeflector.onTouchEvent(ev);
		if(isScaling) {
			return true;}

		boolean result = super.onTouchEvent(ev);
		return result;
	}
    
    public void setSimpleOnScaleGestureListener(SimpleOnScaleGestureListener scaleGestureListenerAcceptor) {
		this.scaleGestureListenerAcceptor = scaleGestureListenerAcceptor;
	}
}
